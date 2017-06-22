package com.breeze.tpsearchawsprototype.cloudsearch;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomain;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClientBuilder;
import com.amazonaws.services.cloudsearchdomain.model.ContentType;
import com.amazonaws.services.cloudsearchdomain.model.UploadDocumentsRequest;
import com.amazonaws.services.cloudsearchdomain.model.UploadDocumentsResult;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearch;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchClient;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchClientBuilder;
import com.breeze.tpsearchawsprototype.ParsedDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Endpoint;
import java.util.UUID;

public class CloudSearchDocumentUploader {

    private static final Logger logger = LoggerFactory.getLogger(CloudSearchDocumentUploader.class);

    private final AmazonCloudSearchDomain client;
    private final ObjectMapper objectMapper;

    private final AWSCredentialsProvider credentialsProvider;
    private final AwsClientBuilder.EndpointConfiguration endpointConfiguration;

    public CloudSearchDocumentUploader(String accessKey, String secretKey, String serviceEndpoint, Regions region) {
        AWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
        credentialsProvider = new AWSStaticCredentialsProvider(creds);
        endpointConfiguration =
                new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, region.getName());
        client = createClient();

        objectMapper = new ObjectMapper();
    }

    public void uploadBlogDoc(CloudSearchParsedDocument doc) {
        String type = "add";
        String id = UUID.randomUUID().toString();
        BlogDocumentUploadRequest request = new BlogDocumentUploadRequest(type, id, doc);
        UploadDocumentRequests requests = new UploadDocumentRequests(request);
        UploadDocumentsRequest uploadDocumentRequest = new UploadDocumentsRequest();
        uploadDocumentRequest
                .withContentType(ContentType.Applicationjson)
                .withContentLength(requests.bytesLength())
                .withDocuments(requests.inputStream());
        UploadDocumentsResult response = client.uploadDocuments(uploadDocumentRequest);
        logger.debug(response.toString());

        client.shutdown();
    }

    private AmazonCloudSearchDomain createClient() {
        return AmazonCloudSearchDomainClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withEndpointConfiguration(endpointConfiguration).build();
    }
}

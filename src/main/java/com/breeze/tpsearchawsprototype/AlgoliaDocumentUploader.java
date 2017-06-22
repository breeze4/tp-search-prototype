package com.breeze.tpsearchawsprototype;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class AlgoliaDocumentUploader {

    private final APIClient client;

    public AlgoliaDocumentUploader(String applicationId, String apiKey) {
        client = new ApacheAPIClientBuilder(applicationId, apiKey).build();
    }

    public void uploadBlogDoc(ParsedDocument doc) {
        Index<ParsedDocument> blogIndex = client.initIndex("blog", ParsedDocument.class);

        try {
            blogIndex.addObject(doc);
        } catch (AlgoliaException e) {
            e.printStackTrace();
        }
    }
}

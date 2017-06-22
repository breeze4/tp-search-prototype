package com.breeze.tpsearchawsprototype;

import com.amazonaws.regions.Regions;
import com.breeze.tpsearchawsprototype.cloudsearch.CloudSearchDocumentUploader;
import com.breeze.tpsearchawsprototype.cloudsearch.CloudSearchParsedDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudSearchUploaderTests {

    @Value("${cloudsearch.accessKey}")
    private String ACCESS_KEY;
    @Value("${cloudsearch.secretKey}")
    private String SECRET_KEY;
    @Value("${cloudsearch.docEndpoint}")
    private String DOC_ENDPOINT;


    @Test
    public void testParsingTableauPublicBlog() {
        String url = "https://public.tableau.com/s/blog/2017/06/new-feature-favorite-viz";
        ScrapedDocument scrapedDocument = Scraper.scrapeUrl(url);
        CloudSearchParsedDocument parsedDocument = Parser.parseAWSDocument(scrapedDocument);

        CloudSearchDocumentUploader uploader = new CloudSearchDocumentUploader(ACCESS_KEY, SECRET_KEY,
                DOC_ENDPOINT, Regions.US_WEST_2);
        uploader.uploadBlogDoc(parsedDocument);
    }
}

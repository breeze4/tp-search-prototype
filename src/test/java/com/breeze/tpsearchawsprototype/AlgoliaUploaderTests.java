package com.breeze.tpsearchawsprototype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgoliaUploaderTests {

    @Value("${algolia.applicationId}")
    private String APPLICATION_ID;
    @Value("${algolia.apiKey}")
    private String API_KEY; // secret

    @Test
    public void testParsingTableauPublicBlog() {
        String url = "https://public.tableau.com/s/blog/2017/06/new-feature-favorite-viz";
        ScrapedDocument scrapedDocument = Scraper.scrapeUrl(url);
        ParsedDocument parsedDocument = Parser.parseDocument(scrapedDocument);

        AlgoliaDocumentUploader uploader = new AlgoliaDocumentUploader(APPLICATION_ID, API_KEY);
        uploader.uploadBlogDoc(parsedDocument);
    }
}

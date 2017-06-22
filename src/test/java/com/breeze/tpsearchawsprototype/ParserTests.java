package com.breeze.tpsearchawsprototype;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ParserTests {

    @Test
    public void testParsingTableauPublicBlog() {
        String url = "https://public.tableau.com/s/blog/2017/06/new-feature-favorite-viz";
        ScrapedDocument scrapedDocument = Scraper.scrapeUrl(url);
        ParsedDocument parsedDocument = Parser.parseDocument(scrapedDocument);

        Assert.assertEquals("New Feature: Favorite a Viz!", parsedDocument.getTitle());
        Assert.assertEquals("Ben Jones", parsedDocument.getAuthor());
        Assert.assertTrue(parsedDocument.getContents().contains("Great news for Tableau Public authors"));
        Assert.assertEquals(LocalDate.of(2017, 6, 14), parsedDocument.getPostedDate());

        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File("D:\\temp\\json\\blog.json"), parsedDocument);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.breeze.tpsearchawsprototype;

import org.junit.Assert;
import org.junit.Test;

public class ScraperTests {

    @Test
    public void testScrapingTableauPublicBlog() {
        String url = "https://public.tableau.com/s/blog/2017/06/new-feature-favorite-viz";
        ScrapedDocument actualDoc = Scraper.scrapeUrl(url);
        Assert.assertTrue(actualDoc.getHtml().body().html().contains("Great news for Tableau Public authors"));
    }
}

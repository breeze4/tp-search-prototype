package com.breeze.tpsearchawsprototype;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scraper {

    public static ScrapedDocument scrapeUrl(String url) {
        return scrapeUrlWithJSoup(url);
    }

    public static ScrapedDocument scrapeUrlWithJSoup(String url) {
        ScrapedDocument doc = null;
        try {
            Document jsoupDoc = Jsoup.connect(url).get();
            doc = new ScrapedDocument(url, jsoupDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

}

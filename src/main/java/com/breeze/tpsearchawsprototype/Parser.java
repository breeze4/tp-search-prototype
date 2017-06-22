package com.breeze.tpsearchawsprototype;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Parser {

    public static ParsedDocument parseDocument(ScrapedDocument scrapedDocument) {
        Document doc = scrapedDocument.getHtml();
        String title = doc.select(".field--title").text();
        String contents = doc.select(".field--body").text();
        Elements elements = doc.select(".field--author");
        List<TextNode> textNodes = elements.get(0).textNodes();
        String author = textNodes.get(0).text();
        // June 14, 2017
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate postedDate = LocalDate.parse(doc.select(".date-display-single").text(), formatter);
        return new ParsedDocument(scrapedDocument, scrapedDocument.getSourceUrl(),
                title, contents, author, postedDate);
    }
}

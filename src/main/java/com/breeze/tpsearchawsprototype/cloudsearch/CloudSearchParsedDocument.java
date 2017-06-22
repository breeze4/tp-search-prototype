package com.breeze.tpsearchawsprototype.cloudsearch;

import com.breeze.tpsearchawsprototype.ScrapedDocument;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CloudSearchParsedDocument {

    private final ScrapedDocument scrapedDocument;

    private final String sourceUrl;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDate postedDate;

    // tags? # of shares?
    @JsonCreator
    public CloudSearchParsedDocument(ScrapedDocument scrapedDocument,
                                     @JsonProperty("source_url") String sourceUrl,
                                     @JsonProperty String title,
                                     @JsonProperty String content,
                                     @JsonProperty String author,
                                     @JsonProperty("posted_date") LocalDate postedDate) {
        this.scrapedDocument = scrapedDocument;
        this.sourceUrl = sourceUrl;
        this.title = title;
        this.content = content;
        this.author = author;
        this.postedDate = postedDate;
    }

    @JsonProperty("source_url")
    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @JsonProperty("posted_date")
    public String getPostedDate() {
        return postedDate.toString();
    }

    @JsonIgnore
    public ScrapedDocument getScrapedDocument() {
        return scrapedDocument;
    }
}

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
    private final String contents;
    private final String author;
    private final LocalDate postedDate;

    // tags? # of shares?
    @JsonCreator
    public CloudSearchParsedDocument(ScrapedDocument scrapedDocument,
                                     @JsonProperty("source_url") String sourceUrl,
                                     @JsonProperty String title,
                                     @JsonProperty String contents,
                                     @JsonProperty String author,
                                     @JsonProperty("posted_date") LocalDate postedDate) {
        this.scrapedDocument = scrapedDocument;
        this.sourceUrl = sourceUrl;
        this.title = title;
        this.contents = contents;
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

    public String getContents() {
        return contents;
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

package com.breeze.tpsearchawsprototype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ParsedDocument {

    private final ScrapedDocument scrapedDocument;

    private final String sourceUrl;
    private final String title;
    private final String contents;
    private final String author;
    private final LocalDate postedDate;

    // tags? # of shares?
    @JsonCreator
    public ParsedDocument(ScrapedDocument scrapedDocument,
                          @JsonProperty String sourceUrl,
                          @JsonProperty String title,
                          @JsonProperty String contents,
                          @JsonProperty String author,
                          @JsonProperty LocalDate postedDate) {
        this.scrapedDocument = scrapedDocument;
        this.sourceUrl = sourceUrl;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.postedDate = postedDate;
    }

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

    public LocalDate getPostedDate() {
        return postedDate;
    }

    @JsonIgnore
    public ScrapedDocument getScrapedDocument() {
        return scrapedDocument;
    }
}

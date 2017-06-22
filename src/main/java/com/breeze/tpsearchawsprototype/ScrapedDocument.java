package com.breeze.tpsearchawsprototype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsoup.nodes.Document;

public class ScrapedDocument {

    private final String sourceUrl;
    private final Document html;

    public ScrapedDocument(String sourceUrl, Document html) {
        this.sourceUrl = sourceUrl;
        this.html = html;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public Document getHtml() {
        return html;
    }
}

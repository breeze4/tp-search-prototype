package com.breeze.tpsearchawsprototype.cloudsearch;

import com.breeze.tpsearchawsprototype.ParsedDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogDocumentUploadRequest {

    private final String type;
    private final String id;
    private final CloudSearchParsedDocument fields;

    public BlogDocumentUploadRequest(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("fields") CloudSearchParsedDocument fields) {
        this.type = type;
        this.id = id;
        this.fields = fields;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("fields")
    public CloudSearchParsedDocument getDoc() {
        return fields;
    }
}

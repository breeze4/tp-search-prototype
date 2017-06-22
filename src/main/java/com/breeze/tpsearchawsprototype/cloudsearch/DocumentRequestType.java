package com.breeze.tpsearchawsprototype.cloudsearch;

public enum DocumentRequestType {

    ADD("add"),
    DELETE("delete");

    String value;

    DocumentRequestType(String value) {
        this.value = value;
    }

    public String asText() {
        return value;
    }
}

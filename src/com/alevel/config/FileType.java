package com.alevel.config;

public enum FileType {

    JSON_TYPE("books.json"),
    CSV_TYPE("books.csv");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

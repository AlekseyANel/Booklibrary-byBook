package com.alevel.essence;

import java.util.List;

public class Book {
    private String id;
    private String name;
    private List<String> authorList;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthorList() {
        return authorList;
    }
    public void setAuthorList(List<String> authorList) {
        this.authorList = authorList;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + authorList + '\''+
                '}';
    }
}

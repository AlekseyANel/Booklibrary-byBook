package com.alevel.dao;

import com.alevel.essence.Book;

import java.util.List;

public interface BookDao {

    void create(Book book);
    void update(Book book);
    void delete(String id);
    //Book findById(String id);
    List<Book> findAll();
    List<String> authorsByBookId(String id);
}

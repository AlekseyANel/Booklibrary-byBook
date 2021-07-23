package com.alevel.dao;

import com.alevel.essence.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDaoImpM implements BookDao {
    private List<Book> books = new ArrayList<>();

    @Override
    public void create(Book book) {
        book.setId(generateId());
        books.add(book);
    }
    // Генерация случайной строки для ID
    private  String generateId() {
        String id = UUID.randomUUID().toString();//сгенерировать случайную строку для поля Id
        for (Book i : books) {//пройтись по массиву, проверить наличие дубликатов
            if (i.getId().equals(id)) {
                return generateId();//если есть то повторить метод
            }
        }
        return id;//если нет то сам id,  сохранить/оставить его
    }
    //

    @Override
    public void update(Book book) {//переписать старый на новый элемент из списка books
        //получить отфильтрованную коллекцию из одного элемента/книги
        Book current = books.stream().filter(u -> u.getId().equals(book.getId())).findAny().get();
        current.setName(book.getName());
        current.setAuthorList(book.getAuthorList());
    }

    @Override
    public void delete(String id) {
        books.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public List<String> authorsByBookId(String id) {
        for (Book i : books) {//пройтись по массиву, проверить наличие дубликатов
            if (i.getId().equals(id)) {
                return i.getAuthorList();
            }
        }
        return null;
    }

    /*@Override
    public Book findById(String id) {
        return books.stream().filter(u -> u.getId().equals(id)).findAny().get();
    }*/

    @Override
    public List<Book> findAll() {
        return books;
    }




}

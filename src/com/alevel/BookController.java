package com.alevel;

import com.alevel.dao.BookDao;
import com.alevel.dao.BookDaoImpM;
import com.alevel.essence.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {

    private final BookDao bookDao = new BookDaoImpM();


    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : authorsByBookId(reader); break;
            case "5" : findAll(); break;
        }
        runNavigation();
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create book, please enter 1");
        System.out.println("if you want update book, please enter 2");
        System.out.println("if you want delete book, please enter 3");
        System.out.println("find authorsByBookId book, please enter 4");
        System.out.println("if you want findAll book, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void create(BufferedReader reader) {
        System.out.println("BookController.create");
        try {
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            //Захват массива авторов, в конце надо "стоп".
            System.out.println("Please, enter all book authors. The end - type 'stop'");
            Scanner scanner = new Scanner(System.in);
            List<String> stringList = new ArrayList<>();
            String srtFromCons;
            while (!(srtFromCons = scanner.nextLine()).equals("stop"))
                stringList.add(srtFromCons);
           //
            Book book = new Book();
            book.setName(name);
            book.setAuthorList(stringList);
            bookDao.create(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }

    }


    private void update(BufferedReader reader) {
        System.out.println("BookController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            //Захват массива авторов, в конце надо "стоп".
            System.out.println("Please, enter all book authors. The end - type 'stop'");
            Scanner scanner = new Scanner(System.in);
            List<String> stringList = new ArrayList<>();
            String srtFromCons;
            while (!(srtFromCons = scanner.nextLine()).equals("stop"))
                stringList.add(srtFromCons);
            //
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthorList(stringList);
            bookDao.update(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("BookController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            bookDao.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }
    private void authorsByBookId(BufferedReader reader) {
        System.out.println("BookController.authorsByBookId");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            List<String> authors = bookDao.authorsByBookId(id);
            System.out.println("authors = " + authors);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll() {
        System.out.println("BookController.findAll");
        List<Book> books = bookDao.findAll();
        for (Book b : books) {
            System.out.println("book = " + b);
        }
    }
      /*private void findById(BufferedReader reader) {
        System.out.println("BookController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();

            Book book = bookDao.findById(id);
            System.out.println("book = " + book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }*/



}

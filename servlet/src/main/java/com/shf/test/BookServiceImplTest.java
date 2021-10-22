package com.shf.test;

import com.shf.pojo.Book;
import com.shf.pojo.Page;
import com.shf.service.BookService;
import com.shf.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有","1125",new BigDecimal("10000"),0,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"人狠话不多","1125",new BigDecimal("10000"),11110,11,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(24);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(2,4));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(0, Page.PAGE_SIZE,10,50));
    }
}
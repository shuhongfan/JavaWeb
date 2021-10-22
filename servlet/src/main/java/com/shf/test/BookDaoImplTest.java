package com.shf.test;

import com.shf.dao.BookDao;
import com.shf.dao.impl.BookDaoImpl;
import com.shf.pojo.Book;
import com.shf.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "三毛流浪记1", "191125", new BigDecimal(9999), 110000, 10, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(22);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookDao.updateBook(new Book(22, "妲己", "191125", new BigDecimal(90), 0, 10, null));
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        Integer count = bookDao.queryForPageTotalCount();
        System.out.println(count);
    }

    @Test
    public void queryForPageItems() {
        for (Book b:bookDao.queryForPageItems(8,4)){
            System.out.println(b);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        Integer count = bookDao.queryForPageTotalCountByPrice(10, 50);
        System.out.println(count);
    }

    @Test
    public void queryForPageItemsByPrice(){
        List<Book> books = bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10, 50);
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
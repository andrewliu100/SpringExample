/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.service.BookService
 *
 * @author Andrew Liu
 * @since 2015 8/10/2015 11:40 AM
 */
package com.geekspearls.mvc.jackson.server.service;

import com.geekspearls.mvc.jackson.server.dao.BookDao;
import com.geekspearls.mvc.jackson.server.model.AbstractBook;
import com.geekspearls.mvc.jackson.server.model.TextBook;
import com.geekspearls.mvc.jackson.server.model.IBook;
import com.geekspearls.mvc.jackson.server.model.InStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Andrew
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public InStock getInStock() {
        InStock inStock = new InStock();
        inStock.setStore("Los Angeles Store");

        List<IBook> books = new LinkedList<>();
        books.add(bookDao.getChildrenBook());
        books.add(bookDao.getScienceBook());
        inStock.setBooks(books);

        return inStock;
    }
}

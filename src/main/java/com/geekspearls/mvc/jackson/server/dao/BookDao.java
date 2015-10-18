package com.geekspearls.mvc.jackson.server.dao;

import com.geekspearls.mvc.jackson.server.model.ChildrenBook;
import com.geekspearls.mvc.jackson.server.model.IBook;
import com.geekspearls.mvc.jackson.server.model.TextBook;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * A simplified DAO class. It creates the objects instead of retrieving from a real DB.
 *
 * Created by Andrew on 17/10/2015.
 */
@Component
public class BookDao {

    public IBook getScienceBook() {
        TextBook book = new TextBook();
        book.setTitle("Database Systems");
        book.setIsbn("1-84356-028-3");
        book.setSubject("Computer Science");

        Map<String, Object> properties = new HashMap<>();
        properties.put("Pages", 560);
        properties.put("Price", 146.16f);
        properties.put("Currency", "USD");
        properties.put("Type", "HardCover");

        book.setProperties(properties);

        return book;
    }

    public IBook getChildrenBook() {
        ChildrenBook book = new ChildrenBook();
        book.setTitle("Giraffes Can't Dance");
        book.setIsbn("1-84356-568-3");
        book.setMinAge(1);
        book.setMinAge(3);

        Map<String, Object> properties = new Hashtable<>();
        properties.put("Pages", 10);
        properties.put("Price", 4.42f);
        properties.put("Currency", "USD");
        properties.put("Type", "Board book");

        book.setProperties(properties);

        return book;
    }
}

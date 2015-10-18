/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.controller.BookController
 *
 * @author Andrew Liu
 * @since 2015 9/10/2015 9:28 PM
 */
package com.geekspearls.mvc.jackson.server.controller;

import com.geekspearls.mvc.jackson.server.model.InStock;
import com.geekspearls.mvc.jackson.server.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrew
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/in_stock")
    public ResponseEntity<InStock> getInStock() {
        InStock inStock = bookService.getInStock();
        return new ResponseEntity<>(inStock, HttpStatus.OK);
    }
}

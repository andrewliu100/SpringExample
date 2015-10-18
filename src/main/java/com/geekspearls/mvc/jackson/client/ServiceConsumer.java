package com.geekspearls.mvc.jackson.client;

import com.geekspearls.mvc.jackson.common.ObjectMapperFactory;
import com.geekspearls.mvc.jackson.server.model.IBook;
import com.geekspearls.mvc.jackson.server.model.InStock;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple client class to consume REST services.
 *
 * Created by Andrew on 17/10/2015.
 */
public class ServiceConsumer {

    private static final String REST_ENDPOINT = "http://localhost:8080/rest/api";

    public InStock getInStock() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setObjectMapper(ObjectMapperFactory.getObjectMapper());
        converters.add(jackson2HttpMessageConverter);
        RestOperations operations = new RestTemplate(converters);
        InStock s = operations.getForObject(REST_ENDPOINT + "/book/in_stock", InStock.class);;
        return s;
    }
}

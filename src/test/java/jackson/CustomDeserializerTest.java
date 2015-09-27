/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo jackson.CustomDeserializerTest
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:35 PM
 */
package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.geekspearls.jackson.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author Andrew
 */
public class CustomDeserializerTest {

    private Shelf shelf;

    @BeforeClass
    public void init() {
        Map<Object, Object> review1 = new Hashtable<>();
        review1.put("test1", "review1");
        review1.put("Int1", Integer.valueOf(111));
        review1.put("Float1", Float.valueOf(0.1f));
        review1.put("date1", new Date());
        Map<Object, Object> review2 = new HashMap<>();
        review2.put("test2", "review1");
        review2.put("Int2", Integer.valueOf(222));
        review2.put("Float2", Float.valueOf(0.2f));
        review2.put("date2", new Date());


        List<IBook> books = new LinkedList<>();
        books.add(new Book(review1));
        books.add(new Book(review2));
        shelf = new Shelf();
        shelf.setName("TestShelf");
        shelf.setBooks(books);
    }

    @Test
    public void testCustomDeserializer() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SimpleModule module = new SimpleModule();
//        module.addDeserializer(Object.class, new MapValueDeserializer());
//        module.addDeserializer(Shelf.class, new CustomDeserializer());
        mapper.registerModule(module);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        String json = mapper.writeValueAsString(shelf);
        System.out.println(json);

        Shelf sh = mapper.readValue(json, Shelf.class);
        for (IBook b : sh.getBooks()) {
            System.out.println(b.getReviews().getClass());
        }
        System.out.println(sh.toString());
    }


}

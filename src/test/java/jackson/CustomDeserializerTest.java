/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo jackson.CustomDeserializerTest
 *
 * @author Andrew Liu
 * @since 2015 25/09/2015 7:35 PM
 */
package jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.geekspearls.mvc.jackson.server.custom.MapTypeIdResolverBuilder;
import com.geekspearls.mvc.jackson.server.model.InStock;
import com.geekspearls.mvc.jackson.server.model.TextBook;
import com.geekspearls.mvc.jackson.server.model.IBook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author Andrew
 */
public class CustomDeserializerTest {

    private InStock inStock;

    @BeforeClass
    public void init() {
        List<IBook> books = new LinkedList<>();
        books.add(new TextBook());
        books.add(new TextBook());
        inStock = new InStock();
        inStock.setStore("TestStore");
        inStock.setBooks(books);
    }

    @Test
    public void testCustomDeserializer() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        MapTypeIdResolverBuilder customTypeResolverBuilder = new MapTypeIdResolverBuilder();
        customTypeResolverBuilder.init(JsonTypeInfo.Id.CLASS, null);
        customTypeResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);
        mapper.setDefaultTyping(customTypeResolverBuilder);
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(Object.class, new MapValueDeserializer());
//        module.addDeserializer(InStock.class, new CustomDeserializer());
//        mapper.registerModule(module);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
        String json = mapper.writeValueAsString(inStock);
        System.out.println(json);

        InStock sh = mapper.readValue(json, InStock.class);
        for (IBook b : sh.getBooks()) {
            System.out.println(b.getProperties().getClass());
        }
        System.out.println(sh.toString());
    }


}

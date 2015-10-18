package jackson;

import com.geekspearls.mvc.jackson.client.ServiceConsumer;
import org.testng.annotations.Test;

/**
 * Created by Andrew on 17/10/2015.
 */
public class RestTest {

    @Test
    public void testGetShelf() {
        ServiceConsumer consumer = new ServiceConsumer();
        System.out.print(consumer.getInStock());
    }
}

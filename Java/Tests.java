import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Ameer on 10/14/16.
 */
public class Tests
{

    @Test
    public void justRun()
    {
        LineItem item1=new LineItem(1,1,1);
        LineItem item2=new LineItem(2,2,2);
        ArrayList<LineItem> list=new ArrayList<>();
        list.add(item1);
        list.add(item2);
        LineItemList listObject=new LineItemList();
        listObject.setLineItems(list);

        Order order=new Order(listObject);
        order.writeOrder(new PrintWriter(new Writer()
        {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException
            {

            }

            @Override
            public void flush() throws IOException
            {

            }

            @Override
            public void close() throws IOException
            {

            }
        }));
    }
}

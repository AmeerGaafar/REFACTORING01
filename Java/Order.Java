import java.io.*;
import java.util.*;
import java.sql.*;

public class Order
{
    private LineItemList lineItemList;

    public Order(LineItemList lis)
    {
        lineItemList = lis;
    }

    // writes this order object to the specified print writer
    public void writeOrder(PrintWriter pw)
    {
        // get a vector of line items
        ArrayList<LineItem> lineItems = getLineItemList().getLineItems();

        // ------------------------------------------------------
        // calculate total
        // ------------------------------------------------------
        // create an iterator for the vector
        // set total to zero
        int total = 0;

        for (LineItem item:lineItems)
        {
            // calculate total for line item
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int lineitemtotal = unitPrice * qty;

            total += lineitemtotal;
        }
        // ------------------------------------------------------
        // END calculate total
        // ------------------------------------------------------

        // ------------------------------------------------------
        // write order
        // ------------------------------------------------------
        // create an iterator for the vector
        for (LineItem item:lineItems)
        {
            // calculate total for line item
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int productID = item.getProductID();
            int imageID = item.getImageID();
            int lineitemtotal = unitPrice * qty;

            pw.println("Begin Line Item");
            pw.println("Product = " + productID);
            pw.println("Image = " + imageID);
            pw.println("Quantity = " + qty);
            pw.println("Total = " + lineitemtotal);
            pw.println("End Line Item");
        }
        pw.println("Order total = " + total);
    }

    public int getTotal()
    {
        // get a vector of line items
        ArrayList<LineItem> lineItems = lineItemList.getLineItems();
        // create an iterator for the vector
        Iterator iter = lineItems.iterator();
        LineItem item;
        // set total to zero
        int total = 0;
        while (iter.hasNext())
        {
            item = (LineItem) iter.next();

            // calculate total for line item
            // taking discount into consideration
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int lineitemtotal = unitPrice * qty;

            total += lineitemtotal;
        }
        return total;
    }

    /**
     * This method saves the order to the database
     */
    public void saveOrder() throws SQLException
    {
        //We do not need this anymore since the
        // responsibility of saving is with the calling API
    }

    public LineItemList getLineItemList()
    {
        return lineItemList;
    }
}

class LineItemList
{
    private ArrayList<LineItem> LIList;

    public void setLineItems(ArrayList<LineItem> lineItems)
    {
        LIList = lineItems;
    }

    ArrayList<LineItem> getLineItems()
    {
        return LIList;
    }
}

class LineItem
{
    protected int productId;
    private int ImageID;
    private int qty;
    private int Unitprice;

    public LineItem(int prodID, int ImageID, int inQty)
    {
        productId = prodID;
        this.ImageID = ImageID;
        qty = inQty;
    }

    int getProductID()
    {
        return productId;
    }

    int getImageID()
    {
        return ImageID;
    }

    int getQuantity()
    {
        return qty;
    }

    int getUnitPrice()
    {
        return Unitprice;
    }

    public void setProductID(int id)
    {
        productId = id;
    }

    public void setImageID(int ID)
    {
        ImageID = ID;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }

    public void setUnitPrice(int i)
    {
        Unitprice = i;
    }
}

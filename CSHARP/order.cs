using System.Collections.Generic;
using System.IO;

namespace Smells
{
    public class Order
    {
        private LineItemList _lineItemList;

        public Order(LineItemList lis)
        {
            _lineItemList = lis;
        }

        // writes this order object to the specified print writer
        public void WriteOrder(StreamWriter sw)
        {
            // get a vector of line items
            List<LineItem> lineItems = GetLineItemList().GetLineItems();

            // ------------------------------------------------------
            // calculate total
            // ------------------------------------------------------
            // create an iterator for the vector
            // set total to zero
            int total = 0;
            foreach (var item in lineItems)
            {
                // calculate total for line item
                int unitPrice = item.Unitprice;
                int qty = item.Qty;
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
            foreach (var item in lineItems)
            {
                // calculate total for line item
                int unitPrice = item.Unitprice;
                int qty = item.Qty;
                int productID = item.ProductId;
                int imageID = item.ImageId;
                int lineitemtotal = unitPrice * qty;

                sw.WriteLine("Begin Line Item");
                sw.WriteLine("Product = " + productID);
                sw.WriteLine("Image = " + imageID);
                sw.WriteLine("Quantity = " + qty);
                sw.WriteLine("Total = " + lineitemtotal);
                sw.WriteLine("End Line Item");
            }
            sw.WriteLine("Order total = " + total);
        }

        public int GetTotal()
        {
            // get a vector of line items
            List<LineItem> lineItems = _lineItemList.GetLineItems();
            // create an iterator for the vector
            // set total to zero
            int total = 0;
            foreach (var item in lineItems)
            {
                // calculate total for line item
                // taking discount into consideration
                int unitPrice = item.Unitprice;
                int qty = item.Qty;
                int lineitemtotal = unitPrice * qty;

                total += lineitemtotal;
            }
            return total;
        }

        /**
     * This method saves the order to the database
     */
        public void SaveOrder() 
        {
            //We do not need this anymore since the
            // responsibility of saving is with the calling API
        }

        public LineItemList GetLineItemList()
        {
            return _lineItemList;
        }
    }

    public class LineItemList
    {
        private List<LineItem> LIList;

        public void SetLineItems(List<LineItem> lineItems)
        {
            LIList = lineItems;
        }

        public List<LineItem> GetLineItems()
        {
            return LIList;
        }
    }

    public class LineItem
    {
        public int ProductId { get; set; }
        public int ImageId { get; set; }
        public int Qty { get; set; }
        public int Unitprice { get; set; }

        public LineItem(int prodID, int ImageID, int inQty)
        {
            ProductId = prodID;
            this.ImageId = ImageID;
            Qty = inQty;
        }
    }
}


#include <iostream>
#include <vector>

using namespace std;

class LineItem {
private:
    int productId;
    int ImageID;
    int qty;
    int Unitprice;

public:
    LineItem(int prodID, int ImageID, int inQty) {
        productId = prodID;
        ImageID = ImageID;
        qty = inQty;
    }

    int getProductID() {
        return productId;
    }

    int getImageID() {
        return ImageID;
    }

    int getQuantity() {
        return qty;
    }

    int getUnitPrice() {
        return Unitprice;
    }

    void setProductID(int id) {
        productId = id;
    }

    void setImageID(int ID) {
        ImageID = ID;
    }

    void setQty(int qty) {
        this->qty = qty;
    }

    void setUnitPrice(int unitprice) {
        this->Unitprice = unitprice;
    }
};


class LineItemList {
private:
    vector<LineItem> &LIList;

public:

    LineItemList(vector<LineItem> &lineItems) : LIList(lineItems) {}

    vector<LineItem> &getLineItems() {
        return LIList;
    }
};

class Order {
public:
    LineItemList lineItemList;

    Order(LineItemList lis) : lineItemList(lis) {}

    // writes this order object to the specified print writer
    void writeOrder() {
        // get a vector of line items
        vector<LineItem> &lineItems = getLineItemList().getLineItems();

        // ------------------------------------------------------
        // calculate total
        // ------------------------------------------------------
        // create an iterator for the vector
        // set total to zero
        int total = 0;

        for (auto anItem:lineItems)
        {
            // calculate total for line item
            int unitPrice = anItem.getUnitPrice();
            int qty = anItem.getQuantity();
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

        for (auto anItem:lineItems)
        {
            // calculate total for line item
            int unitPrice = anItem.getUnitPrice();
            int qty = anItem.getQuantity();
            int productID = anItem.getProductID();
            int imageID = anItem.getImageID();
            int lineitemtotal = unitPrice * qty;

            cout << "Begin Line Item\n";
            cout << "Product = " << productID << "\n";
            cout << "Image = " << imageID << "\n";
            cout << "Quantity = " << qty << "\n";
            cout << "Total = " << lineitemtotal << "\n";
            cout << "End Line Item" << "\n";
        }
        cout << "Order total = " << total << "\n";
    }

    int getTotal()
    {
        // set total to zero
        int total = 0;

        // get a vector of line items
        vector<LineItem> &lineItems = getLineItemList().getLineItems();
        // create an iterator for the vector
        vector<LineItem>::iterator iter = lineItems.begin();
        for (vector<LineItem>::iterator anItem = iter; anItem != lineItems.end(); anItem++) {

            // calculate total for line item
            // taking discount into consideration

            int unitPrice = anItem->getUnitPrice();
            int qty = anItem->getQuantity();
            int lineitemtotal = unitPrice * qty;

            total += lineitemtotal;
        }

        return total;
    }

    /**
     * This method saves the order to the database
     */
    void saveOrder() {
        //We do not need this anymore since the
        // responsibility of saving is with the calling API
    }

    LineItemList getLineItemList() {
        return lineItemList;
    }
};

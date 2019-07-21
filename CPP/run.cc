#include <iostream>
#include "order.cc"

using namespace std;


int main()
{
    LineItem item1(1,1,1);
    LineItem item2(2,2,2);
    vector<LineItem> list;
    list.push_back(item1);
    list.push_back(item2);
    LineItemList listObject(list);

    Order order(listObject);
    order.writeOrder();
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Smells
{
    [TestClass]
    public class Tests
    {
        [TestMethod]
        public void JustRun()
        {
            LineItem item1 = new LineItem(1, 1, 1);
            LineItem item2 = new LineItem(2, 2, 2);
            List<LineItem> list = new List<LineItem>();
            list.Add(item1);
            list.Add(item2);
            LineItemList listObject = new LineItemList();
            listObject.SetLineItems(list);

            Order order = new Order(listObject);
            order.WriteOrder(new StreamWriter("thefile.txt"));
        }
    }
}

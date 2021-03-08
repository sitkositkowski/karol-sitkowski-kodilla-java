package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {

        //Given

        Product product1 = new Product("product5");
        Product product2 = new Product("product6");
        Product product3 = new Product("product7");
        Product product4 = new Product("product8");

        Item item1 = new Item(product1, new BigDecimal(10.0),2,new BigDecimal(20.0));
        Item item2 = new Item(product1, new BigDecimal(10.0),20,new BigDecimal(200.0));
        Item item3 = new Item(product2, new BigDecimal(12.0),12,new BigDecimal(144.0));
        Item item4 = new Item(product3, new BigDecimal(115.0),2,new BigDecimal(230.0));
        Item item5 = new Item(product4, new BigDecimal(1.0),5,new BigDecimal(5.0));
        Item item6 = new Item(product4, new BigDecimal(1.0),10,new BigDecimal(10.0));

        Invoice invoice1 = new Invoice("1");
        Invoice invoice2 = new Invoice("2");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);
        invoice2.getItems().add(item4);
        invoice2.getItems().add(item5);
        invoice2.getItems().add(item6);

        //When

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);
        itemDao.save(item5);
        itemDao.save(item6);

        invoiceDao.save(invoice1);
        /*
        int invoice1Id = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();

        //Then
        assertNotEquals(0, invoice1Id);
        assertNotEquals(0, invoice2Id);

        //CleanUp
        try {
            invoiceDao.deleteById(invoice1Id);
            invoiceDao.deleteById(invoice2Id);
        } catch (Exception e) {
            //do nothing
        }

         */
    }
}

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

        Item item1 = new Item(new BigDecimal(10.0),2,new BigDecimal(20.0));

        Invoice invoice1 = new Invoice("1");

        item1.setProduct(product1);
        product1.getItems().add(item1);
        item1.setInvoice(invoice1);
        invoice1.getItems().add(item1);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        //Then
        assertNotEquals(0, invoice1Id);

        //CleanUp
        try {
            invoiceDao.deleteById(invoice1Id);
        } catch (Exception e) {
            //do nothing
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Van.Product.Servlet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author User
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(int id, String name, String desc, BigDecimal price)
    {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPriceString() {
        //NumberFormat formatter = new DecimalFormat("#0.00");
        //return formatter.format(price.floatValue());

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(price.longValue());
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}

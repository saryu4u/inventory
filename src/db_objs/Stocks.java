package db_objs;

import java.math.BigDecimal;

public class Stocks {

    private final int id;
    private final String productName;
    private final BigDecimal productPrice;
    private final String productCategory;
    private final int productQuantity;

    public Stocks(int id, String productName, BigDecimal productPrice, String productCategory, int productQuantity) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;

    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

}

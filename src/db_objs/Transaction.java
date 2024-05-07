package db_objs;

import java.math.BigDecimal;
import java.util.Date;

import java.sql.Time;

public class Transaction {

    private final int userId;
    private final int productQuantity;
    private final String transactionType;
    private final BigDecimal productPrice;
    private final String productName;
    private final Date transactionDate;
    private final String seller;
    private final Time time;
    //private final BigDecimal transactionSale;

    public Transaction(int userId, String transactionType, String productName, BigDecimal productPrice, int productQuantity, String seller, Date transactionDate, Time time) {
        this.userId = userId;
        this.productQuantity = productQuantity;
        this.transactionType = transactionType;
        this.productPrice = productPrice;
        this.productName = productName;
        this.transactionDate = transactionDate;
        this.seller = seller;
        this.time = time;

    }

    public Time getTime() {
        return time;
    }

    public int getUserId() {
        return userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getSeller() {
        return seller;
    }
//    public BigDecimal getTransactionSale(){
//        return transactionSale;
//    }

    public int getProductQuantity() {
        return productQuantity;
    }

}

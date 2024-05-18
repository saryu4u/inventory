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
    private final BigDecimal totalPrice;
    private final String paymentMethod, status, preOrder, category, desc, delivery;
    
    //private final BigDecimal transactionSale;

    public Transaction(int userId, String transactionType, String productName, BigDecimal productPrice, int productQuantity, String seller, BigDecimal totalPrice,String paymentMethod,String status,String preOrder,String category, String desc, String delivery,Date transactionDate) {
        this.userId = userId;
        this.productQuantity = productQuantity;
        this.transactionType = transactionType;
        this.productPrice = productPrice;
        this.productName = productName;
        this.transactionDate = transactionDate;
        this.seller = seller;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.preOrder = preOrder;
        this.category = category;
        this.desc = desc;
        this.delivery = delivery;
    }
    public String getDelivery(){
        return delivery;
    }
    
    public String getCategory(){
        return category;
    }
    public String getDesc(){
        return desc;
    }
    
    public BigDecimal getTotalPrice(){
        return totalPrice;
    }
    public String getPreOrderDate(){
        return preOrder;
    }
    public String getPaymentMethod(){
        return paymentMethod;
    }
    public String getStatus(){
        return status;
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

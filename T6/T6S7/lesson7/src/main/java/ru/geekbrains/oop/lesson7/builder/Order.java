package ru.geekbrains.oop.lesson7.builder;

public class Order {

    private String clientName;

    private String companyName;

    private int productId;

    private String productName;

    private int qnt;

    private double price;

    private boolean sign;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public String getClientName() {
        return clientName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQnt() {
        return qnt;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSign() {
        return sign;
    }
}

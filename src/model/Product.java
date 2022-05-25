package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    public enum SaleType {
        PIECE,
        BULK
    }

    private final String code;
    private String name;
    private BigDecimal unitPrice;
    private Promotion promotion;
    private final SaleType saleType;


    public Product(String code, String name, BigDecimal unitPrice, Promotion promotion, SaleType saleType) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.promotion = promotion;
        this.saleType = saleType;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    @Override
    public String toString() {
        return "#PD"+this.code + "\t\t" + this.name + "\t\t" + this.unitPrice.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code.equals(product.code) && Objects.equals(name, product.name) && Objects.equals(unitPrice, product.unitPrice) && Objects.equals(promotion, product.promotion) && saleType == product.saleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, unitPrice, promotion, saleType);
    }
}

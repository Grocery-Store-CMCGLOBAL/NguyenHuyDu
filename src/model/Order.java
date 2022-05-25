package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String id;
    private Map<Product, Number> products;
    private BigDecimal totalPrice;

    public Order() {
        id = UUID.randomUUID().toString();
        products = new HashMap<>();
        totalPrice = BigDecimal.ZERO;
    }

    public void addProduct(Product product, Integer quantity){
        calculateTotalPrice(product,quantity);
        if(null == products.get(product)){
            products.put(product,quantity);
            return;
        }
        products.put(product, (Integer) products.get(product) + quantity);
    }

    public void addProduct(Product product, BigDecimal amount){
        calculateTotalPrice(product,amount);
        if(null == products.get(product)){
            products.put(product,amount);
            return;
        }
        products.put(product, amount.add((BigDecimal) products.get(product)));
    }

    public void printOrder(){
        System.out.println("Code\t\tName\t\tUnitPrice\tQuantity\t\tPromotion");
        for (Map.Entry<Product, Number> entry : products.entrySet()){
            System.out.println(entry.getKey().toString() + "\t\t\t" +String.valueOf(entry.getValue()) + "\t\t" + (null != entry.getKey().getPromotion() ? entry.getKey().getPromotion().toString() : ""));
        }


    }

    public String getId() {
        return id;
    }

    public Map<Product, Number> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Number> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice(){
        System.out.println("============TOTAL_PRICE============");
        System.out.println("============"+this.totalPrice.toString()+"============");
        return this.totalPrice;
    }

    private void calculateTotalPrice(Product product, Number quantityAmount){

        BigDecimal newProductTotalPrice = Product.SaleType.PIECE == product.getSaleType() ? getProductTotalPrice(product, (Integer) quantityAmount) : product.getUnitPrice().multiply((BigDecimal) quantityAmount);

        if(null == products.get(product)){
            this.totalPrice = this.totalPrice.add(newProductTotalPrice);
        }else{
            BigDecimal oldProductTotalPrice = Product.SaleType.PIECE == product.getSaleType() ? getProductTotalPrice(product, (Integer) products.get(product)) : product.getUnitPrice().multiply((BigDecimal) products.get(product));
            this.totalPrice = this.totalPrice.subtract(oldProductTotalPrice).add(newProductTotalPrice);
        }
    }

    private BigDecimal getProductTotalPrice(Product product, Integer quantity){
        Promotion promotion = product.getPromotion();
        BigDecimal productTotalPrice;
        if(null != promotion){
            productTotalPrice = product.getUnitPrice().multiply(BigDecimal.valueOf(calculatePromotion(quantity,promotion.getBuyAmount(), promotion.getGetAmount())));
        }else{
            productTotalPrice = product.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
        }
        return productTotalPrice;
    }

    private Integer calculatePromotion(Integer total, Integer buy, Integer get){
        Integer pack = buy + get;
        Integer buyPacks = total / pack;
        Integer buyIndividual = total % pack;
        return buy * buyPacks + buyIndividual;
    }
}

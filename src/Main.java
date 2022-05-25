
import dao.ProductRepository;
import dao.PromotionRepository;
import model.Order;
import model.Product;
import model.Promotion;
import service.OrderService;
import service.ProductService;
import service.PromotionService;
import view.View;

import java.math.BigDecimal;


public class Main {


    public static void main(String[] args) { ;
        View view = new View();

        PromotionRepository promotionRepository = new PromotionRepository();
        PromotionService promotionService = new PromotionService(promotionRepository);

        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);

        // mocking promotion
        Promotion promotion1 = new Promotion(1,1);
        Promotion promotion2 = new Promotion(2,1);

        promotionService.createPromotion(promotion1);
        promotionService.createPromotion(promotion2);

        Product product1 = new Product("AAA","Test 1", new BigDecimal(100),promotion1, Product.SaleType.PIECE);
        Product product2 = new Product("BBB","Test 2", new BigDecimal(200),promotion2, Product.SaleType.PIECE);
        Product product3 = new Product("CCC","Test 3", new BigDecimal(100),null, Product.SaleType.BULK);

        productService.createProduct(product1);
        productService.createProduct(product2);
        productService.createProduct(product3);


        view.display();
//        Order order = new Order();

//        order.addProduct(product1,1);
//        order.addProduct(product2,3);
//        order.addProduct(product3,new BigDecimal(0.5));
//
//
//        order.printOrder();
//        order.getTotalPrice();

    }



}
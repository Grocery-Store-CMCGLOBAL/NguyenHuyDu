package view;

import dao.ProductRepository;
import dao.PromotionRepository;
import model.Order;
import model.Product;
import service.ProductService;
import service.PromotionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    Order order = new Order();
    Scanner scanner = new Scanner(System.in);
    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);
    PromotionRepository promotionRepository = new PromotionRepository();
    PromotionService promotionService = new PromotionService(promotionRepository);



    public void display() {

        int closeApp = 99;
        while (closeApp == 99) {

            System.out.println("||=======Grocery Store========||");
            System.out.println("|| 1. Order                   ||");
            System.out.println("|| 2. Show Order              ||");
            System.out.println("|| 3. Print bill              ||");
            System.out.println("|| 4. Exit                    ||");
            System.out.println("||____________________________||");
            int menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    showOrderView();
                    break;
                case 2:
                    showOrderList();
                    break;
                case 3:
                    printBill();
                    break;
                case 4:
                    closeApp = 1;
                    break;
                default:
                    System.out.println("||=======Error, Enter your choice again ========||");
                    menuChoice = scanner.nextInt();

            }

        }
    }

    public void showOrderView() {
        System.out.println(". Calculate price of products sold in bulk (1) or in by piece(2)");
        int breakLoop;
        int check = scanner.nextInt();
        switch (check) {
            case 1:
                System.out.println("Check product code: ");
                String code = scanner.next();
                if (!productService.existsProduct(code)) {
                    System.out.println("Product is not exists, Enter value again");
                    System.out.println("Check product code again: ");
                    code = scanner.next();
                }
                int quantity;
                try {
                    System.out.println("Enter quantity: ");
                    quantity = Integer.parseInt(scanner.next());
                } catch (Exception e) {
                    System.out.println("Input Wrong, Enter value again");
                    quantity = scanner.nextInt();
                }
                Product product = productService.getProductById(code);
                order.addProduct(product, quantity);
                break;
            case 2:
                System.out.println("Check product code: ");
                String code2 = scanner.next();
                if (!productService.existsProduct(code2)) {
                    System.out.println("Product is not exists, Enter value again");
                    System.out.println("Check product code again: ");
                    code2 = scanner.next();
                }
                Product product2 = productService.getProductById(code2);
                double quantity2;

                try {
                    System.out.println("Enter quantity: ");
                    quantity2 = scanner.nextDouble();
                    order.addProduct(product2, new BigDecimal(quantity2));
                } catch (Exception e) {
                    System.out.println("Input Wrong, Enter value again");
                    quantity2 = scanner.nextInt();
                    order.addProduct(product2, (int) quantity2);
                }

                break;
        }
    }


    public void showOrderList() {
        order.printOrder();
        order.getTotalPrice();
    }

    public void printBill() {
        Date date = java.util.Calendar.getInstance().getTime();
        System.out.println("Create At: " + date);
        order.printOrder();
        order.getProducts().clear();
        order.getTotalPrice();

    }

}

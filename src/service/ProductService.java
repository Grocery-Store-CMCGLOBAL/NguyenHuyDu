package service;

import dao.ProductRepository;
import model.Product;
import java.util.List;


public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        if(productRepository.exists(product.getCode())){
            System.out.println("Product is exists");
            return null;
        }
        productRepository.save(product);
        return product;
    }

    public Product getProductById(String id){
        return productRepository.findOne(id);
    }

    public void removeProduct(String id){
        productRepository.delete(id);
    }

    public boolean existsProduct(String code){
        return productRepository.exists(code);
    }


}

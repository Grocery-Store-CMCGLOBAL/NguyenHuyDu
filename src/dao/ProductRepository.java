package dao;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements CrudRepository<Product,String>{

    private static List<Product> productList = new ArrayList<>();

    @Override
    public Product save(Product entity) {
        productList.add(entity);
        return entity;
    }

    @Override
    public Product findOne(String primaryKey) {
        for (Product product : productList){
            if(primaryKey.equals(product.getCode())){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Integer count() {
        return productList.size();
    }

    @Override
    public void delete(String primaryKey) {
        productList.removeIf(s -> primaryKey.equals(s.getCode()));
    }

    @Override
    public boolean exists(String primaryKey) {
        if(null != findOne(primaryKey)){
            return true;
        }
        return false;
    }
}

package dao;

import model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements CrudRepository<Order,String>{

    private static List<Order> orderList = new ArrayList<>();

    @Override
    public Order save(Order entity) {
        orderList.add(entity);
        return entity;
    }

    @Override
    public Order findOne(String primaryKey) {
        for (Order order : orderList){
            if(primaryKey.equals(order.getId())){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderList;
    }

    @Override
    public Integer count() {
        return orderList.size();
    }

    @Override
    public void delete(String primaryKey) {
        orderList.removeIf(s -> primaryKey.equals(s.getId()));
    }

    @Override
    public boolean exists(String primaryKey) {
        if(null != findOne(primaryKey)){
            return true;
        }
        return false;
    }
}

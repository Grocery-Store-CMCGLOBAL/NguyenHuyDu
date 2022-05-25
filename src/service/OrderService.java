package service;

import dao.OrderRepository;
import model.Order;
import model.Product;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order){
        if(orderRepository.exists(order.getId())){
            System.out.println("Order is exists");
            return null;
        }
        orderRepository.save(order);
        return order;
    }

    public Order getOrderById(String id){
        return orderRepository.findOne(id);
    }

    public void removeOrder(String id){
        orderRepository.delete(id);
    }


}

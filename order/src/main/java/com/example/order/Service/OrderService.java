package com.example.order.Service;

import com.example.order.Data.Orders;
import com.example.order.Data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public Orders updateOrder(Orders order){
        return orderRepository.save(order);
    }

    public Orders getOrderById(int id) {
        Optional<Orders> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public Orders createOrder(Orders order) {

        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Orders> findOrderByUsername(String username){
        return orderRepository.findOrderByUsername(username);
    }

    public List<Orders> findOrderByBookName(String bookName){
        return orderRepository.findOrderByBookName(bookName);
    }
    public List<String> findIsbnByBookName(String bookName) {
        return orderRepository.findIsbnByBookName(bookName);
    }
}

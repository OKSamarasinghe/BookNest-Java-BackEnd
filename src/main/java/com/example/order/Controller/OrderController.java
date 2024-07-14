package com.example.order.Controller;

import com.example.order.Data.Orders;
import com.example.order.Service.OrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(path = "/orders")
    public Orders createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
    }

    @GetMapping(path = "/orders/{id}")
    public Orders getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping(path = "/orders/{id}")
    public void deleteOrderById(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @PutMapping(path = "/orders/{id}")
    public Orders updateOrder(@RequestBody Orders order){
        return orderService.updateOrder(order);
    }

    @GetMapping(path = "/orders", params = "username")
    public List<Orders> findOrdersByUsername(@RequestParam String username) {
        return orderService.findOrderByUsername(username);
    }

    @GetMapping(path = "/orders", params = "bookName")
    public List<Orders> findBooksByBookName(@RequestParam String bookName) {
        return orderService.findOrderByBookName(bookName);
    }
    @GetMapping(path = "/isbn", params = "bookName")
    public List<String> getIsbnByBookName(@RequestParam String bookName) {
        return orderService.findIsbnByBookName(bookName);
    }

}

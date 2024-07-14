package com.example.order.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.username = ?1")
    List<Orders> findOrderByUsername(String username);

    @Query("SELECT o FROM Orders o WHERE o.bookName = ?1")
    List<Orders> findOrderByBookName(String bookName);

    @Query("SELECT o.isbn FROM Orders o WHERE o.bookName = ?1")
    List<String> findIsbnByBookName(String bookName);
}

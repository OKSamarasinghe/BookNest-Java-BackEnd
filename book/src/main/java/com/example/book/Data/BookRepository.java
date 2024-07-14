package com.example.book.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Books,Integer> {
    @Query("SELECT b.quantity FROM Books b WHERE b.name = :name")
    Integer getQuantityByName(@Param("name") String name);
    @Query("SELECT b FROM Books b WHERE b.name = ?1")
    List<Books> findBooksByName(String name);
    @Query("SELECT b FROM Books b WHERE b.name = :name")
    Books findByName(@Param("name") String name);

    @Query("SELECT b.price FROM Books b WHERE b.name = :name")
    float getPriceByName(@Param("name") String name);


}

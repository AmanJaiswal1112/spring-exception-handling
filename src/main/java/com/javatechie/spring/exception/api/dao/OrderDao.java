package com.javatechie.spring.exception.api.dao;

import com.javatechie.spring.exception.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer>
{
    public Order findByName(String name);
}

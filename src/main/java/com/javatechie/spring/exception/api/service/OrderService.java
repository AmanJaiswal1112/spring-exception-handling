package com.javatechie.spring.exception.api.service;

import com.javatechie.spring.exception.api.dao.OrderDao;
import com.javatechie.spring.exception.api.exceptionClass.OrderServiceException;
import com.javatechie.spring.exception.api.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    @Autowired
    private OrderDao orderDao;

    public double getPrice(String name) throws OrderServiceException
    {
        double amount = 0;
        try
        {
            Order order = orderDao.findByName(name);
            amount = order.getAmount();
        }
        catch (Exception e)
        {
            throw new OrderServiceException("Order not found  with product "+name);
        }
        return amount;
    }

    public String save(Order order) throws OrderServiceException {
        try {
            orderDao.save(order);
            return "Order Place";
        }
        catch(Exception e)
        {
            throw new OrderServiceException("Unable to save order in db");
        }
    }
}

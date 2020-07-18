package com.javatechie.spring.exception.api.controller;

import com.javatechie.spring.exception.api.exceptionClass.ExceptionAdvice;
import com.javatechie.spring.exception.api.exceptionClass.OrderServiceException;
import com.javatechie.spring.exception.api.model.Order;
import com.javatechie.spring.exception.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController extends ExceptionAdvice
{
    @Autowired
    private OrderService orderService;

    @GetMapping("/getPrice/{name}")
    public String getPrice(@PathVariable String name) throws OrderServiceException {
        double amount = orderService.getPrice(name);
        return "Amount of product "+name+" is ="+amount;
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) throws OrderServiceException
    {
        orderService.save(order);
        return  "Order Placed";
    }

}

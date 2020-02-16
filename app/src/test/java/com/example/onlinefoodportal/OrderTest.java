package com.example.onlinefoodportal;

import com.example.onlinefoodportal.bll.OrderBll;
import com.example.onlinefoodportal.model.Order;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OrderTest {

    @Test
    public void OrderPass(){
        Order order=new Order("Burger","500","Bafal","9842575");
        OrderBll orderBll=new OrderBll();
        boolean result=orderBll.orderadd(order);
        assertEquals(false,result);
    }

}

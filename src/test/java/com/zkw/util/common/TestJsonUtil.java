package com.zkw.util.common;

import com.zkw.netty.protocol_http_json.pojo.Address;
import com.zkw.netty.protocol_http_json.pojo.Customer;
import com.zkw.netty.protocol_http_json.pojo.Order;
import com.zkw.netty.protocol_http_json.pojo.Shipping;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class TestJsonUtil {
    @Test
    public void testObject2Json(){
        Address address=new Address();
        address.setCity("武汉");
        address.setCountry("中国");
        address.setPostCode("1001");
        address.setState("number");
        address.setStreet1("无用街");
        try {
            System.out.println(JsonUtil.object2Json(address));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Customer customer=new Customer();
        customer.setCustomerNumber(1001);
        customer.setFirstName("zhang");
        customer.setLastName("wu");
        customer.setMiddleNames(Arrays.asList(new String[]{"james","matt"}));
        try {
            System.out.println(JsonUtil.object2Json(customer));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Order order = new Order();
        order.setOrderNumber(1001);
        order.setTotal(9999.999f);
        order.setBillTo(address);
        order.setCustomer(customer);
        order.setShipping(Shipping.INTERNATIONAL_MAIL);
        order.setShipTo(address);
        try {
            System.out.println(JsonUtil.object2Json(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

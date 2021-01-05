package com.example.lab10.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

@Setter
@Getter
public class OrderItem {

    private int id;
    private Order order;
    private Product product;
    private int quantity;

}

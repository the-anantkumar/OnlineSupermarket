package com.OOPSg22.major.global;

import com.OOPSg22.major.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
    public static  List<String> discountCoupons;

    static {
        discountCoupons = new ArrayList<String>();
        discountCoupons.add("FIRST10");
    }
}

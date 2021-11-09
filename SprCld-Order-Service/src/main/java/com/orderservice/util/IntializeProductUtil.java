package com.orderservice.util;

import java.util.ArrayList;
import java.util.List;

import com.orderservice.model.Product;

public class IntializeProductUtil {
	
	public static List<Product> initializeAllProducts(){
		Product p1=new Product(1,"Mobile",24000,true);
		Product p2=new Product(2,"Earphones",345,true);
	
		
		ArrayList<Product> arList=new ArrayList<Product>();
		arList.add(p1); arList.add(p2); 
		//arList.add(p4); arList.add(p5); arList.add(p6); arList.add(p3);
		
		return arList;
	}
	

}

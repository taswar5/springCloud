package com.catalogue.service.util;

import java.util.ArrayList;
import java.util.List;

import com.catalogue.service.model.Product;

public class InitializeProducts {

	private InitializeProducts() {

	}

	public static List<Product> initializeAllProducts() {
		Product p1 = new Product(1, "Mobile", 24000, true);
		Product p2 = new Product(2, "Earphones", 345, true);
		Product p3 = new Product(3, "Chair", 8990, false);
		Product p4 = new Product(4, "Table", 456, true);
		Product p5 = new Product(5, "Pen", 4000, true);
		Product p6 = new Product(6, "laptop", 98000, true);

		ArrayList<Product> arList = new ArrayList<>();
		arList.add(p1);
		arList.add(p2);
		arList.add(p3);
		arList.add(p4);
		arList.add(p5);
		arList.add(p6);

		return arList;
	}

}

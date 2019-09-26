package com.wp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired
    ProductDAO dao;
	
	@RequestMapping("newproduct")
	public String showProductEntryForm() {
		return "DataEntry.jsp";
	}
	
	@RequestMapping("saveproduct")
	public String saveNewProduct(@RequestParam("pcode") int pcode,@RequestParam("pname") String pname,@RequestParam("price") int price)
	{
		Product product=new Product();
		product.setPcode(pcode);
		product.setPname(pname);
		product.setPrice(price);
		
		dao=new ProductDAO();
		dao.saveProduct(product);
		
		return "success.jsp";
	}

}

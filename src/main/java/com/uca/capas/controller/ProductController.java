package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView comprarProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"HARRY POTTER",60));
		productos.add(new Product(1,"EL CODIGO DA VINCI",20));
		productos.add(new Product(2,"EL SEÑOR DE LOS ANILLOS",10));
		productos.add(new Product(3,"LO QUE EL VIENTO SE LLEVO",8));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto",productos);
		return mav;	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		Product p = productos.get(product.getId());
		String nombre_producto = p.getNombre();
		mav.addObject("nombre",nombre_producto);

		if(product.getCantidad()>p.getCantidad()) {
			mav.setViewName("error");
		}
		else {
			mav.setViewName("compra");
		}
		
		return mav;
	}
}

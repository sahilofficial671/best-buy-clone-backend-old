package com.bestbuy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestbuy.model.Order;
import com.bestbuy.service.OrderService;
import com.bestbuy.service.ProductService;
import com.bestbuy.service.UserService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders(){
		List<Order> orders = orderService.getOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id){
		Order order = orderService.getOrder(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@PostMapping("/order/submit")
	public ResponseEntity<String> addOrder(@Valid @RequestBody Order order){
//		if(! productService.exists(order)) {
//			return new ResponseEntity<String>("Product not found.", HttpStatus.NOT_FOUND);
//		}
//		
		if(orderService.add(order)) {
			return new ResponseEntity<String>("Order Added", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping("/order/update")
	public ResponseEntity<String> updateOrder(@Valid @RequestBody Order order){
		if(! orderService.exists(order.getId())) {
			return new ResponseEntity<String>("Order not found.", HttpStatus.NOT_FOUND);
		}
		
		if(orderService.update(order)) {
			return new ResponseEntity<String>("Order Updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/order/delete/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable("id") Integer id){
		if(! orderService.exists(id)) {
			return new ResponseEntity<String>("Order not found.", HttpStatus.NOT_FOUND);
		}
		
		if(orderService.delete(id)) {
			return new ResponseEntity<String>("Order Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
}

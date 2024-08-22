package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public Order createOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		kafkaTemplate.send("order_topic", "New order created: " + savedOrder.toString());
		return savedOrder;
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderRepository.findByUsername(username);
	}
}

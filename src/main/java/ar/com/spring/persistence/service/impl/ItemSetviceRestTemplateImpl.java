package ar.com.spring.persistence.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.spring.persistence.model.Item;
import ar.com.spring.persistence.model.Product;
import ar.com.spring.persistence.service.ItemService;

@Service("restService")
public class ItemSetviceRestTemplateImpl implements ItemService {

	@Autowired
	private RestTemplate clientProductRT;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(clientProductRT.getForObject("http://localhost:8001/product/find-all", Product[].class));
		return products.stream().map(p -> new Item(p, 1) ).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, int quality) {
		Map<String,String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product product = clientProductRT.getForObject("http://localhost:8001/product/find-by-id/{id}", Product.class,pathVariables);
		return new Item(product, quality);
	}

	@Override
	public Product save(Product product) {
		HttpEntity<Product>body = new HttpEntity<Product>(product);
		ResponseEntity<Product>responseProduct= clientProductRT.exchange("http://localhost:8001/product/save",HttpMethod.POST, body, Product.class);
		return responseProduct.getBody();
	}

	@Override
	public Product edit(Product product, Long id) {
		HttpEntity<Product>body = new HttpEntity<Product>(product);
		Map<String,String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		ResponseEntity<Product>responseProduct= clientProductRT.exchange("http://localhost:8001/product/update/{id}",HttpMethod.PUT, body, Product.class,pathVariables);
		return responseProduct.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String,String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		clientProductRT.delete("http://localhost:8001/product/delete/{id}",pathVariables );
		
	}

}

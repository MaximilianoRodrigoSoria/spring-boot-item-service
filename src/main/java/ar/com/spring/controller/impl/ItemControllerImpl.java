package ar.com.spring.controller.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ar.com.spring.controller.ItemController;
import ar.com.spring.persistence.model.Item;
import ar.com.spring.persistence.model.Product;
import ar.com.spring.persistence.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemControllerImpl implements ItemController {

	@Autowired
	@Qualifier("restService")
	private ItemService itemService;
	
	@GetMapping("/find-all")
	public List<Item> findAll()
	{
	return itemService.findAll();	
	}
	
	
	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/find/id/{id}/quantity/{quantity}")
	public Item findById(@PathVariable Long id, @PathVariable int quantity)
	{
	return itemService.findById(id, quantity);	
	}
	
	
	public Item alternativeMethod(Long id, int quantity)
	{
		Item item = new Item();
		item.setQuantity(10);
		Product product = new Product();
		product.setName("ERROR");
		product.setPrice(10.00);
		product.setCretateAt(new Date());
		item.setProduct(product);		
		return item;
		
		
	}


	@Override
	@PostMapping("/save")
	public Product save(@RequestBody Product product) throws Exception {
		return itemService.save(product);
	}


	@Override
	@PutMapping("/update/{id}")
	public Product edit(@RequestBody Product product,@PathVariable Long id) throws Exception {
		return itemService.edit(product, id);
	}


	@Override
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) throws Exception {
		itemService.delete(id);
	}
	
}

package ar.com.spring.persistence.service;

import java.util.List;

import ar.com.spring.persistence.model.Item;
import ar.com.spring.persistence.model.Product;

public interface ItemService  {

	public List<Item> findAll();
	public Item findById(Long id, int cantidad);
	public Product save(Product product) throws Exception;
	public Product edit(Product product, Long id) throws Exception;
	public void delete(Long id) throws Exception;
}

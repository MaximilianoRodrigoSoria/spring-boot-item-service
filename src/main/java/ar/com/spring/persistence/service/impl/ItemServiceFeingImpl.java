package ar.com.spring.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.spring.persistence.client.ProductFeingClient;
import ar.com.spring.persistence.model.Item;
import ar.com.spring.persistence.model.Product;
import ar.com.spring.persistence.service.ItemService;

//TODO: MEJORAR ESTO Y ANALIZAR EL CODIGO DE UPDATE Y DELETE
@Service("serviceFeing")
public class ItemServiceFeingImpl implements ItemService {

	@Autowired
	private ProductFeingClient productClient;
	
	@Override
	public List<Item> findAll() {		
		return productClient.findAll().stream().map(p -> new Item(p, 1 )).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, int cantidad) {
		
		return new Item(productClient.findById(id).getBody(),cantidad);
	}

	@Override
	public Product save(Product product) throws Exception {
		return productClient.save(product).getBody();
	}

	@Override
	public Product edit(Product product, Long id) throws Exception {
		return productClient.edit(product, id).getBody() ;
	}

	@Override
	public void delete(Long id) throws Exception {
		productClient.delete(id);
		
	}



}

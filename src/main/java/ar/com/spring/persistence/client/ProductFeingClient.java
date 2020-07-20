package ar.com.spring.persistence.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.spring.persistence.model.Product;

@FeignClient(name="product-service")
public interface ProductFeingClient {
	
	@GetMapping("/product/find-all")
	public List<Product> findAll();

	@GetMapping("/product/find-by-id/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id);
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) throws Exception;	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> edit(@RequestBody Product product, @PathVariable Long id) throws Exception;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception;
	
}

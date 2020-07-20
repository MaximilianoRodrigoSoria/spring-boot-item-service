package ar.com.spring.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import ar.com.spring.persistence.model.Item;
import ar.com.spring.persistence.model.Product;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Item: ", description = "The Item API")
public interface ItemController {

	
	//TODO: REPARAR TIPOS DE DATOS PARA SAVE Y UPDATE
	
	@ApiResponses(value= {
			  @ApiResponse(responseCode = "200", description = "Owner data getted successfully"),
			  @ApiResponse(responseCode = "400", description = "Bad Request"),
			  @ApiResponse(responseCode = "404", description = "Not Found"),
			  @ApiResponse(responseCode = "500", description = "Internal Server Error"),
	})
	public List<Item> findAll();
	@ApiResponses(value= {
			  @ApiResponse(responseCode = "200", description = "Owner data getted successfully"),
			  @ApiResponse(responseCode = "400", description = "Bad Request"),
			  @ApiResponse(responseCode = "404", description = "Not Found"),
			  @ApiResponse(responseCode = "500", description = "Internal Server Error"),
	})
	public Item findById(@Parameter(description="Id of the item to be find. Cannot be empty.") Long id, @Parameter(description="Quantity of products. Cannot be empty.") int quantity);	
	


	@ApiResponses(value= {
			  @ApiResponse(responseCode = "200", description = "Owner data getted successfully"),
			  @ApiResponse(responseCode = "400", description = "Bad Request"),
			  @ApiResponse(responseCode = "404", description = "Not Found"),
			  @ApiResponse(responseCode = "500", description = "Internal Server Error"),
	})
	public Product save(@RequestBody(description="This is a Product. Cannot be empty.")Product product) throws Exception;
	

	@ApiResponses(value= {
			  @ApiResponse(responseCode = "200", description = "Owner data getted successfully"),
			  @ApiResponse(responseCode = "400", description = "Bad Request"),
			  @ApiResponse(responseCode = "404", description = "Not Found"),
			  @ApiResponse(responseCode = "500", description = "Internal Server Error"),
	})
	public Product edit(@RequestBody(description="This is a Product. Cannot be empty.")Product product,@Parameter(description="Id of the item to be find. Cannot be empty.") Long id) throws Exception;
	

	@ApiResponses(value= {
			  @ApiResponse(responseCode = "200", description = "Owner data getted successfully"),
			  @ApiResponse(responseCode = "400", description = "Bad Request"),
			  @ApiResponse(responseCode = "404", description = "Not Found"),
			  @ApiResponse(responseCode = "500", description = "Internal Server Error"),
	})
	public void delete(@Parameter(description="Id of the item to be delete. Cannot be empty.")Long id) throws Exception;
}

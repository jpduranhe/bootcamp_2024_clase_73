package cl.bootcamp.pets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bootcamp.pets.dto.ResponseCreateOwnerDto;
import cl.bootcamp.pets.model.Owner;
import cl.bootcamp.pets.service.OwnerService;

@RestController
@RequestMapping("/api/owner")
public class OwnerRestController {
	
	private final OwnerService ownerService;
	
	public OwnerRestController(OwnerService ownerService){
		this.ownerService=ownerService;
	}
	
	
	public ResponseEntity<ResponseCreateOwnerDto> create( @RequestBody Owner owner){
		
		int id=ownerService.create(owner);
		
		ResponseCreateOwnerDto resp= new ResponseCreateOwnerDto( id);
		
		
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}

}

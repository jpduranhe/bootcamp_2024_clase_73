package cl.bootcamp.pets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bootcamp.pets.dto.ResponseCreateOwnerDto;
import cl.bootcamp.pets.model.Owner;
import cl.bootcamp.pets.service.OwnerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/owner")
public class OwnerRestController {
	
	private final OwnerService ownerService;
	
	public OwnerRestController(OwnerService ownerService){
		this.ownerService=ownerService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseCreateOwnerDto> create( @RequestBody Owner owner){
		
		int id=ownerService.create(owner);
		
		ResponseCreateOwnerDto resp= new ResponseCreateOwnerDto( id);
		
		
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Owner> getById(@PathVariable int id){
		
		Owner owner=ownerService.getById(id);
		
		if(owner== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(owner,HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> create(@PathVariable int id, @RequestBody Owner owner){
		
		boolean result=ownerService.edit(id, owner);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Owner>> getList(){
		
		List<Owner> owners=ownerService.getList();
		
		return new ResponseEntity<>(owners,HttpStatus.OK);
		
	}

}

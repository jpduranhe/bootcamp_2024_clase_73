package cl.bootcamp.pets.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Owner {
	
	
	private int id;
	private String name;
	private String cellphone;
	private String email;
}

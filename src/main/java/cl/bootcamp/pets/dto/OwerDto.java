package cl.bootcamp.pets.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OwerDto {
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String cellphone;
	
	@Email
	@NotBlank
	private String email;
}

package cl.bootcamp.pets.model;

import lombok.Data;

@Data
public class Pet {
	private int id;
	private String name;
	private int age;
	private PetType petType;
}

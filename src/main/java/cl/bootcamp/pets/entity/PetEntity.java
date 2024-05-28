package cl.bootcamp.pets.entity;

import cl.bootcamp.pets.model.PetType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="pet")
public class PetEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="pet_id")
	private int id;
	@Column(name="pet_name")
	private String name;
	@Column(name="pet_age")
	private int age;
	@Enumerated(EnumType.STRING)
	@Column(name="pet_pet_type")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")	
	private OwnerEntity owner;
}

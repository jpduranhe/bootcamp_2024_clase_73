package cl.bootcamp.pets.entity;

import cl.bootcamp.pets.model.PetType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="owner")
public class OwnerEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="owner_id")
	private int id;
	@Column(name="owner_name")
	private String name;
	@Column(name="owner_cellphone")
	private String cellphone;
	@Column(name="owner_email")
	private String email;
}

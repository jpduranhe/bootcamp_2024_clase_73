package cl.bootcamp.pets.service;

import java.util.List;

import cl.bootcamp.pets.model.Owner;

public interface OwnerService {

	int create(Owner owner);
	Owner getById(int id);
	boolean edit(int id,Owner owner);
	List<Owner> getList();
}

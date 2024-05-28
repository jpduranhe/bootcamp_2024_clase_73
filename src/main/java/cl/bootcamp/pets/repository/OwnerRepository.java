package cl.bootcamp.pets.repository;

import org.springframework.data.repository.CrudRepository;

import cl.bootcamp.pets.entity.OwnerEntity;

public interface OwnerRepository extends CrudRepository<OwnerEntity,Integer> {

}

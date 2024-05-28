package cl.bootcamp.pets.service.impl;

import org.springframework.stereotype.Service;

import cl.bootcamp.pets.entity.OwnerEntity;
import cl.bootcamp.pets.model.Owner;
import cl.bootcamp.pets.repository.OwnerRepository;
import cl.bootcamp.pets.service.OwnerService;
import lombok.extern.apachecommons.CommonsLog;


@Service
@CommonsLog
public class OwnerServiceImpl implements OwnerService {
	
	
	private final OwnerRepository ownerRepository;
	
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository=ownerRepository;
	}

	@Override
	public int create(Owner owner) {
		try {
			
			OwnerEntity ownerEntity= new OwnerEntity();
			ownerEntity.setName(owner.getName());
			ownerEntity.setEmail(owner.getEmail());
			ownerEntity.setCellphone(owner.getCellphone());
			OwnerEntity ownerEntitySaved= ownerRepository.save(ownerEntity);
			
			return ownerEntitySaved.getId();
			
		}catch(Exception ex) {
			log.error(ex.getMessage());
			return -1;
		}
	}

}

package cl.bootcamp.pets.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Owner getById(int id) {
		try {
			
		Optional<OwnerEntity> ownerOptional=	ownerRepository.findById(id);
		
		if(ownerOptional.isEmpty()) return null;
		
		OwnerEntity ownerEntity= ownerOptional.get();
		Owner owner= new Owner();
		owner.setId(ownerEntity.getId());
		owner.setName(ownerEntity.getName());
		owner.setCellphone(ownerEntity.getCellphone());
		owner.setEmail(ownerEntity.getEmail());
		
		return owner;
		
		}catch(Exception ex) {
			log.error(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean edit(int id, Owner owner) {
		try {
			
			Optional<OwnerEntity> ownerOptional=	ownerRepository.findById(id);
			
			if(ownerOptional.isEmpty()) return false;
				OwnerEntity ownerEntityFromDB= ownerOptional.get();
				
				ownerEntityFromDB.setName(owner.getName());
				ownerEntityFromDB.setEmail(owner.getEmail());
				ownerEntityFromDB.setCellphone(owner.getCellphone());
				ownerRepository.save(ownerEntityFromDB);
			return true;
			
			}catch(Exception ex) {
				log.error(ex.getMessage());
				return false;
			}
	}

	@Override
	public List<Owner> getList() {
		try {
			
			Iterable<OwnerEntity> ownersIterable=ownerRepository.findAll();
			
			List<Owner> owners= new ArrayList<>();
			for(OwnerEntity ownerEntity: ownersIterable) {
				Owner owner= new Owner();
				owner.setId(ownerEntity.getId());
				owner.setName(ownerEntity.getName());
				owner.setCellphone(ownerEntity.getCellphone());
				owner.setEmail(ownerEntity.getEmail());
				owners.add(owner);
			}			
			
			return owners;
			
			}catch(Exception ex) {
				log.error(ex.getMessage());
				return null;
			}
	}

}

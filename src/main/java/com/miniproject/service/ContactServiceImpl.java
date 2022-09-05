package com.miniproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.dto.ContactDTO;
import com.miniproject.persistenceLayer.ContactDtlsEntity;
import com.miniproject.persistenceLayer.ContactDtlsRepository;



@Service
public class ContactServiceImpl implements ContactService {
	 
	@Autowired
	 private ContactDtlsRepository contactDtlsRepo;
	
	/**
	 * this method is used to save contact details
	 */

	@Override
	public boolean saveContact(ContactDTO dto) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(dto, entity);
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);
		return savedEntity.getCid() !=null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		/**
		 *  Logic to copy data from one collection to other
		 *  we have data in form of ContactDtlsEntity but we require in ContactDTO
		 *  Beanutils.copyProperties(source, target) only work for data from object form, not for collection from one to other
		 */
		
		List<ContactDTO> contactsList = new ArrayList<ContactDTO>();
		
		List<ContactDtlsEntity> entitiesList = contactDtlsRepo.findAll();
		entitiesList.forEach(entity ->{
			ContactDTO c = new ContactDTO();
			BeanUtils.copyProperties(entity, c);
			contactsList.add(c);
		});
		
		return contactsList;
	}

	@Override
	public ContactDTO getContactById(Integer cid) {
		
		Optional<ContactDtlsEntity> optional = contactDtlsRepo.findById(cid);
		if(optional.isPresent()) {
			ContactDtlsEntity entity = optional.get();
			ContactDTO c = new ContactDTO();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		
		return null;
	}

	@Override
	public boolean updateContact(ContactDTO dto) {
		// No need of this method if we are displaying the update in same page
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		contactDtlsRepo.deleteById(cid);
		
		return true;
	}

}

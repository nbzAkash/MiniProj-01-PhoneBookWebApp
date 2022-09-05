package com.miniproject.service;

import java.util.List;

import com.miniproject.dto.ContactDTO;

public interface ContactService {
	
	public boolean saveContact(ContactDTO dto);// to save form data from server
	public List<ContactDTO> getAllContacts();// to get all contacts list from DB
	
	public ContactDTO getContactById(Integer cid);// Edit operation
	public boolean updateContact(ContactDTO dto);// to Update data
	public boolean deleteContactById(Integer cid);
	

}

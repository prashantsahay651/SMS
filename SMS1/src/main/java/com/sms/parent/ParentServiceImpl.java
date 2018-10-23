package com.sms.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Parent;
import com.sms.beans.Student;

@Service
public class ParentServiceImpl {
	
	@Autowired
	ParentDAO parentDAO;
	
	Parent parent2;

	public Parent getParentByEmailId(String emailId) {
		
		return parentDAO.getParentByEmailId(emailId);
	}

	public Parent saveParent(Parent parent) {
		
		return parentDAO.save(parent);
		
	}

	public Parent getParentById(int parentId) {
		
		return parentDAO.getOne(parentId);
	}

	public void editParent(Parent parent) {
		parent2=parentDAO.getOne(parent.getParentId());
		parent2.setFathersName(parent.getFathersName());
		parent2.setMothersName(parent.getMothersName());
		parent2.setAddressLine1(parent.getAddressLine1());
		parent2.setAddressLine2(parent.getAddressLine2());
		parent2.setCity(parent.getCity());
		parent2.setDistrict(parent.getDistrict());
		parent2.setState(parent.getState());
		parent2.setDistrict(parent.getDistrict());
		parentDAO.save(parent2);
	}

}

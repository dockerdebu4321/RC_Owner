package com.ey.randompractice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.randompractice.beans.RcOwnerBeans;
import com.ey.randompractice.entity.RcOwnerEntity;
import com.ey.randompractice.repository.RcOwnerRepository;

@Service
public class RcOwnerService {

	@Autowired
	RcOwnerRepository rcOwnerRepository;
	
	public RcOwnerBeans getRCdetailsByID(int id) {
		RcOwnerBeans rcBean=new RcOwnerBeans();
		Optional<RcOwnerEntity> rcdetailsEntityNullCheck = rcOwnerRepository.findById(id);
		if (rcdetailsEntityNullCheck.isPresent()) {
			RcOwnerEntity rcOwnerEntity = rcdetailsEntityNullCheck.get();
			rcBean.setOwner_name(rcOwnerEntity.getOwner_name());
			rcBean.setRC_number(rcOwnerEntity.getRC_number());
		}else {
			System.out.println("Enter valid employeeid");
		}
		return rcBean;
	}
	
	public List<RcOwnerBeans> getAllRCdetails() {
		List<RcOwnerBeans> beanList=new ArrayList<>();
		List<RcOwnerEntity> EntityList=rcOwnerRepository.findAll();
		for(RcOwnerEntity currentEntityList:EntityList) {
			RcOwnerBeans rcBean=new RcOwnerBeans();
			rcBean.setId(currentEntityList.getId());
			rcBean.setOwner_name(currentEntityList.getOwner_name());
			rcBean.setRC_number(currentEntityList.getRC_number());
			beanList.add(rcBean);
			
		}return beanList;
	}
	
}

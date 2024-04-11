	package com.ey.randompractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.randompractice.beans.RcOwnerBeans;
import com.ey.randompractice.service.RcOwnerService;


@RestController
@RequestMapping(path="/rcOwnerdetails")
public class RcOwnerController {

	@Autowired
	RcOwnerService rcOwnerService;
	
	@GetMapping(path="/getRCdetailsByID")
	public RcOwnerBeans getRCdetailsByID(@RequestParam(name="id") int id) {
		RcOwnerBeans getRCdetailsByID=rcOwnerService.getRCdetailsByID(id);
		return getRCdetailsByID;
	}
	
	@GetMapping(path="/getRCdetails")
	public List<RcOwnerBeans> getRCdetails(){
		List<RcOwnerBeans> rcList= rcOwnerService.getAllRCdetails();
		return rcList;
	}
	
}

package com.tathagat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tathagat.response.AddressResponse;
import com.tathagat.service.AddressService;

@RestController
public class AddressController 
{
	
   @Autowired
   private AddressService adserv;
	
   @GetMapping(path="/Addresses/{id}")
	public ResponseEntity<AddressResponse> getAddressDetailsByEmpid(@PathVariable("id") Integer id)
	{
		
		AddressResponse adrep =adserv.findAddressByEmpid(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(adrep);
	}
}

package com.tathagat.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tathagat.Entity.Address;
import com.tathagat.repo.AddressRepo;
import com.tathagat.response.AddressResponse;

@Service
public class AddressService
{
    @Autowired
	private AddressRepo adrepo;
    @Autowired   
    private ModelMapper modelmapper;
    
    public AddressResponse findAddressByEmpid(Integer id)
    {
    	Address ad= adrepo.findById(id).get();
    	
    	//auto model mapper
    	AddressResponse adresp= modelmapper.map(ad, AddressResponse.class);
		return adresp;
    	
    }
	
}

package com.tathagat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tathagat.Entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}

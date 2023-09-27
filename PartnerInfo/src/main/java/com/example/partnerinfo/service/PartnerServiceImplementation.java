package com.example.partnerinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.partnerinfo.entity.Partner;
//import com.example.partnerinfo.exception.PartnerDetailsNotFoundException;
import com.example.partnerinfo.repository.PartnerRepository;
@Service
public class PartnerServiceImplementation  implements PartnerService{
@Autowired
private PartnerRepository partnerRepository;
	@Override
	public List<Partner> getPartnerDetails() {
		// TODO Auto-generated method stub
		
		return partnerRepository.findAll();
	}

	@Override
	public Partner getPartnerById(int id) {
		// TODO Auto-generated method stub
		Partner partner = partnerRepository.findById(id);

		return partner;
	}

	@Override
	public void postPartnerDetails(Partner partner) {
		partnerRepository.save(partner);
		
	}

	@Override
	public void postListOfPartnerDetails(List<Partner> partner) {
		partnerRepository.saveAll(partner);
		
	}

	@Override
	public Partner updatePartnerDetails(Partner partner, int id) {
		// TODO Auto-generated method stub
		Partner partner2 = partnerRepository.findById(id);
		partner2.setBusiness(partner.getBusiness());
		
		partner2.setName(partner.getName());
		partnerRepository.save(partner2);
		return partner2;
	}

	@Override
	public void deletePartnerDetailsById(int id) {
		// TODO Auto-generated method stub
		partnerRepository.deleteById(id);		
	}

}

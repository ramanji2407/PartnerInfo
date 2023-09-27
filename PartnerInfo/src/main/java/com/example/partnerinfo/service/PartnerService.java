package com.example.partnerinfo.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.partnerinfo.entity.Partner;

public interface PartnerService {

	public List<Partner> getPartnerDetails();

	public Partner getPartnerById(@PathVariable int id);

	public void postPartnerDetails(@RequestBody Partner partner);

	public void postListOfPartnerDetails(@RequestBody List<Partner> partner);

	public Partner updatePartnerDetails(@RequestBody Partner partner, @PathVariable int id);

	public void deletePartnerDetailsById(@PathVariable int id);

}

package com.example.partnerinfo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.partnerinfo.entity.Partner;
import com.example.partnerinfo.exception.PartnerDetailsNotFoundException;
import com.example.partnerinfo.response.ResponseData;
import com.example.partnerinfo.service.PartnerService;

@RestController
@RequestMapping("/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	private static final Logger loginfo = LoggerFactory.getLogger(PartnerController.class);

	@GetMapping("/")
	public ResponseEntity<ResponseData<List<Partner>>> getPartnerDetails() {
		loginfo.info("Intilized the get all partner details route");
		List<Partner> partnerDetails = partnerService.getPartnerDetails();
		if (partnerDetails.size() == 0) {
			loginfo.error("There was no partner details available in database");
			throw new PartnerDetailsNotFoundException("No_detatils_available_to_get_details");
		}

		ResponseData<List<Partner>> response = new ResponseData("Sucess", partnerDetails);
		loginfo.info("Got the  all partner details Sucessfully");

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Partner>> getPartnerById(@PathVariable int id)

	{
		loginfo.info("Intilized the get  partner details with id route");

		Partner partner = partnerService.getPartnerById(id);
		if (partner == null) {
			loginfo.error("There was no partner details available in database with given id");

			throw new PartnerDetailsNotFoundException("No_detatils_available_with_id:" + id + "to_get_details");
		}
		ResponseData<Partner> response = new ResponseData("Sucess", partner);
		loginfo.info("Got the   partner details Sucessfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseData<String>> postPartnerDetails(@RequestBody Partner partner) {
		loginfo.info("Intilized the post  partner details  route");

		partnerService.postPartnerDetails(partner);
		ResponseData<String> response = new ResponseData("Sucess", "SucessfullyPostedPartnerDetails");
		loginfo.info(" Sucessfully posted  partner details  ");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/all")
	public ResponseEntity<ResponseData<String>> postListOfPartnerDetails(@RequestBody List<Partner> partner) {
		loginfo.info("Intilized the post list of  partner details  route");

		partnerService.postListOfPartnerDetails(partner);
		ResponseData<String> response = new ResponseData("Sucess", "SucessfullyPostedAllPartnerDetails");
		loginfo.info(" Sucessfully posted list of partner details  ");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")

	public ResponseEntity<ResponseData<Partner>> updatePartnerDetails(@RequestBody Partner partner,
			@PathVariable int id) {
		loginfo.info("Intilized the update partner details  route");

		Partner partner1 = partnerService.getPartnerById(id);
		if (partner1 == null) {
			loginfo.error("There was no partner details available in database with given id to update");

			throw new PartnerDetailsNotFoundException("No_detatils_available_with_id:" + id + "to_update_details");
		}
		ResponseData<Partner> response = new ResponseData("Sucess", partnerService.updatePartnerDetails(partner, id));
		loginfo.info(" Sucessfully updated partner details  ");

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseData<String>> deletePartnerDetailsById(@PathVariable int id) {
		loginfo.info("Intilized the delete partner details  route");

		Partner partner = partnerService.getPartnerById(id);
		if (partner == null) {
			loginfo.error("There was no partner details available in database with given id to delete");

			throw new PartnerDetailsNotFoundException("No_detatils_available_with_id:" + id + "to_delete_details");
		}

		partnerService.deletePartnerDetailsById(id);
		ResponseData<String> response = new ResponseData("Sucess", "SucessfullyDeletedPartnerDetails");
		loginfo.info(" Sucessfully deleted partner details  ");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

package com.example.partnerinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.partnerinfo.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {
public Partner findById(int id);
}

package com.iris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iris.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

}

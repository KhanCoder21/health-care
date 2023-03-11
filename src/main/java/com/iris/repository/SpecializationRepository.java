package com.iris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iris.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

	@Query("SELECT COUNT(specCode) FROM Specialization WHERE specCode=:specCode")
	Integer getSpecCodeCount(String specCode);

}

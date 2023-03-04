package com.iris.service;

import java.util.List;

import com.iris.entity.Specialization;

public interface SpecializationService {

	public Long saveSpecialization(Specialization specialization);

	public List<Specialization> getAllSpecialization();

	public void removeSpecializationById(Long id);

	public Specialization getSpecializationById(Long id);

	public void updateSpecialization(Specialization specialization);

}

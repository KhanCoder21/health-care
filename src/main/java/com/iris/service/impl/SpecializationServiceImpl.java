package com.iris.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.entity.Specialization;
import com.iris.repository.SpecializationRepository;
import com.iris.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository repository;

	@Override
	public Long saveSpecialization(Specialization specialization) {
		System.out.println("save method called");
		return repository.save(specialization).getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		System.out.println("Find all method called");
		return repository.findAll();
	}

	@Override
	public void removeSpecializationById(Long id) {
		System.out.println("deleteById method called");
		repository.deleteById(id);

	}

	@Override
	public Specialization getSpecializationById(Long id) {
		System.out.println("getSpecializationById method called");
		Optional<Specialization> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	@Override
	public void updateSpecialization(Specialization specialization) {
		System.out.println("update method called");
		repository.save(specialization);
	}

}

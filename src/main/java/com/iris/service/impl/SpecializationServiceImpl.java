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
		return repository.save(specialization).getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		Specialization spec = new Specialization(null, "CRDLS", "Cardiologists",
				"They are expert on the heart deasese");
		Specialization savedSpec = repository.save(spec);
		return repository.findAll();
	}

	@Override
	public void removeSpecializationById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Specialization getSpecializationById(Long id) {
		Optional<Specialization> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	@Override
	public void updateSpecialization(Specialization specialization) {
		repository.save(specialization);
	}

}

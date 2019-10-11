package com.david.slc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.slc.model.Slc;
import com.david.slc.repository.SlCRepository;

@Service
public class SlcService {

	private SlCRepository slCRepository;
	
	public SlcService(SlCRepository slCRepository) {
		this.slCRepository = slCRepository;
	}
	
	public List<Slc> findAll() {
		return this.slCRepository.findAll();
	}
	
	public void save(Slc entity) {
		this.slCRepository.save(entity);
	}
}

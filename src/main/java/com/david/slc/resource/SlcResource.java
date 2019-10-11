package com.david.slc.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.slc.model.Slc;
import com.david.slc.service.SlcService;

@RestController
@RequestMapping("/slc")
public class SlcResource implements Serializable {

	private static final long serialVersionUID = 8213536130274145863L;
	
	private SlcService slcService;
	
	@Autowired
	public SlcResource(SlcService slcService) {
		this.slcService = slcService;
	}

	@GetMapping
	public ResponseEntity<List<Slc>> findAll() {
		List<Slc> body = this.slcService.findAll();
	
		return ResponseEntity.ok(body);
	}
}

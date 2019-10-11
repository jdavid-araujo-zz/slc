package com.david.slc.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.slc.model.Slc;
import com.david.slc.service.FileService;
import com.david.slc.service.SlcService;

@RestController
@RequestMapping("/slc")
public class SlcResource implements Serializable {
	
	private SlcService slcService;
	private FileService FileService;
	
	@Autowired
	public SlcResource(SlcService slcService, FileService fileService) {
		this.slcService = slcService;
		this.FileService = fileService;
	}

	@GetMapping
	public ResponseEntity<List<Slc>> findAll() {
		List<Slc> body = this.slcService.findAll();
	
		return ResponseEntity.ok(body);
	}
}

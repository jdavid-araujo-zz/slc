package com.david.slc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.david.slc.model.Slc;
import com.david.slc.service.FileService;
import com.david.slc.service.SlcService;

@Component
public class DataLoader implements CommandLineRunner {

	private FileService fileService;
	private SlcService slcService;


	public DataLoader(FileService fileService, SlcService slcService) {
		this.fileService = fileService;
		this.slcService = slcService;
	}


	@Override
	public void run(String... args) throws Exception {
		int count = this.slcService.findAll().size();
		
		if(count == 0) {
			this.loadData();
		}		
	}
	
	private void loadData() {
		Slc entity = this.fileService.parse();
		
		this.slcService.save(entity);
	}
}

package com.file.uploadbd.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.uploadbd.method.FileDb;
import com.file.uploadbd.repository.FileDbRepository;

@Service
public class FileDbService {
	
	@Autowired
	private FileDbRepository fileDbRepository;
	
	
	public FileDb uploadFle(MultipartFile file) throws Exception {
		String fileName = file.getOriginalFilename();
		FileDb fileDb = new FileDb(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());
		return fileDbRepository.save(fileDb);
	}
	
//	public FileDb getFileById(String id) {
//		return fileDbRepository.findById(id);
//	}
	
	public FileDb getFileById(String id) {
		
		Optional<FileDb> fileOptional = Optional.of(fileDbRepository.getById(id));
		
		if(fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}
	
	public List<FileDb> getFileList() {
		return fileDbRepository.findAll();
	}

}

package com.file.uploadbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.uploadbd.method.FileDb;
import com.file.uploadbd.service.FileDbService;

@RestController
@RequestMapping("file")
public class FileDbController {
	
	@Autowired
	private FileDbService fileDbService;
	
	@PostMapping("/upload")
	public FileDb saveFile(@RequestParam("file") MultipartFile file) throws Exception {
		return fileDbService.uploadFle(file);
	}
	
	@GetMapping("getById/{id}")
	public FileDb getFile(@PathVariable String id) {
		return fileDbService.getFileById(id);
	}
	
	@GetMapping("getList/{list}")
	public List<FileDb> getList(){
		return fileDbService.getFileList();
	} 

}

package com.vttp2022.workshop16.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/boardgame")
public class Controller {

	@PostMapping
	public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
		if (null == file.getOriginalFilename()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);
			System.out.println(path.getFileName());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        //Logic to read http response and save file

		return new ResponseEntity<>("Good Job", HttpStatus.CREATED);
	}
}


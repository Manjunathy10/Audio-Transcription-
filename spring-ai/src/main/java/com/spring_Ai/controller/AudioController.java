package com.spring_Ai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring_Ai.service.AudioService;

@RestController
@RequestMapping("/api/v1/audio")
public class AudioController {

	private final AudioService audioService;

	public AudioController(AudioService audioService) {
		super();
		this.audioService = audioService;
	}

	// create a method foe handling a resouse folder madun class path spring ai text
	@PostMapping("/transript")
	public ResponseEntity<String> transriptAudio(@Value("${classpath:sample2.mp3}") Resource resource) {
		String responseText = audioService.convertAudioToText(resource);
		return ResponseEntity.ok(responseText);
	}

	// this method for add a audio file with user not hard coaded
	@PostMapping("/text")
	public ResponseEntity<String> speechToText(@RequestParam("audioFile") MultipartFile audioFile) {
		String responseText = audioService.convertAudioToText(audioFile.getResource());
		return ResponseEntity.ok(responseText);
	}

	@PostMapping("/transript-with-opetion")
	public ResponseEntity<String> transriptAudioWithOpetion(@Value("${classpath:sample2.mp3}") Resource resource) {
		String responseText = audioService.convertAudioToTextWithOpeton(resource);
		return ResponseEntity.ok(responseText);
	}

}

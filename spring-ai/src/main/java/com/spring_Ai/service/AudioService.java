package com.spring_Ai.service;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.spring_Ai.entity.Transcription;
import com.spring_Ai.repository.TranscriptionRepository;

@Service
public class AudioService {

	private final TranscriptionModel transcriptionModel;
	private final TranscriptionRepository transcriptionRepository;

	public AudioService(TranscriptionModel transcriptionModel, TranscriptionRepository transcriptionRepository) {
		this.transcriptionModel = transcriptionModel;
		this.transcriptionRepository = transcriptionRepository;
	}

	public String convertAudioToText(Resource inputAudio) {

		// 1. Perform transcription
		String text = transcriptionModel.transcribe(inputAudio);

		// 2. Save into DB
		Transcription entity = new Transcription(inputAudio.getFilename(), 0L, // size unknown from Resource
				"audio", // content type unknown from Resource
				text);

		transcriptionRepository.save(entity);

		// 3. Return text to controller
		return text;
	}

	public String convertAudioToTextWithOpeton(Resource resource) {

		String transcribe = transcriptionModel.transcribe(resource, OpenAiAudioTranscriptionOptions.builder()
				.language("en").temperature(0.7f).prompt("spring boot ").build());

		// Save DB record
		Transcription entity = new Transcription(resource.getFilename(), 0L, "audio", transcribe);

		transcriptionRepository.save(entity);

		return transcribe;
	}
}

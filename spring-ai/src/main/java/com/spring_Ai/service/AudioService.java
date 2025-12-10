package com.spring_Ai.service;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.ai.model.openai.autoconfigure.OpenAiAudioTranscriptionAutoConfiguration;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AudioService {

	private final TranscriptionModel transcriptionModel;

	public AudioService(TranscriptionModel transcriptionModel) {
		super();
		this.transcriptionModel = transcriptionModel;
	}

	public String convertAudioToText(Resource inputAudio) {
		
		// this line achually converting a speech to text format
		return transcriptionModel.transcribe(inputAudio);
	}

	public String convertAudioToTextWithOpeton(Resource resource) {
	String transcribe=	transcriptionModel.transcribe(resource, OpenAiAudioTranscriptionOptions.builder()
				
				.language("en")
				.temperature(0.7f)
				.prompt("spring boot ")
				
				.build());
		return transcribe;
	}

}

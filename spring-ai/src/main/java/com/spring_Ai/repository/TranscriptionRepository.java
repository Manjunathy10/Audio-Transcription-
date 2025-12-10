package com.spring_Ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_Ai.entity.Transcription;

public interface TranscriptionRepository extends JpaRepository<Transcription, Long> {

}

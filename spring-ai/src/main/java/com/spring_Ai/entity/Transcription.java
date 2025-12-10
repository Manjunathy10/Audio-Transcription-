package com.spring_Ai.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "transcriptions")
public class Transcription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fileName;

	private long fileSize;

	private String contentType;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String transcript;

	private LocalDateTime createdAt;

	// --- constructors ---

	public Transcription() {
	}

	public Transcription(String fileName, long fileSize, String contentType, String transcript) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.contentType = contentType;
		this.transcript = transcript;
		this.createdAt = LocalDateTime.now();
	}

	// --- getters & setters ---

	public Long getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public String getTranscript() {
		return transcript;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}

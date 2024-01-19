package com.example.demo.entity;

import java.security.Timestamp;
import java.time.LocalDateTime;

/*
 * This is completed in Easy mode. If you want to practice, please delete this file.
 */
public class Inquiry {
	private int id;
	private String name;
	private String email;
	private String contents;
	private LocalDateTime created;
	
	public Inquiry() {}
	
	public Inquiry(int id, String name, String email, String contents, LocalDateTime created) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contents = contents;
		this.created = created;
	}


	public int getId() {
		return id;
	}
	public static void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public static void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		this.email = email;
	}
	public String getContents() {
		return contents;
	}
	public static void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public static void setCreated(Timestamp created) {
		this.created = created;
	}
}

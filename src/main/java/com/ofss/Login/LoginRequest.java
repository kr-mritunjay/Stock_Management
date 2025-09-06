package com.ofss.Login;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class LoginRequest {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    private String username;

//    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public LoginRequest(Long id, String username, String passwordHash) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and setters

}

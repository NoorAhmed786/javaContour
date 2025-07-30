package com.noor.the_noor_residency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Double accountBalance = 0.0;

	public Object getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	
	public void setUsername(String username) { this.username = username; }

	public void setPassword(String password) { this.password = password; }

	public void setRole(Role role) { this.role = role; }

	public Double getAccountBalance() { return accountBalance; }
	public void setAccountBalance(Double accountBalance) { this.accountBalance = accountBalance; }

	


}

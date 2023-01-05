package com.example.demo.DemoEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user1")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	
	
	
}

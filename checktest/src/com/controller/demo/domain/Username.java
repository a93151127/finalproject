package com.controller.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="username")
public class Username {

@Id
@Column(name="username")
private String username;

public Username() {
	
}



public Username(String username) {

	this.username = username;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

@Override
public String toString() {
	return "Username [username=" + username + "]";
}

}

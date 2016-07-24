package strongerweb.dao;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import strongerweb.validators.ValidUsername;

public class UserAccount {
	public int id;
	@ValidUsername(min=4,max=50)
	public String username;
	public String name;
	public String email;
	@Size(min=6, max=50, message="Password must be btw 6 and 50 characters, inclusive")
	public String password;
	public int getId() {
		return id;
	}
	
	public UserAccount() {
		super();
	}

	public UserAccount(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}

}

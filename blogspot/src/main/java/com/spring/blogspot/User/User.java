package com.spring.blogspot.User;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private String name;
	private String password;
	private int age;
	private String gender;
	private String specialization;
	private String email;
	@Id
	private String u_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
    public User() {
        super();
    }
	public User(String name, String password, int age, String gender, String specialization, String email, String u_id) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.email = email;
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "user [name=" + name + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ ", specialization=" + specialization + ", email=" + email + ", u_id=" + u_id + "]";
	}
}

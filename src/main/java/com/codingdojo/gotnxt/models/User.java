package com.codingdojo.gotnxt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean adminAccount = false;
	
	@NotEmpty(message="You need a userName") 
	@Size(min=3, message="User Name must be min 3 characters")
	private String userName;
	
	@NotEmpty(message="Can not leave First Name blank") 
	private String firstName;
	
	@NotEmpty(message="Cannot leave Last Name blank") 
	private String lastName;
	
	@NotEmpty(message="Please fill in your email")
	@Email(message="Email must be a valid Email")
	private String email;
	
	@Size(min=8, message="Password must be min 8 charactors")
	private String password;
	
	@Size(min=8, message="Password must be min 8 charactors")
	@Transient
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-dd-MM")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-dd-MM")
	private Date updatedAt;
	
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "athletes_coming",
			joinColumns = @JoinColumn(name="athlete_id"),
			inverseJoinColumns = @JoinColumn(name="event_id")
			)
	private List<Event> events;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	@OneToMany(mappedBy="host",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	private List<Event> eventHost;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(boolean adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Event> getEventHost() {
		return eventHost;
	}

	public void setEventHost(List<Event> eventHost) {
		this.eventHost = eventHost;
	}


	
}

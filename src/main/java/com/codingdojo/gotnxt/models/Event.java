package com.codingdojo.gotnxt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.codingdojo.gotnxt.constraints.DatePresentOrFuture;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3)
	@NotBlank(message="Event must have a title!")
	private String title;
	
	@Size(min = 5)
	@NotBlank(message="Please associate a sport.")
	private String sport;
	
	@NotBlank(message="Location needed!")
	private String location;
	
	@NotNull
//	@FutureOrPresent(message="Date must not be in the past.")
	@DatePresentOrFuture
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	private String time;
	
//	@NotNull
//	@FutureOrPresent
//	@DateTimeFormat(pattern = "KK:mm")
//	private LocalTime time;
	
	@Size(min = 3, max = 400)
	private String details;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "athletes_coming",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns = @JoinColumn(name="athlete_id")
			)
	private List<User> athletes;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="host_id", nullable = false)
	private User host;

	public Event() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public List<User> getAthletes() {
		return athletes;
	}

	public void setAthletes(List<User> athletes) {
		this.athletes = athletes;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	

	

		
}

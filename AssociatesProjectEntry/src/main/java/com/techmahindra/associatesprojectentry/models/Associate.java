package com.techmahindra.associatesprojectentry.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String gID;

	private String name;

	private String location;

	@Transient
	private String port;
	

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="manager_id") 
	private Associate manager;

	@OneToMany(mappedBy="manager",fetch = FetchType.LAZY) 
	@JsonIgnore
	private Set<Associate> subordinates = new HashSet<Associate>();



	@ManyToOne
	private Project project;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getgID() {
		return gID;
	}


	public void setgID(String gID) {
		this.gID = gID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}



	public Associate getManager() { return manager; }


	public void setManager(Associate manager) { this.manager = manager; }


	public Set<Associate> getSubordinates() { return subordinates; }


	public void setSubordinates(Set<Associate> subordinates) { this.subordinates
		= subordinates; }



	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gID == null) ? 0 : gID.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		if (gID == null) {
			if (other.gID != null)
				return false;
		} else if (!gID.equals(other.gID))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Associate [id=" + id + ", gID=" + gID + ", name=" + name + ", location=" + location + "]";
	}


	public Associate(long id, String gID, String name, String location) {
		super();
		this.id = id;
		this.gID = gID;
		this.name = name;
		this.location = location;
	}


	public Associate() {
		
	}



}

package com.techmahindra.associatesprojectentry.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String projID;
	@Column(nullable = false)
	private String projName;
	
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	List<Associate> associates;
	
	protected Project() {
		
	}

	public Project(long id, String projID, String projName, String location, List<Associate> associates) {
		super();
		this.id = id;
		this.projID = projID;
		this.projName = projName;
		this.location = location;
		this.associates = associates;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjID() {
		return projID;
	}

	public void setProjID(String projID) {
		this.projID = projID;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(List<Associate> associates) {
		this.associates = associates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((projID == null) ? 0 : projID.hashCode());
		result = prime * result + ((projName == null) ? 0 : projName.hashCode());
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
		Project other = (Project) obj;
		if (associates == null) {
			if (other.associates != null)
				return false;
		} else if (!associates.equals(other.associates))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (projID == null) {
			if (other.projID != null)
				return false;
		} else if (!projID.equals(other.projID))
			return false;
		if (projName == null) {
			if (other.projName != null)
				return false;
		} else if (!projName.equals(other.projName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projID=" + projID + ", projName=" + projName + ", location=" + location
				+ ", associates=" + associates + "]";
	}
	
	
	
	
}

package com.techmahindra.associateservice.models;

public class AssociateBean {
	
	private Long id;
	
	private String gID;
	
	private String name;
	
	private String location;
	
	
	public AssociateBean() {
		
	}


	public AssociateBean(Long id, String gID, String name, String location) {
		super();
		this.id = id;
		this.gID = gID;
		this.name = name;
		this.location = location;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gID == null) ? 0 : gID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AssociateBean other = (AssociateBean) obj;
		if (gID == null) {
			if (other.gID != null)
				return false;
		} else if (!gID.equals(other.gID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "AssociateBean [id=" + id + ", gID=" + gID + ", name=" + name + ", location=" + location + "]";
	}

	
}

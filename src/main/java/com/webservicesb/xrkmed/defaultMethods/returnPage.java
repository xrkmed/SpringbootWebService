package com.webservicesb.xrkmed.defaultMethods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class returnPage implements Serializable {
	
	private int status;
	private HashMap<String, String> content = new HashMap<>();
	
	public returnPage() {
		
	}
	
	public returnPage(int statusCode) {
		super();
		status = statusCode;
	}
	
	public void insertBody(String type, String body){
		content.put(type, body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HashMap<String, String> getBodyMap() {
		return content;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		returnPage other = (returnPage) obj;
		return Objects.equals(content, other.content) && status == other.status;
	}
	
}

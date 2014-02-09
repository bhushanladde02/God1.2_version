package com.onine.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@Table(name="device")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int status;

    public Device() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
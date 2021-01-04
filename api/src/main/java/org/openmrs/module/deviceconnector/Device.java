/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.deviceconnector;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also DeviceconnectorDaoTest and liquibase.xml
@Entity(name = "deviceconnector.Device")
@Table(name = "deviceconnector_device")
public class Device extends BaseOpenmrsData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "deviceconnector_item_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Basic
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "udi_name", length = 255)
	private String name;
	
	@Column(name = "status", length = 255)
	private String deviceStatus;
	
	@Column(name = "lotNumber", length = 255)
	private String lotNumber;
	
	@Column(name = "manufacturer", length = 255)
	private String manufacturer;
	
	@Column(name = "manufactureDate")
	private Date manufactureDate;
	
	@Column(name = "expirationDate")
	private Date expirationDate;
	
	@Column(name = "model", length = 255)
	private String model;
	
	@Column(name = "version", length = 255)
	private String version;
	
	@Column(name = "url", length = 255)
	private String url;
	
	@Column(name = "note", length = 255)
	private String note;
	
	@Column(name = "location", length = 255)
	private String location;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDeviceStatus() {
		return deviceStatus;
	}
	
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	
	public String getLotNumber() {
		return lotNumber;
	}
	
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.deviceconnector.dao;

import org.junit.Test;
import org.junit.Ignore;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.deviceconnector.Device;
import org.openmrs.module.deviceconnector.api.dao.impl.HibernateDeviceconnectorDao;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;

/**
 * It is an integration test (extends BaseModuleContextSensitiveTest), which verifies DAO methods
 * against the in-memory H2 database. The database is initially loaded with data from
 * standardTestDataset.xml in openmrs-api. All test methods are executed in transactions, which are
 * rolled back by the end of each test method.
 */
public class DeviceconnectorDaoTest extends BaseModuleContextSensitiveTest {
	
	@Autowired
	HibernateDeviceconnectorDao dao;
	
	@Autowired
	UserService userService;
	
	@Test
	@Ignore("Unignore if you want to make the Item class persistable, see also Item and liquibase.xml")
	public void saveItem_shouldSaveAllPropertiesInDb() {
		//Given
		Device device = new Device();
		device.setDescription("some description");
		device.setOwner(userService.getUser(1));
		device.setName("Blood Pressure device");
		device.setDeviceStatus("active");
		device.setLotNumber("324523678");
		device.setManufacturer("BPDeviceManufacturer");
		device.setManufactureDate(new Date());
		device.setExpirationDate(new Date());
		device.setModel("original model");
		device.setVersion("1.0.0");
		device.setUrl("http://example.com/Device");
		device.setNote("some note");
		device.setLocation("some location");
		
		//When
		dao.saveDevice(device);
		
		//Let's clean up the cache to be sure getItemByUuid fetches from DB and not from cache
		Context.flushSession();
		Context.clearSession();
		
		//Then
		Device savedDevice = dao.getDeviceByUuid(device.getUuid());
		
		assertThat(savedDevice, hasProperty("uuid", is(device.getUuid())));
		assertThat(savedDevice, hasProperty("owner", is(device.getOwner())));
		assertThat(savedDevice, hasProperty("description", is(device.getDescription())));
		assertThat(savedDevice, hasProperty("name", is(device.getName())));
		assertThat(savedDevice, hasProperty("status", is(device.getDeviceStatus())));
		assertThat(savedDevice, hasProperty("lotNumber", is(device.getLotNumber())));
		assertThat(savedDevice, hasProperty("manufacturer", is(device.getManufacturer())));
		assertThat(savedDevice, hasProperty("manufactureDate", is(device.getManufactureDate())));
		assertThat(savedDevice, hasProperty("expirationDate", is(device.getExpirationDate())));
		assertThat(savedDevice, hasProperty("model", is(device.getModel())));
		assertThat(savedDevice, hasProperty("version", is(device.getVersion())));
		assertThat(savedDevice, hasProperty("url", is(device.getUrl())));
		assertThat(savedDevice, hasProperty("note", is(device.getNote())));
		assertThat(savedDevice, hasProperty("location", is(device.getLocation())));
	}
}

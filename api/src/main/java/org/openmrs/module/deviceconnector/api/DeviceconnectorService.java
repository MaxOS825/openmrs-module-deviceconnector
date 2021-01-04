/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.deviceconnector.api;

import java.util.List;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.deviceconnector.Device;
import org.openmrs.module.deviceconnector.DeviceconnectorConfig;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
@Transactional
public interface DeviceconnectorService extends OpenmrsService {
	
	/**
	 * Returns an item by uuid. It can be called by any authenticated user. It is fetched in read
	 * only transaction.
	 * 
	 * @param uuid
	 * @return
	 * @throws APIException
	 */
	@Authorized()
	@Transactional(readOnly = true)
	Device getDeviceByUuid(String uuid) throws APIException;
	
	/**
	 * Saves an item. Sets the owner to superuser, if it is not set. It can be called by users with
	 * this module's privilege. It is executed in a transaction.
	 * 
	 * @param item
	 * @return
	 * @throws APIException
	 */
	@Authorized(DeviceconnectorConfig.MODULE_PRIVILEGE)
	@Transactional
	Device saveDevice(Device device) throws APIException;
	
	/**
	 * Gets a list of devices.
	 * 
	 * @return the device list.
	 */
	@Transactional(readOnly = true)
	List<Device> getAllDevices();
	
	/**
	 * Gets a device for a given id.
	 * 
	 * @param id the device id
	 * @return the device with the given id
	 */
	@Transactional(readOnly = true)
	Device getDevice(Integer deviceId);
	
	/**
	 * Deletes a device from the database.
	 * 
	 * @param device the device to delete.
	 */
	void purgeDevice(Device device);
}

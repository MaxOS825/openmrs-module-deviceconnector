package org.openmrs.module.deviceconnector.api.dao;

import java.util.List;

import org.openmrs.module.deviceconnector.Device;

/**
 * Database methods for (@link DepartmentService)
 * 
 * @author mossa
 */
public interface DeviceconnectorDao {
	
	/**
	 * @see org.openmrs.module.deviceconnector.api.DeviceconnectorService#getAllDevices()
	 */
	List<Device> getAllDevices();
	
	/**
	 * @see org.openmrs.module.deviceconnector.api.DeviceconnectorService#getDevice(java.lang.Integer)
	 */
	Device getDevice(Integer deviceId);
	
	/**
	 * @see org.openmrs.module.deviceconnector.api.DeviceconnectorService#getDeviceByUuid(java.lang.String)
	 */
	Device getDeviceByUuid(String uuId);
	
	/**
	 * @see org.openmrs.module.deviceconnector.api.DeviceconnectorService#saveDevice(org.openmrs.module.deviceconnector.Device)
	 */
	Device saveDevice(Device device);
	
	/**
	 * @see org.openmrs.module.deviceconnector.api.DeviceconnectorService#purgeDevice(org.openmrs.module.deviceconnector.Device)
	 */
	void purgeDevice(Device device);
}

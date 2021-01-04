/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.deviceconnector.api.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.deviceconnector.Device;
import org.openmrs.module.deviceconnector.api.dao.DeviceconnectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("deviceconnector.HibernateDeviceconnectorDao")
public class HibernateDeviceconnectorDao implements DeviceconnectorDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Device getDeviceByUuid(String uuid) {
		return (Device) getSession().createCriteria(Device.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public Device saveDevice(Device device) {
		getSession().saveOrUpdate(device);
		return device;
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public DbSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * @see org.openmrs.module.department.api.db.DepartmentDAO#getAllDepartments()
	 */
	@Override
	public List<Device> getAllDevices() {
		return (List<Device>) sessionFactory.getCurrentSession().createCriteria(Device.class).list();
	}
	
	/**
	 * @see org.openmrs.module.department.api.DepartmentService#getDepartment(java.lang.Integer)
	 */
	@Override
	public Device getDevice(Integer deviceId) {
		return (Device) sessionFactory.getCurrentSession().get(Device.class, deviceId);
	}
	
	/**
	 * @see org.openmrs.module.department.api.db.DepartmentDAO#purgeDepartment(org.openmrs.module.department.Department)
	 */
	@Override
	public void purgeDevice(Device device) {
		sessionFactory.getCurrentSession().delete(device);
	}
	
}

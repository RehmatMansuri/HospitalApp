package com.hospitalapp.serviceimpl;

import java.util.List;

import com.hospitalapp.dao.AppointmentDao;
import com.hospitalapp.daoimpl.AppointmentDaoImpl;
import com.hospitalapp.pojo.Appointment;
import com.hospitalapp.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentDao bookAppointmentDao = new AppointmentDaoImpl();
	
	@Override
	public Appointment add(Appointment pojo) {
		// TODO Auto-generated method stub
		return bookAppointmentDao.add(pojo);
	}

	@Override
	public Appointment update(Appointment pojo) {
		// TODO Auto-generated method stub
		return bookAppointmentDao.update(pojo);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return bookAppointmentDao.delete(id);
	}

	@Override
	public Appointment get(Integer id) {
		// TODO Auto-generated method stub
		return bookAppointmentDao.get(id);
	}

	@Override
	public List<Appointment> getAll() {
		// TODO Auto-generated method stub
		return bookAppointmentDao.getAll();
	}

	@Override
	public boolean isAppointmentAvailable(String appointmentDate) {
		// TODO Auto-generated method stub
		return bookAppointmentDao.isAppointmentAvailable(appointmentDate);
	}
	
}

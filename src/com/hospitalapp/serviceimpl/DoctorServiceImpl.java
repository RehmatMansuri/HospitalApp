package com.hospitalapp.serviceimpl;

import java.util.List;

import com.hospitalapp.dao.DoctorDao;
import com.hospitalapp.daoimpl.DoctorDaoImpl;
import com.hospitalapp.pojo.Doctor;
import com.hospitalapp.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorService = new DoctorDaoImpl();
	
	@Override
	public Doctor add(Doctor pojo) {
		// TODO Auto-generated method stub
		return doctorService.add(pojo);
	}

	@Override
	public Doctor update(Doctor pojo) {
		// TODO Auto-generated method stub
		return doctorService.update(pojo);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return doctorService.delete(id);
	}

	@Override
	public Doctor get(Integer id) {
		// TODO Auto-generated method stub
		return doctorService.get(id);
	}

	@Override
	public List<Doctor> getAll() {
		// TODO Auto-generated method stub
		return doctorService.getAll();
	}

}

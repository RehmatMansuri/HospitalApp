package com.hospitalapp.serviceimpl;

import java.util.List;

import com.hospitalapp.dao.PatientDao;
import com.hospitalapp.daoimpl.PatientDaoImpl;
import com.hospitalapp.pojo.Patient;
import com.hospitalapp.service.PatientService;

public class PatientServiceImpl implements PatientService {

	private PatientDao patientDao = new PatientDaoImpl();
	
	@Override
	public Patient add(Patient pojo) {
		// TODO Auto-generated method stub
		return patientDao.add(pojo);
	}

	@Override
	public Patient update(Patient pojo) {
		// TODO Auto-generated method stub
		return patientDao.update(pojo);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return patientDao.delete(id);
	}

	@Override
	public Patient get(Integer id) {
		// TODO Auto-generated method stub
		return patientDao.get(id);
	}

	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		return patientDao.getAll();
	}

}

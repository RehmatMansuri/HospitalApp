package com.hospitalapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospitalapp.dao.DoctorDao;
import com.hospitalapp.pojo.Doctor;
import com.hospitalapp.utility.HospitalConnect;

public class DoctorDaoImpl implements DoctorDao {

	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {

			con = HospitalConnect.getConnection();
			ps = con.prepareStatement("Select * from doctors");
			rs = ps.executeQuery();

			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setId(rs.getInt("doctorId"));
				doctor.setName(rs.getString("dName"));
				doctor.setSpecialization(rs.getString("Specialization"));

				doctors.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctors;
	}

	@Override
	public Doctor get(Integer id) {
		Doctor doctor = new Doctor();
		try {
			con = HospitalConnect.getConnection();
			ps = con.prepareStatement(" select * from doctors where doctorId= ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			
			if (rs.next()) {

				doctor.setId(rs.getInt("doctorId"));
				doctor.setName(rs.getString("dName"));
				doctor.setSpecialization(rs.getString("Specialization"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doctor;
	}

	@Override
	public Doctor add(Doctor pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor update(Doctor pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

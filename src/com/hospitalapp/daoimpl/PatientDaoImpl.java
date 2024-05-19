package com.hospitalapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospitalapp.dao.PatientDao;
import com.hospitalapp.pojo.Patient;
import com.hospitalapp.utility.HospitalConnect;

public class PatientDaoImpl implements PatientDao {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	@Override
	public Patient add(Patient patient) {
		try {

			con = HospitalConnect.getConnection();
			ps = con.prepareStatement("insert into patient(name, age, gender) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, patient.getpName());
			ps.setInt(2, patient.getpAge());
			ps.setString(3, patient.getpGender());
			int row = ps.executeUpdate();
			if (row > 0) {
				ResultSet resultSet = ps.getGeneratedKeys();
				if(resultSet.next())
					patient.setPatientId(resultSet.getInt(1));
				return patient;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Patient update(Patient patient) {
		try {
			con = HospitalConnect.getConnection();
			ps = con.prepareStatement("update patient set name=?,age=?,gender=? where id=?");

			ps.setString(1, patient.getpName());
			ps.setInt(2, patient.getpAge());
			ps.setString(3, patient.getpGender());
			ps.setInt(4, patient.getPatientId());

			int row = ps.executeUpdate();
			if (row > 0) {
				return patient;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer delete(Integer patientId) {
		Integer updateRows = 0;
		try {
			con = HospitalConnect.getConnection();
			ps = con.prepareStatement("Delete from patient where id=?");
			ps.setInt(1, patientId);
			updateRows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	@Override
	public List<Patient> getAll() {
		List<Patient> patients = new ArrayList<Patient>();
		try {

			con = HospitalConnect.getConnection();
			ps = con.prepareStatement("Select * from patient");
			rs = ps.executeQuery();

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setpName(rs.getString("name"));
				patient.setPatientId(rs.getInt("id"));
				patient.setpAge(rs.getInt("age"));
				patient.setpGender(rs.getString("gender"));

				patients.add(patient);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return patients;
	}

	@Override
	public Patient get(Integer patientId) {
		Patient patient = new Patient();
		try {
			con = HospitalConnect.getConnection();
			ps = con.prepareStatement(" select * from patient where Id= ?");
			ps.setInt(1, patientId);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				patient.setpName(rs.getString("name"));
				patient.setPatientId(rs.getInt("id"));
				patient.setpAge(rs.getInt("age"));
				patient.setpGender(rs.getString("gender"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patient;
	}

}

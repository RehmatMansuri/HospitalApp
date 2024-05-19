package com.hospitalapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospitalapp.dao.AppointmentDao;
import com.hospitalapp.pojo.Appointment;
import com.hospitalapp.utility.HospitalConnect;

public class AppointmentDaoImpl implements AppointmentDao {
	Connection con;

	public AppointmentDaoImpl() {
		con = HospitalConnect.getConnection();
	}

	@Override
	public Appointment add(Appointment pojo) {
		try {

			PreparedStatement preparedStatement = con.prepareStatement(
					"insert into appointment(patient_Id, doctor_Id, appointment_date) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, pojo.getPatientId());
			preparedStatement.setInt(2, pojo.getDoctorId());
			preparedStatement.setString(3, pojo.getAppointmentDate());
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next())
					pojo.setId(resultSet.getInt(1));
				return pojo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Appointment update(Appointment pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAll() {
		List<Appointment> appointments = new ArrayList<>();
		try {

			PreparedStatement preparedStatement = con.prepareStatement("Select * from Appointment");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setId(rs.getInt("id"));
				appointment.setPatientId(rs.getInt("patient_Id"));
				appointment.setDoctorId(rs.getInt("doctor_Id"));
				appointment.setAppointmentDate(rs.getString("appointment_date"));

				appointments.add(appointment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appointments;
	}

	@Override
	public boolean isAppointmentAvailable(String appointmentDate) {
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("Select * from Appointment where appointment_date = ?");
			preparedStatement.setString(1, appointmentDate);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}

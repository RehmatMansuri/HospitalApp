package com.hospitalapp.test;

import java.util.List;
import java.util.Scanner;

import com.hospitalapp.pojo.Appointment;
import com.hospitalapp.pojo.Doctor;
import com.hospitalapp.pojo.Patient;
import com.hospitalapp.service.AppointmentService;
import com.hospitalapp.service.DoctorService;
import com.hospitalapp.service.PatientService;
import com.hospitalapp.serviceimpl.AppointmentServiceImpl;
import com.hospitalapp.serviceimpl.DoctorServiceImpl;
import com.hospitalapp.serviceimpl.PatientServiceImpl;

public class AppointmentView {

	private PatientService patientService = new PatientServiceImpl();
	private DoctorService doctorService = new DoctorServiceImpl();
	private AppointmentService appointmentService = new AppointmentServiceImpl();

	private PatientTest patientTest = new PatientTest();

	public void bookAnAppointment() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient Id or 0 if its a new patient");
		int patientId = sc.nextInt();
		Patient patient;
		if (patientId == 0) {
			patient = patientTest.addPateint();
		} else {
			patient = patientService.get(patientId);
		}
		System.out.println("patient details: "+patient);

		System.out.println("Show Doctor List");

		List<Doctor> doctors = doctorService.getAll();

		for (int i = 1; i <= doctors.size(); i++) {
			Doctor doctor = doctors.get((i - 1));
			System.out.println(i + ". " + doctor.getName() + " " + doctor.getSpecialization());
		}

		System.out.println("select doctor id");
		Integer doctorId = sc.nextInt();

		boolean whiling = true;
		while (whiling) {
			System.out.println("Enter appointmanet date (DD-MM-YYYY): ");
			String appointmentDate = sc.next();

			boolean isAvailable = appointmentService.isAppointmentAvailable(appointmentDate);

			if (!isAvailable) {
				System.err.println(
						"Appointment is not available for this date " + appointmentDate + ", please try with new date");
				continue;
			}

			Appointment appointment = new Appointment(null, patient.getPatientId(), doctorId, appointmentDate);
			appointmentService.add(appointment);
			System.out.println("Appointment is successfully booked!!");
			System.out.println();

			whiling = false;
		}
	}

	/*
	 * if (PatientDaoImpl.searchPatientById(patientId) &&
	 * DoctorDaoImpl.searchDoctorstById(doctorId)) { if
	 * (checkDoctorAvailability(doctorId, appointmentDate, con)) { String
	 * appointmentQuery =
	 * "insert into appointments(patient_id, doctor_id, appointment_date) values(?,?,?)"
	 * ;
	 * 
	 * try { PreparedStatement preparedStatement =
	 * con.prepareStatement(appointmentQuery); preparedStatement.setInt(1,
	 * doctorId); preparedStatement.setInt(2, doctorId);
	 * preparedStatement.setString(3, appointmentDate); int rowsAffected =
	 * preparedStatement.executeUpdate(); if (rowsAffected > 0) {
	 * System.out.println("Appointment Booked"); } else {
	 * System.out.println("Failed"); } } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * } else { System.out.println("Doctor not vailable in this date"); } } else {
	 * System.out.println("Either doctor or patient doesn't exist"); }
	 * 
	 * }
	 */

	/*
	 * public boolean checkDoctorAvailability(int doctorId, String appointmentDate,
	 * Connection con) { String query =
	 * "SELECT count(*) from appointments where doctor_id=? AND appointment_date=?";
	 * try { PreparedStatement prepareStatement = con.prepareStatement(query);
	 * prepareStatement.setInt(1, doctorId); prepareStatement.setString(2,
	 * appointmentDate); ResultSet resultSet = prepareStatement.executeQuery(); if
	 * (resultSet.next()) { int count = resultSet.getInt(doctorId); return count ==
	 * 0; }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } return false; }
	 */
}

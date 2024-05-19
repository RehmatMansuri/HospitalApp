package com.hospitalapp;

import java.util.Scanner;

import com.hospitalapp.test.AppointmentView;
import com.hospitalapp.test.DoctorTest;
import com.hospitalapp.test.PatientTest;

public class HospitalApp {

	public static void main(String[] args) {
		AppointmentView appointmentView = new AppointmentView();
		DoctorTest doctorTest = new DoctorTest();
		PatientTest patientTest = new PatientTest();
		
		

		Scanner scanner = new Scanner(System.in);
		boolean whiling = true;
		while (whiling) {
			System.out.println("****  WELCOME TO MY HOSPITAL  ****");
			System.out.println("1. Book an Appointment");
			System.out.println("2. Show Doctor List");
			System.out.println("3. Add patient details");
			System.out.println("4. Update patient List");
			System.out.println("5. Show patient details");
			System.out.println("6. Delete patient");
			System.out.println("7. Exit the App");
			
			Integer option = scanner.nextInt();
			switch (option) {
			case 1:
				appointmentView.bookAnAppointment();
				break;
			case 2:
				doctorTest.searchDoctor();
				break;
			case 3:
				patientTest.addPateint();
				break;
			case 4:
				patientTest.updatePatient();
				break;
			case 5:
				patientTest.showAllPatient();
				break;
			case 6:
				patientTest.deletePatient();
				break;
			case 7:
			default:
				System.out.println("Exiting the App.. Thank you!!");
				whiling = false;
			}
			if(whiling)
			System.out.println("Anything else you want to do?");
		}
//		scanner.close();
	}
}

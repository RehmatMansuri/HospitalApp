package com.hospitalapp.view;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hospitalapp.pojo.Patient;
import com.hospitalapp.service.PatientService;
import com.hospitalapp.serviceimpl.PatientServiceImpl;

public class PatientView {
	private PatientService patientService = new PatientServiceImpl();
	Scanner scanner;
	public PatientView() {
		// TODO Auto-generated constructor stub
		scanner = new Scanner(System.in);
	}
	

	public void openPatientApp() throws IOException {

		boolean doWhile = true;
		while (doWhile) {
			System.out.println("1.add");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.search");
			System.out.println("5.show all");
			System.out.println("6.exit");

			System.out.println("Enter choice");
			

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addPateint();
				break;
			case 2:
				updatePatient();
				break;
			case 3:
				deletePatient();
				break;
			case 4:
				getPatient();
				break;
			case 5:
				showAllPatient();
				break;
			case 6:
				System.out.println("Exiting.. Thank you");
				doWhile = false;
				break;
			default:
				System.out.println("cannot define identify.. please try again!");
			}
			scanner.close();
		}

	}

	public Patient addPateint() {
		System.out.println("Add patient ");

		System.out.println("Enter the patient name: ");
		String name = scanner.nextLine();
		System.out.println("Enter the patient age: ");
		Integer age = scanner.nextInt();
		System.out.println("Enter patient's gender as Male or Female: ");
		String gender = scanner.next();

		Patient patient = patientService.add(new Patient(null, name, age, gender));

		if (patient != null) {
			System.out.println("Patient Successfully");
		} else {
			System.out.println("Failed");
		}
		return patient;
	}

	public void updatePatient() {
		System.out.println("Enter the patientId: ");
		Integer patientId = scanner.nextInt();
		Patient patient = patientService.get(patientId);
		System.out.println(patient);
		
		System.out.println("Enter Patient name: ");
		String name = scanner.nextLine();
		patient.setpName(name);
		System.out.println("Enter patient age: ");
		Integer age = scanner.nextInt();
		patient.setpAge(age);
		System.out.println("Enter patient gender: ");
		String gender = scanner.nextLine();
		patient.setpGender(gender);

		Patient updatedPatient = patientService.update(patient);

		if (updatedPatient != null) {
			System.out.println("Successfully");
		} else {
			System.out.println("Failed");
		}
	}

	public void deletePatient() {
		System.out.println("Enter the Patient Id for delete: ");
		Integer patientId = scanner.nextInt();
		Integer row = patientService.delete(patientId);
		if (row > 0) {
			System.out.println("Successfuly");
		} else {
			System.out.println("Failed");
		}
	}

	private void getPatient() {
		System.out.println("Enter the Patient id for search: ");
		Integer patientId = scanner.nextInt();
		Patient patient = patientService.get(patientId);
		if (patient != null && patientId == patient.getPatientId()) {
			System.out.println(patient);
		} else {
			System.out.println("Not available");
		}
	}

	public void showAllPatient() {
		System.out.println("show all Patients");
		List<Patient> patients = patientService.getAll();
		Iterator<Patient> it = patients.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

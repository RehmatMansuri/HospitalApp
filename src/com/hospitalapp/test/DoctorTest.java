package com.hospitalapp.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hospitalapp.dao.DoctorDao;
import com.hospitalapp.daoimpl.DoctorDaoImpl;
import com.hospitalapp.pojo.Doctor;

public class DoctorTest {
	public void searchDoctor() {

		Scanner sc = new Scanner(System.in);

		int doctorId;
		DoctorDao doctorDao = new DoctorDaoImpl();

		System.out.println("1.search");
		System.out.println("2.show all");
		System.out.println("Enter choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter the doctor Id for search: ");
			doctorId = sc.nextInt();
			Doctor doctor = new Doctor();
			doctor = doctorDao.get(doctorId);
			if (doctor != null && doctorId == doctor.getId()) {
				System.out.println(doctor);
			} else {
				System.out.println("Not available");
			}
			break;
		case 2:
			System.out.println("show all");
			List<Doctor> doctors = doctorDao.getAll();
			Iterator<Doctor> it = doctors.iterator();

			while (it.hasNext()) {
				System.out.println(it.next());
			}
			break;

		}
	}
}

package com.hospitalapp.service;

import com.hospitalapp.pojo.Appointment;

public interface AppointmentService extends CrudService<Appointment>{
	boolean isAppointmentAvailable(String appointmentService);
}

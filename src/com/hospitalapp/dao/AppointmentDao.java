package com.hospitalapp.dao;

import com.hospitalapp.pojo.Appointment;

public interface AppointmentDao extends CrudDao<Appointment> {

	boolean isAppointmentAvailable(String appointmentDate);

}

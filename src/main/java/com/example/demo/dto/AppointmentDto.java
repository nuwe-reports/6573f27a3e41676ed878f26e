package com.example.demo.dto;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Appointment}
 */
public class AppointmentDto implements Serializable {
    private long id;

    @NotNull
    private Patient patient;

    @NotNull
    private Doctor doctor;

    @NotNull
    private Room room;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime startsAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime finishesAt;

    public AppointmentDto() {
    }

    public AppointmentDto(long id, Patient patient, Doctor doctor, Room room, LocalDateTime startsAt, LocalDateTime finishesAt) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.room = room;
        this.startsAt = startsAt;
        this.finishesAt = finishesAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public LocalDateTime getFinishesAt() {
        return finishesAt;
    }

    public void setFinishesAt(LocalDateTime finishesAt) {
        this.finishesAt = finishesAt;
    }
}
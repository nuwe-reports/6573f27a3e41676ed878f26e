package com.example.demo.dto;

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
    private PatientDto patient;

    @NotNull
    private DoctorDto doctor;

    @NotNull
    private RoomDto room;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime startsAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime finishesAt;

    public AppointmentDto() {
    }

    public AppointmentDto(long id, PatientDto patient, DoctorDto doctor, RoomDto room, LocalDateTime startsAt, LocalDateTime finishesAt) {
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

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
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
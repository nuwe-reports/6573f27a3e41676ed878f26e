package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Appointment}
 */
public class AppointmentDto implements Serializable {
    private long id;
    private PatientDto patient;
    private DoctorDto doctor;
    private RoomDto room;
    private LocalDateTime startsAt;
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

    /**
     * DTO for {@link com.example.demo.entities.Patient}
     */
    public static class PatientDto implements Serializable {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private long id;

        public PatientDto() {
        }

        public PatientDto(String firstName, String lastName, int age, String email, long id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    /**
     * DTO for {@link com.example.demo.entities.Doctor}
     */
    public static class DoctorDto implements Serializable {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private long id;

        public DoctorDto() {
        }

        public DoctorDto(String firstName, String lastName, int age, String email, long id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    /**
     * DTO for {@link com.example.demo.entities.Room}
     */
    public static class RoomDto implements Serializable {
        private String roomName;

        public RoomDto() {
        }

        public RoomDto(String roomName) {
            this.roomName = roomName;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
    }
}
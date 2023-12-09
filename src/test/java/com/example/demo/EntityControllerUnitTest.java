
package com.example.demo;

import com.example.demo.controllers.DoctorController;
import com.example.demo.controllers.PatientController;
import com.example.demo.controllers.RoomController;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(DoctorController.class)
class DoctorControllerUnitTest{

    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static private Doctor doctor;

    @BeforeAll
    static void setUp(){
        doctor = new Doctor ("Perla", "Amalia", 24, "p.amalia@hospital.accwe");
    }

    @Test
    void shouldGetDoctorById() throws Exception {

        Optional<Doctor> opt = Optional.of(doctor);
        when(doctorRepository.findById(doctor.getId())).thenReturn(opt);
        mockMvc.perform(get("/api/doctors/" + doctor.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetTwoDoctor() throws Exception {
        Doctor doctor2 = new Doctor ("Pippo", "Baudo", 29, "b.pippo@hospital.accwe");
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        doctorList.add(doctor2);

        when(doctorRepository.findAll()).thenReturn(doctorList);
        mockMvc.perform(get("/api/doctors"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotGetAnyDoctorById() throws Exception{
        long id = 31;
        mockMvc.perform(get("/api/doctors/" + id))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldCreateDoctor() throws Exception {
        mockMvc.perform(post("/api/doctor").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteDoctor() throws Exception {
        Optional<Doctor> opt = Optional.of(doctor);
        when(doctorRepository.findById(doctor.getId())).thenReturn(opt);
        mockMvc.perform(delete("/api/doctors/" + doctor.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteAllDoctors() throws Exception {
        Doctor doctor2 = new Doctor ("Pippo", "Baudo", 29, "b.pippo@hospital.accwe");
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        doctorList.add(doctor2);

        when(doctorRepository.findAll()).thenReturn(doctorList);
        mockMvc.perform(delete("/api/doctors"))
                .andExpect(status().isOk());
    }
}


@WebMvcTest(PatientController.class)
class PatientControllerUnitTest{

    @MockBean
    private PatientRepository patientRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static private Patient patient;

    @BeforeAll
    static void setUp() {
        patient = new Patient("Jose Luis", "Olaya", 37, "j.olaya@email.com");
    }

    @Test
    void shouldGetPatientById() throws Exception {

        Optional<Patient> opt = Optional.of(patient);
        when(patientRepository.findById(patient.getId())).thenReturn(opt);
        mockMvc.perform(get("/api/patients/" + patient.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotGetAnyPatientById() throws Exception{
        long id = 31;
        mockMvc.perform(get("/api/patients/" + id))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldCreatePatient() throws Exception {
        mockMvc.perform(post("/api/patient").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeletePatient() throws Exception {
        Optional<Patient> opt = Optional.of(patient);
        when(patientRepository.findById(patient.getId())).thenReturn(opt);
        mockMvc.perform(delete("/api/patients/" + patient.getId()))
                .andExpect(status().isOk());
    }

}

@WebMvcTest(RoomController.class)
class RoomControllerUnitTest{

    @MockBean
    private RoomRepository roomRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static private Room room;

    @BeforeAll
    static void setUp(){
        room = new Room("Dermatology");
    }

    @Test
    void shouldGetRoomByRoomName() throws Exception {
        Optional<Room> opt = Optional.of(room);
        when(roomRepository.findByRoomName(room.getRoomName())).thenReturn(opt);
        mockMvc.perform(get("/api/rooms/" + room.getRoomName()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetTwoRoom() throws Exception {
        Room room2 = new Room("NewRoomName");
        List<Room> roomList = new ArrayList<>();
        roomList.add(room);
        roomList.add(room2);

        when(roomRepository.findAll()).thenReturn(roomList);
        mockMvc.perform(get("/api/rooms"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotGetAnyRoomByRoomName() throws Exception{
        String roomName = "testRoomName";
        mockMvc.perform(get("/api/rooms/" + roomName))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldCreateRoom() throws Exception {
        mockMvc.perform(post("/api/room").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(room)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteRoom() throws Exception {
        Optional<Room> opt = Optional.of(room);
        when(roomRepository.findByRoomName(room.getRoomName())).thenReturn(opt);
        mockMvc.perform(delete("/api/rooms/" + room.getRoomName()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteAllRoom() throws Exception {
        Room room2 = new Room("NewRoomName");
        List<Room> roomList = new ArrayList<>();
        roomList.add(room);
        roomList.add(room2);
        when(roomRepository.findAll()).thenReturn(roomList);
        mockMvc.perform(delete("/api/rooms"))
                .andExpect(status().isOk());
    }

}

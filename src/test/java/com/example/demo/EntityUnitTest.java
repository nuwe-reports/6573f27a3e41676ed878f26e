package com.example.demo;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

	@Autowired
	private TestEntityManager entityManager;

	private Doctor d1;

	private Patient p1;

    private Room r1;

    private Appointment a1;
    private Appointment a2;
    private Appointment a3;

    @BeforeAll
    void setUp() {
        p1 = new Patient("Jose Luis", "Olaya", 37, "j.olaya@email.com");
        d1 = new Doctor ("Perla", "Amalia", 24, "p.amalia@hospital.accwe");
        r1 = new Room("Dermatology");
    }

    @Test
    void patientTest() {

        assertThat(p1)
                .hasFieldOrPropertyWithValue("age", 37)
                .hasFieldOrPropertyWithValue("email", "j.olaya@email.com")
                .hasFieldOrPropertyWithValue("firstName", "Jose Luis")
                .hasFieldOrPropertyWithValue("lastName", "Olaya");

        p1.setAge(38);
        p1.setEmail("test@test.it");
        p1.setFirstName("Pippo");
        p1.setLastName("Baudo");

        assertThat(p1)
                .hasFieldOrPropertyWithValue("age", 38)
                .hasFieldOrPropertyWithValue("email", "test@test.it")
                .hasFieldOrPropertyWithValue("firstName", "Pippo")
                .hasFieldOrPropertyWithValue("lastName", "Baudo");


        p1 = entityManager.persistAndFlush(p1);
        Long id = p1.getId();
        assertThat(p1.getId()).isEqualTo(id);

    }

    @Test
    void doctorTest() {

        assertThat(d1)
                .hasFieldOrPropertyWithValue("age", 24)
                .hasFieldOrPropertyWithValue("email", "p.amalia@hospital.accwe")
                .hasFieldOrPropertyWithValue("firstName", "Perla")
                .hasFieldOrPropertyWithValue("lastName", "Amalia");

        d1.setAge(38);
        d1.setEmail("test@test.it");
        d1.setFirstName("Pippo");
        d1.setLastName("Baudo");

        assertThat(d1)
                .hasFieldOrPropertyWithValue("age", 38)
                .hasFieldOrPropertyWithValue("email", "test@test.it")
                .hasFieldOrPropertyWithValue("firstName", "Pippo")
                .hasFieldOrPropertyWithValue("lastName", "Baudo");

        d1 = entityManager.persistAndFlush(d1);
        Long id = d1.getId();
        assertThat(d1.getId()).isEqualTo(id);


    }

    @Test
    void roomTest(){

        assertThat(r1.getRoomName()).isEqualTo("Dermatology");

        r1 = entityManager.persistAndFlush(r1);

        assertThat(r1.getRoomName()).isEqualTo("Dermatology");


    }

    @Test
    void appointmentTest() {

        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        assertThat(a1)
                .hasFieldOrPropertyWithValue("patient", p1)
                .hasFieldOrPropertyWithValue("doctor", d1)
                .hasFieldOrPropertyWithValue("room", r1);

        Patient p2 = new Patient("New FirstName", "Olaya", 37, "j.olaya@email.com");
        Doctor d2 = new Doctor ("New FirstName", "Amalia", 24, "p.amalia@hospital.accwe");
        Room r2 = new Room("NewRoom");

        a2 = new Appointment();
        a2.setPatient(p2);
        a2.setDoctor(d2);
        a2.setRoom(r2);
        a2.setStartsAt(startsAt);
        a2.setFinishesAt(finishesAt);

        assertThat(a1.overlaps(a2)).isFalse();

        a3 = new Appointment(p2, d2, r1, startsAt, finishesAt);

        assertThat(a1.overlaps(a3)).isTrue();

    }
}

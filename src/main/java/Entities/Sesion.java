package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "sessions")
public class Sesion {
    @Id
    @Column(name = "week_day")
    private String week_day;

    //@Id
    @Column(name = "starts")
    private Time starts;

    //@Id
    @Column(name = "finishes")
    private Time finishes;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Profesor profesor;
    //private int teacher_id;


    @ManyToOne
    @JoinColumn(name = "subject_code")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "group_code")
    private Grupo grupo;
    //private String subject_code;


    public Sesion() {
    }

    public Sesion(String week_day, Time starts, Time finishes, Profesor profesor, Asignatura asignatura, Grupo grupo) {
        this.week_day = week_day;
        this.starts = starts;
        this.finishes = finishes;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.grupo = grupo;
        //this.teacher_id = teacher_id;
        //this.subject_code = subject_code;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public Time getStarts() {
        return starts;
    }

    public void setStarts(Time starts) {
        this.starts = starts;
    }

    public Time getFinishes() {
        return finishes;
    }

    public void setFinishes(Time finishes) {
        this.finishes = finishes;
    }

    /*public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }*/

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
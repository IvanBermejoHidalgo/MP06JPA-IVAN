package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Grupo {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "curriculum")
    private String curriculum;

    @Column(name = "course")
    private int course;

    public Grupo() {
    }

    public Grupo(String code, String curriculum, int course) {
        this.code = code;
        this.curriculum = curriculum;
        this.course = course;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

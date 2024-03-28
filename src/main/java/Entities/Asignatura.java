package Entities;
import jakarta.persistence.*;


@Entity
@Table(name = "subjects")
public class Asignatura {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;


    public Asignatura() {

    }
    public Asignatura(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
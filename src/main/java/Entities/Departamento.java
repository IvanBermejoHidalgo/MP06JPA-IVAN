package Entities;

import jakarta.persistence.*;

//@Entity
//@Table(name = "departments")
@Entity
@Table(name = "departments")
public class Departamento {
    @Id
    @Column(name = "code")
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public Departamento() {
        // Constructor sin argumentos
        super();
    }

    public Departamento(int code, String name, String phone) {
        this.code = code;
        this.name = name;
        this.phone = phone;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
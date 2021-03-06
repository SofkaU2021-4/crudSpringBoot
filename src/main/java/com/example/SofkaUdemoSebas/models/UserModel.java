package com.example.SofkaUdemoSebas.models;


import javax.persistence.*;


@Entity
@Table(name="Usuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false )
    private long id;
    @Column( nullable = false )
    private String nombre ;
    @Column( nullable = false )
    private String email;
    @Column( nullable = false )
    private Integer prioridad ;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}

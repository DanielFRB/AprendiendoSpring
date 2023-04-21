package com.dfrb.springjwt.modelos;

import javax.persistence.*;

/**
 * @author dfrb@ne
 */

@Entity
@Table(name = "roles")
public class Roles {
    public Roles() {
    
    }

    public Roles(ERoles name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoles getName() {
        return name;
    }

    public void setName(ERoles name) {
        this.name = name;
    }
    
    // Campos de Clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoles name;
}

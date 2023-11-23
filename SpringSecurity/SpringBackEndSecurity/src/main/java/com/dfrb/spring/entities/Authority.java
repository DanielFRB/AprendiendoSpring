package com.dfrb.spring.entities;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author dfrb@ne
 */

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {
    public Authority() {
        
    }
    
    // Métodos sobresctitos de la Interface GrantedAuthority
    @Override
    public String getAuthority() {
        return roleCode;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
    // Campos de Clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "ROLE_CODE")
    private String roleCode;
	
    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
}

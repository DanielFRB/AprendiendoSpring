package com.dfrb.springjwt.services;

import com.dfrb.springjwt.domains.User;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author dfrb@ne
 */

public class UserDetailsImpl implements UserDetails {
    public UserDetailsImpl(Long id, String username, String email, 
            String password, Collection<? extends GrantedAuthority> authorities) {
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
	this.authorities = authorities;
    }
    
    public static UserDetailsImpl build(User user) {
	List<GrantedAuthority> authorities = user.getRoles().stream()
		.map(roles -> new SimpleGrantedAuthority(roles.getName().name()))
		.collect(Collectors.toList());

	return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(),
                user.getPassword(), authorities);
    }

    public Long getId() {
	return id;
    }

    public String getEmail() {
	return email;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    // Metodos equals y hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	UserDetailsImpl user = (UserDetailsImpl) o;
	return Objects.equals(id, user.id);
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", authorities=" + authorities + '}';
    }
    
    // Campos de Clase
    private Long id;
    private String username;
    private String email;
    
    @JsonIgnore
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities;
}

package com.dfrb.springjwt.repositories;

import com.dfrb.springjwt.domains.ERole;
import com.dfrb.springjwt.domains.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dfrb@ne
 */

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

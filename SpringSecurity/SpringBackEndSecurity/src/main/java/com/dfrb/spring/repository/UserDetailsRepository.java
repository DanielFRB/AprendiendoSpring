package com.dfrb.spring.repository;

import com.dfrb.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dfrb@ne
 */

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}

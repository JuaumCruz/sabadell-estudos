package com.invillia.sabadell.userquery.repository;

import com.invillia.sabadell.userquery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

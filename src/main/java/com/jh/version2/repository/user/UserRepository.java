package com.jh.version2.repository.user;

import com.jh.version2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}

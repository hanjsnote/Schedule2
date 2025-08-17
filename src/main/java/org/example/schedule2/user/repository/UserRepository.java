package org.example.schedule2.user.repository;

import org.example.schedule2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findUserByUserId(Long userId);
//
//    default User findUserByUserIdOrElseThrow(Long userId){
//
//        return findUserByUserId(userId).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
//        );
//    }
}

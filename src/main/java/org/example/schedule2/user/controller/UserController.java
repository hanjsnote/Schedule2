package org.example.schedule2.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.user.service.UserService;
import org.example.schedule2.user.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping("/user")
    public ResponseEntity<SaveUserResponse> saveUser(@RequestBody SaveUserRequest request){
        return ResponseEntity.ok(userService.saveSchedule(request));
    }

    //유저 조회
    @GetMapping("/user")
    public ResponseEntity<List<FindUserResponse>> findUser(@RequestParam(required = false) String userName){
        return ResponseEntity.ok(userService.findsUser(userName));
    }

    //유저 수정
    @PutMapping("/user/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest request){
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    //유저 삭제
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
    }
}

package org.example.schedule2.user.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule2.user.dto.*;
import org.example.schedule2.user.entity.User;
import org.example.schedule2.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public SaveUserResponse saveSchedule(SaveUserRequest request) {
        User user = new User(
                request.getUserName(),
                request.getUserPassword(),
                request.getUserEmail()
        );
        User savedUser = userRepository.save(user);

        return new SaveUserResponse(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getUserEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    //유저 조회
    @Transactional(readOnly = true)
    public List<FindUserResponse> findsUser(String userName) {
        List<User> users = userRepository.findAll();
        List<FindUserResponse> dtos = new ArrayList<>();

        if(userName == null){
            for(User user : users){
                dtos.add(new FindUserResponse(
                        user.getUserId(),
                        user.getUserName(),
                        user.getUserEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                ));
            }
            return dtos;
        }

        for(User user : users){
            if(userName.equals(user.getUserName())){
                dtos.add(new FindUserResponse(
                        user.getUserId(),
                        user.getUserName(),
                        user.getUserEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                ));
            }
        }
        return dtos;
    }

    //유저 수정
    public UpdateUserResponse updateUser(long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );

        if (request.getUserPassword() == null){
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }

        if (!user.getUserPassword().equals(request.getUserPassword())){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
        }

        user.updateUser(
                request.getUserName(),
                request.getUserEmail()
        );

        return new UpdateUserResponse(
                user.getUserName(),
                user.getUserEmail()
        );
    }

    //유저 삭제
    public void deleteUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        userRepository.deleteById(user.getUserId());
    }

}

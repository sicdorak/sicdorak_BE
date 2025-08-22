package com.sicdorak.web.auth;

import com.sicdorak.web.user.User;
import com.sicdorak.web.user.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;

    // 회원가입
    public void signup(SignupRequestDto dto) {
        // 이메일 중복 체크 -> 가입 여부 확인
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 비밀번호 암호화(시큐리티 추가 후)

        // dto에서 받은 값을 User entity로 변환
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        // DB 저장(createTime, id 처리)
        userRepository.save(user);
    }
}

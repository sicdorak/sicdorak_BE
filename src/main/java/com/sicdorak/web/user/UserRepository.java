package com.sicdorak.web.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // AuthService에서 email로 가입된 계정 유무 확인에 사용
    // Optional = null 체크를 더 안전하게 하기 위한 도구
    Optional<User> findByEmail(String email);
}

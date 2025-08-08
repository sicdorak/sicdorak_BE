package com.sicdorak.web.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private Integer kakaoId;

    @Column(columnDefinition = "TEXT")
    private String profileImage;

    @Column(nullable = false)
    private boolean allowNotify = false;
    private LocalDateTime createTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessLevel accessLevel = AccessLevel.USER;

    public enum AccessLevel {
        ADMIN,
        USER
    }
}

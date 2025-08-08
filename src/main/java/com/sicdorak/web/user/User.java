package com.sicdorak.web.user;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private String kakaoId;

    private String profileImage;
    @Column(nullable = false)
    private boolean allowNotify = false;
    private LocalDateTime createTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessLevel accessLevel = AccessLevel.USER;

    public static enum AccessLevel {
        ADMIN,
        USER
    }
}

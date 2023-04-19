package com.lew.eventtimeline.user.domain;

import com.lew.eventtimeline.common.security.Role;
import com.lew.eventtimeline.user.domain.port.db.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// Only for demo purposes
public class InsertAdminUserService {

    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @EventListener(ContextRefreshedEvent.class)
    public void insertAdminUser() {
        createUser("admin", "admin1234");
        createUser("user", "user1234");
    }

    private void createUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.ROLE_ADMIN.name())
                .authorities(Role.ROLE_ADMIN.getAuthorities())
                .isActive(true)
                .isNotLocked(true)
                .build();

        userRepository.save(user);
    }
}

package com.lew.eventtimeline.user.domain;

import com.lew.eventtimeline.user.domain.port.api.ChangePasswordUseCase;
import com.lew.eventtimeline.user.domain.port.api.UserRequest;
import com.lew.eventtimeline.user.domain.port.db.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class ChangePasswordService implements ChangePasswordUseCase {

    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void change(String username, UserRequest userRequest) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setPassword(encodePassword(userRequest.getPassword()));

        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}

package com.lew.eventtimeline.user.domain;

import com.lew.eventtimeline.common.security.JwtTokenProvider;
import com.lew.eventtimeline.common.security.SecurityConstant;
import com.lew.eventtimeline.user.domain.mapper.UserMapper;
import com.lew.eventtimeline.user.domain.port.api.LoginUseCase;
import com.lew.eventtimeline.user.domain.port.api.UserResponse;
import com.lew.eventtimeline.user.domain.port.api.UserRequest;
import com.lew.eventtimeline.user.domain.port.db.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class LoginService implements LoginUseCase {

    UserRepository userRepository;
    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<UserResponse> login(UserRequest userRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

        User user = userRepository.findByUsername(userRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        HttpHeaders jwtHttpHeader = createJwtHttpHeader(user);

        return new ResponseEntity<>(UserMapper.INSTANCE.userToUserDto(user), jwtHttpHeader, OK);
    }

    private HttpHeaders createJwtHttpHeader(User user) {
        UserPrincipal userPrincipal = new UserPrincipal(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add(SecurityConstant.JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(userPrincipal));

        return headers;
    }
}

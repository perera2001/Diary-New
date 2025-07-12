
package diary.diarynew.service.impl;

import diary.diarynew.dto.requestDTO.LoginRequestDTO;
import diary.diarynew.dto.requestDTO.SignupRequestDTO;
import diary.diarynew.dto.responseDTO.AuthResponseDTO;
import diary.diarynew.entity.User;
import diary.diarynew.repo.UserRepo;
import diary.diarynew.service.UserService;
import diary.diarynew.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO signup(SignupRequestDTO signupRequestDTO) {
        // Check if user already exists
        if (userRepo.findByUsername(signupRequestDTO.getUsername()).isPresent()) {
            AuthResponseDTO response = new AuthResponseDTO();
            response.setToken(null);
            response.setMessage("Username already exists");
            return response;
        }

        // Create new user
        User user = new User();
        user.setUsername(signupRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
        user.setEmail(signupRequestDTO.getEmail());
        user.setFirstName(signupRequestDTO.getFirstName());  // ✅ Added
        user.setLastName(signupRequestDTO.getLastName());    // ✅ Added


        userRepo.save(user);

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getUsername());

        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(token);
        response.setMessage("Signup successful");

        return response;
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDTO.getUsername(),
                            loginRequestDTO.getPassword()
                    )
            );
        } catch (Exception e) {
            AuthResponseDTO response = new AuthResponseDTO();
            response.setToken(null);
            response.setMessage("Invalid credentials");
            return response;
        }

        String token = jwtUtil.generateToken(loginRequestDTO.getUsername());

        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(token);
        response.setMessage("Login successful");

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

package diary.diarynew.controller;

import diary.diarynew.dto.requestDTO.LoginRequestDTO;
import diary.diarynew.dto.requestDTO.SignupRequestDTO;
import diary.diarynew.dto.responseDTO.AuthResponseDTO;
import diary.diarynew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin // Allows cross-origin requests; customize if needed
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO) {
        AuthResponseDTO response = userService.signup(signupRequestDTO);

        if (response.getToken() != null && !response.getToken().isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        AuthResponseDTO response = userService.login(loginRequestDTO);

        if (response.getToken() != null && !response.getToken().isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}

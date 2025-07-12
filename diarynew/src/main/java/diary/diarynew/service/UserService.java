package diary.diarynew.service;

import diary.diarynew.dto.requestDTO.LoginRequestDTO;
import diary.diarynew.dto.requestDTO.SignupRequestDTO;
import diary.diarynew.dto.responseDTO.AuthResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AuthResponseDTO signup(SignupRequestDTO signupRequestDTO);
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);

}

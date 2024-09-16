package br.com.fiap.solutech.controller;


import br.com.fiap.solutech.domain.Login;
import br.com.fiap.solutech.dto.auth.DataLoginDto;
import br.com.fiap.solutech.dto.auth.TokenJwtDto;
import br.com.fiap.solutech.dto.login.RegisterUserDto;
import br.com.fiap.solutech.dto.login.UserDetailsDto;
import br.com.fiap.solutech.repository.LoginRepository;
import br.com.fiap.solutech.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity<TokenJwtDto> post(@RequestBody @Valid DataLoginDto dto){
        var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authenticate = authenticationManager.authenticate(authToken);
        var token = tokenService.gerarToken((Login) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(token));
    }

    @PostMapping("register")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<UserDetailsDto> post(@RequestBody @Valid RegisterUserDto dto,
                                               UriComponentsBuilder builder){
        var login = new Login(dto.username(), passwordEncoder.encode(dto.password()));
        loginRepository.save(login);
        var url = builder.path("usuario/{id}").buildAndExpand(login.getId()).toUri();
        return ResponseEntity.created(url).body(new UserDetailsDto(login));
    }


}

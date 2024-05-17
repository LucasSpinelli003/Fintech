package br.com.fiap.solutech.controller;

import br.com.fiap.solutech.dto.user.*;
import br.com.fiap.solutech.domain.User;
import br.com.fiap.solutech.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailDto> create(@RequestBody @Valid UserRegisterDto dto, UriComponentsBuilder uriBuilder){
        var user = new User(dto);
        userRepository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserListDto>> listAll(Pageable pageable) {
        var list = userRepository.findAll(pageable).stream().map(UserListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("by-name")
    public ResponseEntity<Page<UserDetailDto>> searchByUserName(@RequestParam("name")String name, Pageable pageable){
        var list = userRepository.searchByName(name, pageable).map(UserDetailDto::new);
        return ResponseEntity.ok(list);
    }

    @GetMapping("by-investment-name")
    public ResponseEntity<Page<UserDetailDto>> searchByInvestmentName(@RequestParam("name")String name, Pageable pageable){
        var list = userRepository.searchByInvestmentName(name, pageable).map(UserDetailDto::new);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserListDto> searchById(@PathVariable("id") Long id){
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserListDto(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <UserDetailDto> update(@PathVariable("id") Long id, @RequestBody  @Valid UserUpdateDto dto){
        var user = userRepository.getReferenceById(id);
        user.updateData(dto);
        return ResponseEntity.ok(new UserDetailDto(user));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

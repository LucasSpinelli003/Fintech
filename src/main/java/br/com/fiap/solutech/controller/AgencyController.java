package br.com.fiap.solutech.controller;

import br.com.fiap.solutech.dto.agency.AgencyDetailDto;
import br.com.fiap.solutech.dto.agency.AgencyListDto;
import br.com.fiap.solutech.dto.agency.AgencyRegisterDto;
import br.com.fiap.solutech.dto.agency.AgencyUpdateDto;
import br.com.fiap.solutech.domain.Agency;
import br.com.fiap.solutech.repository.AgencyRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    private AgencyRepository agencyRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AgencyDetailDto> create(@RequestBody @Valid AgencyRegisterDto dto, UriComponentsBuilder uriBuilder){
        var agency = new Agency(dto);
        agencyRepository.save(agency);
        var uri = uriBuilder.path("/agency/{id}").buildAndExpand(agency.getId()).toUri();

        return ResponseEntity.created(uri).body(new AgencyDetailDto(agency));
    }

    @GetMapping
    public ResponseEntity<List<AgencyListDto>> listAll(Pageable pageable) {
        var list = agencyRepository.findAll(pageable).stream().map(AgencyListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AgencyListDto> searchById(@PathVariable("id") Long id){
        var user = agencyRepository.getReferenceById(id);
        return ResponseEntity.ok(new AgencyListDto(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <AgencyDetailDto> update(@PathVariable("id") Long id, @RequestBody  @Valid AgencyUpdateDto dto){
        var user = agencyRepository.getReferenceById(id);
        user.updateData(dto);
        return ResponseEntity.ok(new AgencyDetailDto(user));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        agencyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

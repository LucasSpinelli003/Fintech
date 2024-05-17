package br.com.fiap.solutech.controller;

import br.com.fiap.solutech.dto.investment.InvestmentDetailDto;
import br.com.fiap.solutech.dto.investment.InvestmentListDto;
import br.com.fiap.solutech.dto.investment.InvestmentRegisterDto;
import br.com.fiap.solutech.dto.investment.InvestmentUpdateDto;
import br.com.fiap.solutech.domain.Agency;
import br.com.fiap.solutech.domain.Investment;
import br.com.fiap.solutech.domain.User;
import br.com.fiap.solutech.repository.AgencyRepository;
import br.com.fiap.solutech.repository.InvestmentRepository;
import br.com.fiap.solutech.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investment")
public class InvestmentController {
    @Autowired
    private InvestmentRepository investmentRepository;
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/agency/{id_agency}")
    @Transactional
    public ResponseEntity<InvestmentDetailDto> create(@PathVariable("id_agency") Long idAgency, @RequestBody @Valid InvestmentRegisterDto dto, UriComponentsBuilder uriBuilder){
        var agency = agencyRepository.getReferenceById(idAgency);
        List<User> users = new ArrayList<>();

        for (Long userId : dto.usersId()) {
            var user = userRepository.getReferenceById(userId);
            users.add(user);
        }
        var investment = new Investment(dto, agency, users);
        investmentRepository.save(investment);
        var uri = uriBuilder.path("/investment/{id}").buildAndExpand(investment.getId()).toUri();
        return ResponseEntity.created(uri).body(new InvestmentDetailDto(investment));
    }

    @GetMapping
    public ResponseEntity<List<InvestmentListDto>> listAll(Pageable pageable) {
        var list = investmentRepository.findAll(pageable).stream().map(InvestmentListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<InvestmentListDto> searchById(@PathVariable("id") Long id){
        var investment = investmentRepository.getReferenceById(id);
        return ResponseEntity.ok(new InvestmentListDto(investment));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <InvestmentDetailDto> update(@PathVariable("id") Long id, @RequestBody  @Valid InvestmentUpdateDto dto){
        var investment = investmentRepository.getReferenceById(id);
        Agency agency = null;
        if(dto.agencyId() != null){
             agency = agencyRepository.getReferenceById(dto.agencyId());
        }
        List<User> users = new ArrayList<>();
        if(dto.usersId() != null){
            for (Long userId : dto.usersId()) {
                var user = userRepository.getReferenceById(userId);
                users.add(user);
            }
        }

        investment.updateData(dto, agency, users);
        return ResponseEntity.ok(new InvestmentDetailDto(investment));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        investmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

package br.com.fiap.solutech.controller;

import br.com.fiap.solutech.dto.investment.InvestmentDetailDto;
import br.com.fiap.solutech.dto.investment.InvestmentListDto;
import br.com.fiap.solutech.dto.investment.InvestmentRegisterDto;
import br.com.fiap.solutech.dto.investment.InvestmentUpdateDto;
import br.com.fiap.solutech.model.Investment;
import br.com.fiap.solutech.repository.InvestmentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/investment")
public class InvestmentController {
    @Autowired
    private InvestmentRepository investmentRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<InvestmentDetailDto> create(@RequestBody @Valid InvestmentRegisterDto dto, UriComponentsBuilder uriBuilder){
        var investment = new Investment(dto);
        investmentRepository.save(investment);
        var uri = uriBuilder.path("/investment/{id}").buildAndExpand(investment.getId()).toUri();

        return ResponseEntity.created(uri).body(new InvestmentDetailDto(investment));
    }

    @GetMapping
    public ResponseEntity<List<InvestmentListDto>> listPaginated(Pageable pageable) {
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
        investment.updateData(dto);
        return ResponseEntity.ok(new InvestmentDetailDto(investment));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        investmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

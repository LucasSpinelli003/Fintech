package br.com.fiap.solutech.controller;

import br.com.fiap.solutech.dto.investorInfo.InvestorInfoDetailDto;
import br.com.fiap.solutech.dto.investorInfo.InvestorInfoListDto;
import br.com.fiap.solutech.dto.investorInfo.InvestorInfoRegisterDto;
import br.com.fiap.solutech.dto.investorInfo.InvestorInfoUpdateDto;
import br.com.fiap.solutech.model.InvestorInfo;
import br.com.fiap.solutech.repository.InvestorInfoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/investor/info")
public class InvestorInfoController {
    @Autowired
    private InvestorInfoRepository investorInfoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<InvestorInfoDetailDto> create(@RequestBody @Valid InvestorInfoRegisterDto dto, UriComponentsBuilder uriBuilder){
        var investorInfo = new InvestorInfo(dto);
        investorInfoRepository.save(investorInfo);
        var uri = uriBuilder.path("/investor/info/{id}").buildAndExpand(investorInfo.getId()).toUri();

        return ResponseEntity.created(uri).body(new InvestorInfoDetailDto(investorInfo));
    }

    @GetMapping
    public ResponseEntity<List<InvestorInfoListDto>> listPaginated(Pageable pageable) {
        var list = investorInfoRepository.findAll(pageable).stream().map(InvestorInfoListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<InvestorInfoListDto> searchById(@PathVariable("id") Long id){
        var user = investorInfoRepository.getReferenceById(id);
        return ResponseEntity.ok(new InvestorInfoListDto(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <InvestorInfoDetailDto> update(@PathVariable("id") Long id, @RequestBody InvestorInfoUpdateDto dto){
        var investorInfo = investorInfoRepository.getReferenceById(id);
        investorInfo.updateData(dto);
        return ResponseEntity.ok(new InvestorInfoDetailDto(investorInfo));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        investorInfoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

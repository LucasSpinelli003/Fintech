package br.com.fiap.solutech.dto.investment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record InvestmentRegisterDto(

   @NotBlank(message = "Name field cannot be empty!")
   @Size(max = 100, min = 3, message = "The minimum name size is 3 and the maximum is 100!")
   String name,
   @NotBlank(message = "Mail field cannot be empty!")
   @Size(max = 150, min = 6, message = "The minimum type size is 15 and the maximum is 150!")
   String type,
   @NotNull(message = "Value field cannot be empty!")
   Double value,
   @NotNull(message = "User id cannot be empty!")
   List<Long> usersId

) {}

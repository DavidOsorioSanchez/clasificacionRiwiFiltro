package com.riwi.clasificacion_filtro.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubweyReq {
  @NotBlank(message = "The title cant be blanck")
  private String title;
  private String description;
  @FutureOrPresent(message = "La fecha no puede ser del pasado")
  private LocalDate creationDate;

  private Long userId;
}

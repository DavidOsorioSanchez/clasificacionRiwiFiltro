package com.riwi.clasificacion_filtro.api.dto.request;

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
  private String creationDate;

  private Long userId;
}

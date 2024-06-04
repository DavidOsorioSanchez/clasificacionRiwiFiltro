package com.riwi.clasificacion_filtro.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubweyResp {
  private Long id;
  private String title;
  private String description;
  private String creationDate;
  
  private UserResp user;
}

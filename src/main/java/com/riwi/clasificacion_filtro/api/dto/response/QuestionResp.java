package com.riwi.clasificacion_filtro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResp {
  private Long id;
  private String text;
  private String type;

  private SubweyResp subwey;
}

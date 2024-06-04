package com.riwi.clasificacion_filtro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionReq {
  private String text;
  private String type;

  private Long subweyId;
}

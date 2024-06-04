package com.riwi.clasificacion_filtro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionQuestionReq {
  private String text;

  private Long questionId;
}

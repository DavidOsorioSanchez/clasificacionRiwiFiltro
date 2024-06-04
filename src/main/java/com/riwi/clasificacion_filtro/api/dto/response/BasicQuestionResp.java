package com.riwi.clasificacion_filtro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicQuestionResp {
  private Long id;
  private String text;
  private String type;
  private boolean active;

}

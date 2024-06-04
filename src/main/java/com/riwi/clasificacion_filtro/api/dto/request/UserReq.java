package com.riwi.clasificacion_filtro.api.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
  @Size(max = 100, message = "El nombre no puede ser mayor a cien caracteres")
  private String name;
  @Size(max = 100, message = "El nombre no puede ser email a cien caracteres")
  private String email;
  private String password;
  private boolean active;
}

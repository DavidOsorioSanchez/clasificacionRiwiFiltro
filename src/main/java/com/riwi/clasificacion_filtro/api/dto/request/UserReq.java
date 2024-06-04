package com.riwi.clasificacion_filtro.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  @Size(min = 0, max = 100, message = "El nombre no puede ser mayor a cien caracteres")
  @NotBlank(message = "The name cant be null")
  private String name;
  @NotBlank(message = "The email cant be null")
  @Size(min = 0, max = 100, message = "El nombre no puede ser email a cien caracteres")
  @Email(message = "El email es invalido")
  private String email;
  @NotBlank(message = "The password cant be null")
  private String password;
  private boolean active;
}

package com.riwi.clasificacion_filtro.util.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {

  private final String mensaje = "Coder";

  public static String idNotFound(String entity) {
    final String message = "No se a encontrado en entidad %s con el id suministrado";
    return String.format(message, entity);
  }
}

package com.riwi.clasificacion_filtro.infrastructure.CrudAbstract;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
  public Page<RS> getAll(int page, int size);

  public RS create(RQ request);
}

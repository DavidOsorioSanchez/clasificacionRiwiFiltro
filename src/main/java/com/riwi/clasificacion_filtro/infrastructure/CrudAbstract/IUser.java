package com.riwi.clasificacion_filtro.infrastructure.CrudAbstract;

import com.riwi.clasificacion_filtro.api.dto.request.UserReq;
import com.riwi.clasificacion_filtro.api.dto.response.UserResp;

public interface IUser extends CrudService<UserReq, UserResp, Long>{
  
  public UserResp get(Long id);

  public UserResp update(UserReq request, Long id);
}

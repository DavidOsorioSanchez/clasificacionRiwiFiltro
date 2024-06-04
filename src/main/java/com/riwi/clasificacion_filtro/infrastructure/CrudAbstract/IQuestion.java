package com.riwi.clasificacion_filtro.infrastructure.CrudAbstract;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;

public interface IQuestion extends CrudService<QuestionReq, QuestionResp, Long>{
  
  public QuestionReq update(QuestionResp request, Long id);

  public void delete(Long id);

  public void patch(Long id);  
}

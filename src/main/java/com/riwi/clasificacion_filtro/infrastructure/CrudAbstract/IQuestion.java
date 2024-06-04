package com.riwi.clasificacion_filtro.infrastructure.CrudAbstract;

import org.springframework.data.domain.Page;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.BasicQuestionResp;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;

public interface IQuestion {

  public QuestionResp create(QuestionReq request);

  public Page<BasicQuestionResp> getAll(int page, int size);

  public QuestionReq update(QuestionResp request, Long id);

  public void delete(Long id);

  public void patch(Long id);  
}

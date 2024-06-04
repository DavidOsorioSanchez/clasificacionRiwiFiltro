package com.riwi.clasificacion_filtro.infrastructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;
import com.riwi.clasificacion_filtro.api.dto.response.SubweyResp;
import com.riwi.clasificacion_filtro.domain.entities.Question;
import com.riwi.clasificacion_filtro.domain.repository.QuestionRepository;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IQuestion;
import com.riwi.clasificacion_filtro.util.exception.BadRequestException;
import com.riwi.clasificacion_filtro.util.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class QuestionService implements IQuestion {

  @Autowired
  private final QuestionRepository questionRepository;

  @Override
  public Page<QuestionResp> getAll(int page, int size) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public QuestionResp create(QuestionReq request) {
    Question question = this.requestToEntity(request);
    return this.entityToResp(this.questionRepository.save(question));
  }

  @Override
  public QuestionReq update(QuestionResp request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void patch(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'patch'");
  }

  private Question find(Long id) {
    return this.questionRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Question")));
  }

  private QuestionResp entityToResp(Question entity) {

    SubweyResp subwey = new SubweyResp();
    BeanUtils.copyProperties(entity.getSubwey(), subwey);

    return QuestionResp.builder()
        .id(entity.getId())
        .text(entity.getText())
        .type(entity.getType())
        .subwey(subwey)
        .active(entity.isActive())
        .build();
  }

  private Question requestToEntity(QuestionReq request) {

    return Question.builder()
        .text(request.getText())
        .type(request.getType())
        .active(request.isActive())
        .build();
  }
}

package com.riwi.clasificacion_filtro.infrastructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.BasicQuestionResp;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;
import com.riwi.clasificacion_filtro.api.dto.response.SubweyResp;
import com.riwi.clasificacion_filtro.domain.entities.Question;
import com.riwi.clasificacion_filtro.domain.entities.Subwey;
import com.riwi.clasificacion_filtro.domain.repository.QuestionRepository;
import com.riwi.clasificacion_filtro.domain.repository.SubweyRepository;
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

  @Autowired
  private final SubweyRepository subweyRepository;

  @Override
  public Page<BasicQuestionResp> getAll(int page, int size) {
    if (page < 0)
      page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    return this.questionRepository.findAll(pagination)
        .map(this::entityToRespBasic);
  }

  @Override
  public QuestionResp create(QuestionReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public QuestionResp update(QuestionReq request, Long id) {
    Question question = this.find(id);
    question.setId(id);

    return this.entityToResp(this.questionRepository.save(question));

  }

  @Override
  public void delete(Long id) {
    this.questionRepository.delete(this.find(id));
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

  private BasicQuestionResp entityToRespBasic(Question entity) {

    return BasicQuestionResp.builder()
        .id(entity.getId())
        .text(entity.getText())
        .type(entity.getType())
        .active(entity.isActive())
        .build();
  }

  private QuestionResp entityToResp(Question entity) {

    SubweyResp subwey = new SubweyResp();
    BeanUtils.copyProperties(entity.getSubwey(), subwey);

    return QuestionResp.builder()
        .id(entity.getId())
        .text(entity.getText())
        .type(entity.getType())
        .active(entity.isActive())
        .subwey(subwey)
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

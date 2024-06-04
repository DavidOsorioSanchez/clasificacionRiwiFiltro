package com.riwi.clasificacion_filtro.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;
import com.riwi.clasificacion_filtro.infrastructure.service.QuestionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RequestMapping(path = "/Question")
@RestController
@AllArgsConstructor
public class QuestionController {

  private final QuestionService questionService;

  @PostMapping
  public ResponseEntity<QuestionResp> insert(
      @Validated @RequestBody QuestionReq request) {
    return ResponseEntity.ok(this.questionService.create(request));
  }
}

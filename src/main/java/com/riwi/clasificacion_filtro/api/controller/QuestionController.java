package com.riwi.clasificacion_filtro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clasificacion_filtro.api.dto.response.BasicQuestionResp;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IQuestion;

import lombok.AllArgsConstructor;

@RequestMapping(path = "/Question")
@RestController
@AllArgsConstructor
public class QuestionController {
  
  @Autowired
  private final IQuestion questionService;

  @GetMapping
  public ResponseEntity<Page<BasicQuestionResp>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(this.questionService.getAll(page, size));
  }
}

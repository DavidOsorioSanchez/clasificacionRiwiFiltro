package com.riwi.clasificacion_filtro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clasificacion_filtro.api.dto.request.QuestionReq;
import com.riwi.clasificacion_filtro.api.dto.response.BasicQuestionResp;
import com.riwi.clasificacion_filtro.api.dto.response.QuestionResp;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IQuestion;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RequestMapping(path = "/Question")
@RestController
@AllArgsConstructor
public class QuestionController {
  
  @Autowired
  private final IQuestion questionService;

  @GetMapping
  public ResponseEntity<Page<BasicQuestionResp>> getAll(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(this.questionService.getAll(page, size));
  }
  
  @PutMapping(path = "/{id}")
    public ResponseEntity<QuestionResp> update(
            @Validated @RequestBody QuestionReq request,
        @PathVariable Long id) {
      return ResponseEntity.ok(this.questionService.update(request, id));
    }
    
  @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.questionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

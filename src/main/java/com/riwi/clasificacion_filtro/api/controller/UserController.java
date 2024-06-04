package com.riwi.clasificacion_filtro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clasificacion_filtro.api.dto.request.UserReq;
import com.riwi.clasificacion_filtro.api.dto.response.UserResp;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IUser;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RequestMapping(path = "/User")
@RestController
@AllArgsConstructor
public class UserController {
  private final IUser userService;

  @GetMapping
  public ResponseEntity<Page<UserResp>> getAll(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(this.userService.getAll(page, size));
  }

  @PostMapping
  public ResponseEntity<UserResp> insert(@Validated @RequestBody UserReq request) {
    return ResponseEntity.ok(this.userService.create(request));
  }
}

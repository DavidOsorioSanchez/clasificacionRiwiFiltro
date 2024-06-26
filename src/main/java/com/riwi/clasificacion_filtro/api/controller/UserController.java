package com.riwi.clasificacion_filtro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clasificacion_filtro.api.dto.response.UserResp;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IUser;

import lombok.AllArgsConstructor;

@RequestMapping(path = "/User")
@RestController
@AllArgsConstructor
public class UserController {
  @Autowired
  private final IUser userService;

  @GetMapping
  public ResponseEntity<Page<UserResp>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(this.userService.getAll(page, size));
  }
}

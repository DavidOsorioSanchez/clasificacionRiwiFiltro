package com.riwi.clasificacion_filtro.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.clasificacion_filtro.api.dto.request.UserReq;
import com.riwi.clasificacion_filtro.api.dto.response.UserResp;
import com.riwi.clasificacion_filtro.domain.entities.User;
import com.riwi.clasificacion_filtro.domain.repository.UserRepositoty;
import com.riwi.clasificacion_filtro.infrastructure.CrudAbstract.IUser;
import com.riwi.clasificacion_filtro.util.exception.BadRequestException;
import com.riwi.clasificacion_filtro.util.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUser{

  @Autowired
  private final UserRepositoty userRepositoty; 

  @Override
  public Page<UserResp> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.userRepositoty.findAll(pagination)
          .map(this::entityToResp);
  }

  @Override
  public UserResp create(UserReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public UserResp get(Long id) {
    return this.entityToResp(find(id));
  }

  @Override
  public UserResp update(UserReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }
  
  private User find(Long id){
    return this.userRepositoty.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("User")));
  }
  
  private UserResp entityToResp(User entity) {

    return UserResp.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .active(entity.isActive())
        .build();
  }

  private User requestToEntity(UserReq request) {

    return User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .password(request.getPassword())
        .active(request.isActive())
        .build();
  }
}

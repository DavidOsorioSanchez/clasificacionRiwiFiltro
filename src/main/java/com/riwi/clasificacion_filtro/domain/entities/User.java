package com.riwi.clasificacion_filtro.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 100)
  private String name;
  @Column(length = 100)
  private String email;
  private String password;
  private boolean active;

  // @ToString.Exclude
  // @EqualsAndHashCode.Exclude
  // @OneToMany(
  //       mappedBy = "employee",
  //       fetch = FetchType.EAGER,
  //       cascade = CascadeType.ALL,
  //       orphanRemoval = false
  // )
  // private List<Appointment> appointments;
}

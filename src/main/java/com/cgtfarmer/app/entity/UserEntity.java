package com.cgtfarmer.app.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {

  private Long id;

  private String firstName;

  private String lastName;

  private Integer age;

  private Float weight;
}

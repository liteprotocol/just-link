package com.tron.web.entity;

import lombok.Data;

@Data
public class TaskSpecRequest {
  private Long confirmations;
  private String type;
  private String params;
}

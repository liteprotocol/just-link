package com.tron.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class Initiator implements Serializable {
  private Long id;
  private String jobSpecID;
  private String type;
  private String InitiatorParams;
  private String schedule;
  private Date time;
  private byte[] address;
  private String requesters;
  private String name;
  private String params;
  private int fromBlock;
  private int toBlock;
  private String topics;
  private String requestData;
  private String feeds;
  private float threshold;
  private int precision;
  private int polling_interval;
  private float absoluteThreshold;
  private Long pollTimer;
  private Long idleTimer;
  private Date createdAt;
  private Date updateAt;
  private Date deletedAt;

}

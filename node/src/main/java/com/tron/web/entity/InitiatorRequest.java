package com.tron.web.entity;

import java.util.Date;
import lombok.Data;

@Data
public class InitiatorRequest {
  private String type;
  private Params params;

  @Data
  private class Params {
    private String schedule;
    private Date time;
    private byte[] address;
    private String requesters;
    private String name;
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
  }
}

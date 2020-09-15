package com.tron.web.service;

import com.tron.web.entity.JobSpec;
import com.tron.web.entity.JobSpecRequest;

public interface JobSpecsService {

  public int insert(JobSpecRequest jsr);

  public JobSpec getById(String id);
}

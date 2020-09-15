package com.tron.web.service.impl;

import com.tron.web.common.util.JsonUtil;
import com.tron.web.entity.Initiator;
import com.tron.web.entity.InitiatorRequest;
import com.tron.web.entity.JobSpec;
import com.tron.web.entity.JobSpecRequest;
import com.tron.web.entity.TaskSpec;
import com.tron.web.entity.TaskSpecRequest;
import com.tron.web.mapper.InitiatorMapper;
import com.tron.web.mapper.JobSpecsMapper;
import com.tron.web.mapper.TaskSpecsMapper;
import com.tron.web.service.JobSpecsService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@AllArgsConstructor
public class JobSpecsServiceImpl implements JobSpecsService {
  private JobSpecsMapper jobSpecsMapper;
  private InitiatorMapper initiatorMapper;
  private TaskSpecsMapper taskSpecsMapper;

  public int insert(JobSpecRequest jsr) {

    JobSpec jobSpec = newJobFromRequest(jsr);
    int result = jobSpecsMapper.insert(jobSpec);

    initiatorMapper.insertList(jobSpec.getInitiators());

    taskSpecsMapper.insertList(jobSpec.getTaskSpecs());

    return result;
  }

  public JobSpec getById(String id) {
    return jobSpecsMapper.getById(id);
  }

  private JobSpec newJobFromRequest(JobSpecRequest jsr) {
    String jobId = UUID.randomUUID().toString();
    jobId = jobId.replaceAll("-", "");
    JobSpec jobSpec = new JobSpec();
    jobSpec.setId(jobId);
    jobSpec.setEndAt(jsr.getEndAt());
    jobSpec.setStartAt(jsr.getStartAt());
    jobSpec.setMinPayment(jsr.getMinPayment());

    for (InitiatorRequest ir : jsr.getInitiators()) {
      Initiator i = new Initiator();
      i.setJobSpecID(jobId);
      i.setType(ir.getType());
      i.setParams(JsonUtil.obj2String(ir.getParams()));
      jobSpec.getInitiators().add(i);
    }

    for (TaskSpecRequest tr : jsr.getTaskSpecs()) {
      TaskSpec ts = new TaskSpec();
      ts.setJobSpecID(jobId);
      ts.setType(tr.getType());
      ts.setParams(JsonUtil.obj2String(tr.getParams()));
      jobSpec.getTaskSpecs().add(ts);
    }

    return jobSpec;
  }

}

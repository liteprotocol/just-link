package com.tron.web.controller;

import com.tron.web.common.ResultStatus;
import com.tron.web.common.util.R;
import com.tron.web.entity.JobSpec;
import com.tron.web.entity.JobSpecRequest;
import com.tron.web.service.JobSpecsService;
import com.tron.web.service.impl.JobSpecsServiceImpl;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobSpecsController {
  private JobSpecsService jobSpecsService;

  @PostMapping("/specs")
  public R create(@RequestBody JobSpecRequest jobSpecRequest, HttpSession session) {
    int result = jobSpecsService.insert(jobSpecRequest);
    if (result >= 0){
      return R.ok().put("data", "");
    } else {
      return R.error(ResultStatus.Failed);
    }

  }

  @RequestMapping(value = "/specs/{jobId}", method = RequestMethod.GET)
  public R getJobById(@PathVariable("jobId") String jobId) {
    try {
      JobSpec jobSpec = jobSpecsService.getById(jobId);

      return R.ok().put("data", jobSpec);
    } catch (Exception e) {
      return R.error(ResultStatus.Failed);
    }
  }

}

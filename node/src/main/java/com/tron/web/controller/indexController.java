package com.tron.web.controller;

import com.tron.web.common.ResultStatus;
import com.tron.web.common.util.R;
import com.tron.web.entity.Demo;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@AllArgsConstructor
public class indexController {

  @RequestMapping("/test")
  public R create() {
    UUID uid = UUID.randomUUID();
    return R.ok().put("data", uid.toString());
  }
}

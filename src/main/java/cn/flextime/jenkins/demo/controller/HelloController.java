package cn.flextime.jenkins.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangsen
 * @date 2020/1/21 15:21
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("/{name}")
  public String hello(@PathVariable("name") String name) {
    return String.format("hello %s .", name);
  }
}

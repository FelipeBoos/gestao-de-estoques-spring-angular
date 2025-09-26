package com.felipe.estoques.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class HealthController {
  @GetMapping("/health")
  public String health() { return "ok"; }
}
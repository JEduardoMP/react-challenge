package com.example.periodicTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.periodicTable.model.HighlightRequest;
import com.example.periodicTable.model.HighlightResult;
import com.example.periodicTable.service.HighlightService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class HighlightController {

  private final HighlightService highlightService;

  @Autowired
  public HighlightController(HighlightService highlightService) {
    this.highlightService = highlightService;
  }

  @GetMapping("/highlight-elements")
  public String sayHello() {
    return "Hello";
  }

  @PostMapping("/highlight-elements")
  public HighlightResult highlightElements(@RequestBody HighlightRequest request) {
    return highlightService.highlightElements(request.getFirstName(), request.getLastName());
  }
}

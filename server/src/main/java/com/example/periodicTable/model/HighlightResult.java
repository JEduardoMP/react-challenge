package com.example.periodicTable.model;

import java.util.List;

public class HighlightResult {
  private List<String> highlightedElements;

  public HighlightResult(List<String> highlightedElements) {
    this.highlightedElements = highlightedElements;
  }

  public List<String> getHighlightedElements() {
    return highlightedElements;
  }

  public void setHighlightedElements(List<String> highlightedElements) {
    this.highlightedElements = highlightedElements;
  }
}

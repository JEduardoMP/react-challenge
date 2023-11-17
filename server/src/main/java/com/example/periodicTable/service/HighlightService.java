package com.example.periodicTable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.periodicTable.model.HighlightResult;

@Service
public class HighlightService {

  private final PeriodicTableApiService periodicTableApiService;

  @Autowired
  public HighlightService(PeriodicTableApiService periodicTableApiService) {
    this.periodicTableApiService = periodicTableApiService;
  }

  public HighlightResult highlightElements(String firstName, String lastName) {
    Map<String, String> periodicTableElements = periodicTableApiService.getElementsFromPeriodicTable();

    String firstTwoLettersFirstname = (firstName != null && firstName.length() >= 2) ? firstName.substring(0, 2)
        : firstName;
    String firstTwoLettersLastname = (lastName != null && lastName.length() >= 2) ? lastName.substring(0, 2) : lastName;

    boolean matchFirst = periodicTableElements.keySet().stream()
        .anyMatch(element -> element != null && element.equalsIgnoreCase(firstTwoLettersFirstname));

    boolean matchLast = periodicTableElements.keySet().stream()
        .anyMatch(element -> element != null && element.equalsIgnoreCase(firstTwoLettersLastname));

    if (matchFirst && matchLast) {
      return new HighlightResult(List.of(firstTwoLettersFirstname, firstTwoLettersLastname));

    } else {
      String firstLetter = (firstName != null && firstName.length() >= 1) ? firstName.substring(0, 1) : firstName;
      String lastLetter = (lastName != null && lastName.length() >= 1) ? lastName.substring(0, 1) : lastName;

      boolean matchFirst1 = periodicTableElements.keySet().stream()
          .anyMatch(element -> element != null && element.equalsIgnoreCase(firstLetter));

      boolean matchLast1 = periodicTableElements.keySet().stream()
          .anyMatch(element -> element != null && element.equalsIgnoreCase(lastLetter));

      if (matchFirst1 && matchLast1) {
        return new HighlightResult(List.of(firstLetter, lastLetter));
      } else {
        return new HighlightResult(new ArrayList<>());
      }

    }
  }

}

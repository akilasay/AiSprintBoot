package com.ak.springaidemo.dto;

public record movieDetails(
    String category,
    String movie,
    String year,
    String review,
    String director,
    String summary
){};

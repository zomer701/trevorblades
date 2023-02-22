package com.example.takehome.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "continent")
record ContinentsDto(List<ContinentDto> continents) {}

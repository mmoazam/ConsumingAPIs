package org.northcoders.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.northcoders.model.Books;

import java.util.List;


public record Results(
        @JsonProperty("status") String status,
        @JsonProperty("code") int code,
        @JsonProperty("total") int total,
        @JsonProperty("data") List<Books> books
) {}

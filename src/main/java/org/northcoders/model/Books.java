package org.northcoders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.northcoders.dao.FakeBooksDAO;
import org.northcoders.dao.Results;

import java.util.List;

public record Books(
        @JsonProperty("id") int id,
        @JsonProperty("title") String title,
        @JsonProperty("author") String author,
        @JsonProperty("genre") String genre,
        @JsonProperty("description") String description,
        @JsonProperty("isbn") String isbn,
        @JsonProperty("image") String image,
        @JsonProperty("published") String published,
        @JsonProperty("publisher") String publisher

) { }


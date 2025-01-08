package com.example.brew1.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class RequestDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = 1;

    @JsonProperty("bodyContent")
    private String bodyContent;

    @JsonProperty("data")
    private List<DataDTO> data;

    @JsonProperty("extraContent")
    private String extraContent;
}

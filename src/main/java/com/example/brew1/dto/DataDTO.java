package com.example.brew1.dto;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String name;
    
    public DataDTO(int id, String name) {
            this.id= id;
            this.name = name;
        }
    
    @Override
    public String toString() {
        return "id: "+ id + ", name: " + name;
    }
}

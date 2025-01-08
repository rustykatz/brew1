package com.example.brew1;

import com.example.brew1.dto.DataDTO;
import com.example.brew1.dto.ResponseDTO;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

// RestController returns pure text, RestController combines @Controller and @ResponseBody
@RestController
public class Controller {

    @GetMapping(
        value={"/"}
    )
    public String index() {
        return "Hello World! This is my first springboot application";
    }

    @PostMapping(
        value={"/receive"}
    )
    public String receive(
        @RequestBody ResponseDTO responseDTO,
        @RequestParam(value="cust_param", required=false) String custParam
    ) {

        // Log or process the received data 
        System.out.println("Received: " + responseDTO);
        System.out.println("data: " + responseDTO.getData());
        System.out.println("Size: " + responseDTO.getData().size());
        System.out.println("Cust Param: " + custParam);

        for (DataDTO d : responseDTO.getData()) {
            System.out.println("d: "+ d);
        }

        DataDTO data = new DataDTO(123, "some name");

        return data.toString();
    }

    @PostMapping(
        value={"/mono"}
    )
    public Mono<ResponseEntity<ResponseDTO>> mono(
        @RequestBody ResponseDTO responseDTO) {


        // Mono.just -> Emits a precomputed value immediately. Value must be ready when mono is created
        DataDTO resp_data = new DataDTO(3, null);

        ResponseDTO resp = new ResponseDTO(null, List.of(resp_data));
        System.out.println("Resp Obj:" + resp);
        if (resp.getBodyContent() == null){
            System.out.println("bodyContent - NULL");
        }else{
            System.out.println("bodyContent - NOT NULL");
        }

        return Mono.just(
            ResponseEntity.ok(resp)
        );


        // Mono.fromRunnable -> runs a runnable but does not emit any values. Completes after executing runnable
        // use for async code, i.e. running a task or logging 
        // Doesnt emit a value 
        // return Mono.fromRunnable(null);
    }
}
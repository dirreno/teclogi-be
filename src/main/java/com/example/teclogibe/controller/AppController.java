package com.example.teclogibe.controller;

import com.example.teclogibe.model.TrackingModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping("/getHola")
    public String getHola(){
        return "Hola Mundo";
    }

    @PostMapping("/tracking")
    public String postTracking(@RequestBody TrackingModel trackingModel){

        return trackingModel.toString();
    }

}

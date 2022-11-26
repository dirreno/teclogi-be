package com.example.teclogibe.controller;

import com.example.teclogibe.model.TrackingModel;
import com.example.teclogibe.service.Service;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping("/getHola")
    public String getHola(){
        return "Hola Mundo";
    }

    @PostMapping("/tracking/")
    public String postTracking(@RequestBody TrackingModel trackingModel){
        float r0 = trackingModel.getSatellites()[0].getDistance();
        float r1 = trackingModel.getSatellites()[1].getDistance();
        float r2 = trackingModel.getSatellites()[2].getDistance();
        /*
        float r0 = (float) Math.sqrt((500*500) + (200*200));
        float r1 = (float) Math.sqrt((100*100) + (100*100));
        float r2 = (float) Math.sqrt((500*500) + (100*100));
        */
        float[] pos = Service.getLocation(r0,r1,r2);
        if (pos.length == 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se escontró el emisor"
            );
        }
        String response = "{"+
                (char)34 + "position" + (char)34 + ":{" +
                (char)34 + "x" + (char)34 +":" + pos[0] + "," +
                (char)34 + "y" + (char)34 +":" + pos[1] +
                "},"+
                (char)34 + "isInDanger" + (char)34 +":" + Service.isInDanger(trackingModel.getMessage()) +
                "}";
        return response;
    }

}

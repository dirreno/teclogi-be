package com.example.teclogibe.model;



import com.example.teclogibe.service.Satellite;

import java.util.Arrays;

public class TrackingModel {
    private String[] satellites;
    private String[] message;

    public String[] getSatellites() {
        return satellites;
    }

    public void setSatellites(String [] satellites) {
        this.satellites = satellites;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TrackingModel{" +
                "satellites=" + Arrays.toString(satellites) +
                ", message=" + Arrays.toString(message) +
                '}';
    }
}

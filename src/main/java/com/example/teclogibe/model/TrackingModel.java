package com.example.teclogibe.model;

import java.util.Arrays;

public class TrackingModel {
    private SatelliteModel[] satellites;
    private String[] message;

    public SatelliteModel[] getSatellites() {
        return satellites;
    }

    public void setSatellites(SatelliteModel[] satellites) {
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

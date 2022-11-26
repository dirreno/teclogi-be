package com.example.teclogibe.service;

public class Main {

    public static void main(String[] args) {
        float r0 = (float) Math.sqrt((500*500) + (200*200));
        float r1 = (float) Math.sqrt((100*100) + (100*100));
        float r2 = (float) Math.sqrt((500*500) + (100*100));
        /*float r0 = (float) 100.0;
        float r1 = (float) 115.5;
        float r2 = (float) 142.7;*/
        Service.getLocation(r0,r1,r2);


        String[] mssg = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        System.out.println(Service.isInDanger(mssg));

    }
}

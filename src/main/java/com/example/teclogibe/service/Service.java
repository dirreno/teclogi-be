package com.example.teclogibe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Service {
    public static float[] getLocation(float r0, float r1, float r2) {
        Satellite sputnik = new Satellite("Sputnik", -500, -200);
        Satellite explorer = new Satellite("Explorer", 100, -100);
        Satellite asterix = new Satellite("Asterix", 500, 100);

        double x0 = sputnik.getX();
        double y0 = sputnik.getY();
        double x1 = explorer.getX();
        double y1 = explorer.getY();
        double x2 = asterix.getX();
        double y2 = asterix.getY();

        double a, dx, dy, d, h, rx, ry;
        double px, py;
        double e = 0.00001;

        /* Distancia de los catetos */
        dx = x1 - x0;
        dy = y1 - y0;

        /* Distancia euclidiana entre satélites */
        d = Math.sqrt((dy*dy) + (dx*dx));

        float[] err = new float[0];
        /* Verifica Interseccion de los círculos con radio, distanc donde esta el emisor */
        if (d > (r0 + r1)) {
            System.out.println(d);
            System.out.println((r0 + r1));
            System.out.println("error");
            return err;}
        if (d < Math.abs(r0 - r1)) {
            System.out.println("error 2");
            return err;}

        /* DDistancia respecto al punto 2. */
        a = ((r0*r0) - (r1*r1) + (d*d)) / (2.0 * d) ;

        /* Coordenadas respecto al punto 2 */
        px = x0 + (dx * a/d);
        py = y0 + (dy * a/d);
        h = Math.sqrt((r0*r0) - (a*a));
        rx = -dy * (h/d);
        ry = dx * (h/d);

        /* Determine las intersecciones */
        double int_x_sup = px + rx;
        double int_x_inf = px - rx;
        double int_y_sup = py + ry;
        double int_y_inf = py - ry;

        dx = int_x_sup - x2;
        dy = int_y_sup - y2;
        double d1 = Math.sqrt((dy*dy) + (dx*dx));

        dx = int_x_inf - x2;
        dy = int_y_inf - y2;
        double d2 = Math.sqrt((dy*dy) + (dx*dx));

        float[] ans = new float[2];

        if(Math.abs(d1 - r2) < e) {
            System.out.println("(x,y) = (" + int_x_sup + "," + int_y_sup + ")");
            ans[0] = (float) int_x_sup;
            ans[1] = (float) int_y_sup;

            return ans;
        }
        else if(Math.abs(d2 - r2) < e) {
            System.out.println("(x,y) = (" + int_x_inf + "," + int_y_inf + ")");
            ans[0] = (float) int_x_inf;
            ans[1] = (float) int_y_inf;

            return ans;
        }
        else {
            System.out.println("(x,y) = NONE");
            return err;
        }
    }

    public static Boolean isInDanger(String[] message) {
        ArrayList<ArrayList<String>> m = new  ArrayList<>();
        for (int i = 0; i < message.length; i++){
            ArrayList<String> list = new ArrayList<>(Arrays.asList(message[i].split("")));
            m.add(list);
            //System.out.println(list);
        }
        int c = 0;
        String e = m.get(0).get(0);
        int io = 0;
        int jo = 0;
        for (int i = 0; i < message[0].length(); i++){
            for (int j = 0; j < message.length; j++) {
                if ( j+4 < message.length){
                    if( i+4 < message[0].length() &&
                        Objects.equals(m.get(i).get(j), m.get(i + 1).get(j + 1)) &&
                        Objects.equals(m.get(i).get(j), m.get(i + 2).get(j + 2)) &&
                        Objects.equals(m.get(i).get(j), m.get(i + 3).get(j + 3)) ){
                            //System.out.println(i+","+j+" = "+m.get(i).get(j));
                            c = c + 1;
                    }
                     else if (    Objects.equals(m.get(i).get(j), m.get(i).get(j + 1)) &&
                            Objects.equals(m.get(i).get(j), m.get(i).get(j + 2)) &&
                            Objects.equals(m.get(i).get(j), m.get(i).get(j + 3)) ){
                        //System.out.println(i+","+j+" = "+m.get(i).get(j));
                        c = c + 1;
                    }
                } else if( i+4 < message[0].length() &&
                           Objects.equals(m.get(i).get(j), m.get(i + 1).get(j)) &&
                           Objects.equals(m.get(i).get(j), m.get(i + 2).get(j)) &&
                           Objects.equals(m.get(i).get(j), m.get(i + 3).get(j)) ){
                        //System.out.println(i+","+j+" = "+m.get(i).get(j));
                        c = c + 1;
                }
            }
        }
        //System.out.println(c);
        if (c > 1){
            return true;
        } else{
            return false;
        }
    }
}

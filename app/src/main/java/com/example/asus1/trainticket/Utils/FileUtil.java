package com.example.asus1.trainticket.Utils;

import android.app.Activity;
import android.widget.Toast;

import com.example.asus1.trainticket.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by asus1 on 2017/11/26.
 */

public class FileUtil {

    private static Map<String,String> StationCode = new HashMap<>();

    private static void ReadCodes(Activity activity){

            try {
                BufferedReader reader =
                        new BufferedReader
                                (new InputStreamReader

                                        (activity.getAssets().open("StationCode.json")));
                String s;
                while((s=reader.readLine())!=null){
                    if (!s.equals("{")&&!s.equals("}")){
                        String ss[]  = s.split(": ");
                        String city = ss[0];
                        String code = ss[1];
                        StationCode.put(city,code);
                    }
                }

            }catch (IOException e){
                Toast.makeText(activity,activity.getString(R.string.erro_property),Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }



    }

    public static String[] getCodes(Activity activity, String startCity, String endCity){
        if(StationCode.size()<=0){
            ReadCodes(activity);
        }

        String[] codes = new String[2];

        Set<String> citys = StationCode.keySet();
        Iterator<String> iterator = citys.iterator();
        String scity="";
        String ecity="";
        while (iterator.hasNext()){
            String t = iterator.next();
            if(t.equals(startCity)){
                scity = t;
            }

            if(t.equals(endCity)){
                ecity = t;
            }
        }

        codes[0] = scity;
        codes[1] = ecity;

        return codes;
    }

}

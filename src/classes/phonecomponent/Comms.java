/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes.phonecomponent;

import static lib.Tools.*;
import java.util.ArrayList;

/**
 *
 * @author JA
 */
public class Comms {
    
    public String WLAN;
    public String Bluetooth;
    public String GPS;
    public String NFC;
    public String Radio;
    public String USB;
    
    public Comms(String w,String b,String g,String n,String r,String u){
        WLAN = w;
        Bluetooth = b;
        GPS = g;
        NFC = n;
        Radio = r;
        USB = u;
    }
    
    /**
     * Return all information
     * 0 - WLAN
     * 1 - Bluetooth
     * 2 - GPS 
     * 3 - NFC
     * 4 - Radio
     * 5 - USB
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("WLAN",WLAN),
            combine("Bluetooth", Bluetooth),
            combine("GPS",GPS),
            combine("NFC",NFC),
            combine("Radio",Radio),
            combine("USB",USB)
        });
        return info;
    }
    
}

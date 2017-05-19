/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones.phonecomponent;

import static lib.Tools.*;
import java.util.ArrayList;

/**
 *
 * @author JA
 */
public class Battery {
    
    //Info
    public String battery;
    public String standby;
    public String talktime;
    public String musicplay;
    
    public Battery(String b,String s,String t,String m){
        battery = b;
        standby = s;
        talktime = t;
        musicplay = m;
    }
    
    /**
     * Returns info held
     * @return info
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Info",battery),
            combine("Stand-by",standby),
            combine("Talk time",talktime),
            combine("Music play",musicplay)
        });
        return info;
    }
    
}

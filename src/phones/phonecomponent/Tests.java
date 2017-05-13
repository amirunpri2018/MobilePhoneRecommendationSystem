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
public class Tests {
    
    public String performance;
    public String display;
    public String camera;
    public String loudspeaker;
    public String audio_quality;
    public String battery_life;
    
    public Tests(String p,String d,String c,String l,String a,String b){
        performance = p;
        display = d;
        camera = c;
        loudspeaker = l;
        audio_quality = a;
        battery_life = b;
    }
    
    /**
     * Return all information
     * 0 - Performance
     * 1 - Display
     * 2 - Camera
     * 3 - Loudspeaker
     * 4 - Audio Quality
     * 5 - Battery Life
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Performance",performance),
            combine("Display",display),
            combine("Camera",camera),
            combine("Loudspeaker",loudspeaker),
            combine("Audio Quality",audio_quality),
            combine("Battery Life",battery_life)
        });
        return info;
    }
    
}

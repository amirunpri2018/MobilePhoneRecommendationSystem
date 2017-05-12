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
public class Sound {
    
    private String alert_types;
    private String loudspeaker;
    private String headphone_jack;
    private String additional;
    
    public Sound(String a,String l,String h,String ad){
        alert_types = a;
        loudspeaker = l;
        headphone_jack = h;
        additional = ad;
    }
    
    /**
     * Return all information
     * 0 - Alert Types
     * 1 - Loudspeaker
     * 2 - 3.5mm Jack
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Alert Types",alert_types),
            combine("Loudspeaker",loudspeaker),
            combine("3.5mm Jack", headphone_jack),
            combine("Additional ",additional)
        });
        return info;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones.phonecomponent;

import java.util.ArrayList;
import static lib.Tools.*;

/**
 *
 * @author JA
 */
public class Display {
    
    private final String type;
    public String size;
    public String resolution;
    private final String multitouch;
    private final String protection;
    private final String additional;
    
    public Display(String t,String s,String r,String m,String p,String a){
        type = t;
        size = s;
        resolution = r;
        multitouch = m;
        protection = p;
        additional = a;
    }
    
    /**
     * Return information
     * 0 - type
     * 1 - size
     * 2 - resolution
     * 3 - multitouch
     * 4 - protection
     * 5 - additional
     * @return all information
    */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Type",type),
            combine("Size", size),
            combine("Resolution", resolution),
            combine("Multitouch", multitouch),
            combine("Protection", protection),
            combine(" ",additional)
        });
        return info;
    }
    
}

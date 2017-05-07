/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes.phonecomponent;

import java.util.ArrayList;
import static lib.Tools.*;

/**
 *
 * @author JA
 */
public class Body{
    
    public String dimension;
    public String weight;
    private final String build;
    
    //SIM Card
    public int SIM_slot;
    private final String SIM_type;
    
    public Body(String d, String w, String b, int slot, String t){
        dimension = d;
        weight = w;
        build = b;
        SIM_slot = slot;
        SIM_type = t;
    }
    
    /**
     * Returns all information
     * 0 - Dimension
     * 1 - Weight
     * 2 - Build
     * 3 - SIM
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Dimension", dimension),
            combine("Weight",weight),
            combine("Build",build),
            combine("SIM",SIM_slot + " "+SIM_type),
        });
        return info;
    }
    
    
}

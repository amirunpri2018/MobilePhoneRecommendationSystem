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
public class Platform {
    
    public String OS;
    public String Chipset;
    public String Chipset2 = "";
    public String CPU;
    public String CPU2 = "";
    private String GPU;
    private String GPU2 = "";
    
    public Platform(String o,String cs,String cs2,String c,String c2,String g,String g2){
        OS = o;
        Chipset = cs;
        Chipset2 = cs2;
        CPU = c;
        CPU2 = c2;
        GPU = g;
        GPU2 = g2;
    }
    
    /**
     * Return all information
     * 0 - OS
     * 1 - Chipset
     * 2 - CPU
     * 3 - GPU
     * @return all information 
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("OS", OS),
            combine("Chipset",Chipset),
            combine(" ",Chipset2),
            combine("CPU",CPU),
            combine(" ",CPU2),
            combine("GPU",GPU),
            combine(" ",GPU2)
        });
        return info;
    }
    
}

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
public class Features {
    
    public String Sensors;
    public String Messaging;
    public String Browser;
    public String Games;
    public String Java;
    public String additional;
    
    public Features(String s,String m,String b,String j,String a){
        Sensors = s;
        Messaging = m;
        Browser = b;
        Java = j;
        additional = a;
        Games = "";
    }
    
    public Features(String s,String m,String b,String g,String j,String a){
        Sensors = s;
        Messaging = m;
        Browser = b;
        Games = g;
        Java = j;
        additional = a;
        Games = "";
    }
    
    /**
     * Return all information
     * 0 - Sensors
     * 1 - Messaging
     * 2 - Browser
     * 3 - Games *
     * 3 / 4* - Java
     * 4 / 5* - Additional info
     * \* is keypad phone
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Sensors",Sensors),
            combine("Messaging",Messaging),
            combine("Browser",Browser),
            combine("Games",Games),
            combine("Java",Java),
            combine(" ",additional)
        });
        return info;
    }
    
}

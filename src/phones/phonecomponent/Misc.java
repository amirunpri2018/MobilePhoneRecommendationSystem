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
public class Misc {
    
    public ArrayList<String> Colors = new ArrayList<>();
    public String SAR_US;
    public String SAR_EU;
    public String Price_group;
    
    public Misc(String c,String s,String s2,String p){
        for(String c1:c.split(", ")) Colors.add(c1);
        SAR_US = s;
        SAR_EU = s2;
        Price_group = p;
    }
    
    /**
     * Return all information
     * 0 - Colors
     * 1 - SAR EU
     * 2 - Price Group
     * @return all information
     */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        
        String temp = Colors.get(0);
        for(int i=1;i<Colors.size();i++) temp+= ", "+Colors.get(i);
        info = addInfos(info,new String[]{
            combine("Colors",temp),
            combine("SAR US",SAR_US),
            combine("SAR EU",SAR_EU),
            combine("Price Group",Price_group)
        });
        return info;
    }
    
}

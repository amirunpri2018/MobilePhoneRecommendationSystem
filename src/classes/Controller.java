/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JA
 */
public class Controller {
    //LOAD FILE FROM EXCEL
    public static void main(String[] args) {
    }
    
    public ArrayList<String> readLine(String str){
        ArrayList<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("([^,\"]\\S*|\".+?\")\\s*").matcher(str);
        while (m.find()){
            String s = m.group(1).replaceAll("\"","");
            if(s.charAt(s.length()-1)==',') s=s.substring(0,s.length()-1);
            list.add(s); // Add .replace("\"", "") to remove surrounding quotes.
        }
        return list;
    }
    
}

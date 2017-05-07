/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JA
 */
public class Tools {
    
    //SAME LENGTH STRING
    public static int COMBINELIMIT = 16;
    public static String combine(String a, String b){
        for(int i=a.length();i<16;i+=8){
            a += "\t";
        }
        return a+b;
    }
    
    //ADDING INFO OF COMPONENT
    public static ArrayList<String> addInfo(ArrayList a,String s){
        if(s!=null && !s.equals(""))    a.add(s);
        return a;
    }
    public static ArrayList<String> addInfos(ArrayList a,String[] s){
        for(String s1:s)
            a = addInfo(a,s1);
        return a;
    }
    public static String loadInfo(String loadFrom){
//        System.out.println(loadFrom);
        String temp;
        if(loadFrom!=null
                && !loadFrom.equals("-")
                && loadFrom.length()!=0){
            temp = loadFrom;
        }else{
            temp = "";
        }return temp;
    }
    
    //SIZE
    //<editor-fold defaultstate="collapsed" desc="Byte Conversion">
    public static int compareByte(String s1,String s2){
        long s1_ = toByte(s1.split(" "));
        long s2_ = toByte(s2.split(" "));
        if(s1_>s2_) return 1;
        else if (s1_==s2_) return 0;
        else return -1;
    }
    public static long toByte(String[] s){
        long l = Long.parseLong(s[0]);
        int i;
        switch(s[1].charAt(0)){
            case 'K': i=1; break;
            case 'M': i=2; break;
            case 'G': i=3; break;
            case 'T': i=4; break;
            default: i=0;
        }
        for(;i>0;i--){l*=1024;}
        return l;
    }
    public static String toHR(long b){
        int i=0;
        while(b>=1024){
            b/=1024;
            i++;
        }
        String s = ""+b;
        switch(i){
            case 1: s+= " K"; break;
            case 2: s+= " M"; break;
            case 3: s+= " G"; break;
            case 4: s+= " T"; break;
            default: ;
        }
        return s+"B";
    }
    public static String addByte(String s1,String s2){
        long s_1 = toByte(s1.split(" "));
        long s_2 = toByte(s2.split(" "));
        return toHR(s_1+s_2);
    }
    //</editor-fold>
    
    public static void displayHashMap(HashMap map) {
        Iterator it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key: "+key);
            System.out.println(map.get(key));
        }
    }
    
    
    public static boolean createFile(String dir,String file){
        File directory = new File(dir);
        if(!directory.exists()) directory.mkdirs();
        File f = new File(file);
        try{
            if(!f.exists()) f.createNewFile();
        }catch(IOException e){
            return false;
        }return true;
    }
    public static ArrayList<String> readLine(String str){
        ArrayList<String> list = new ArrayList<>();
        /**
         * [^,\"]   token starting with something other than " and ,
         * \S*      followed by zero or more non-space characters
         * |        or
         * ".+?"    a " symbol followed by whatever until another "
         */
        Matcher m = Pattern.compile("([^,\"]\\S*|\"\"\".+?\"\"\")\\s*").matcher(str);
        while (m.find()){
            String s = m.group(1).replaceAll("\"","");
            if(s.length()>0 && s.charAt(s.length()-1)==',') s=s.substring(0,s.length()-1);
            list.add(s);
        }
//        for(String s:list){
//            System.out.println(s);
//        }
        return list;
    }
}

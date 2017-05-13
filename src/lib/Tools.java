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
import phones.MobilePhone;

/**
 *
 * @author JA
 */
public class Tools {
    
    //<editor-fold defaultstate="collapsed" desc="INFO READING TOOLS">
    //SAME LENGTH STRING
    public static int COMBINELIMIT = 32;
    public static String combine(String a, String b){
        for(int i=a.length();i<COMBINELIMIT;i+=8){
            a += "\t";
        }
        return a+b;
    }
    
    //ADDING INFO OF COMPONENT
    public static ArrayList<String> addInfo(ArrayList a,String s){
        String[] temp = s.split("\t");
        if(s!=null && !s.equals("") && temp.length>1 && !temp[temp.length-1].equals(" ")){
            a.add(s);
        }
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
    public static ArrayList<String> returnInfo(String component,ArrayList<String> a){
        for(int i=0;i<a.size();i++){
            String s = a.get(i);
            if(i==0) s = combine(component,s);
            else s = combine("",s);
            a.set(i,s);
        }
        return a;
    }
    public static ArrayList<String> readLine(String str){
        ArrayList<String> list = new ArrayList<>();
        /**
         * [^\"]   token starting with something other than " and ,
         * \S*      followed by zero or more non-space characters
         * |        or
         * \"\"\".+?\"\"\"    a """ symbol followed by whatever until another """
         * Pattern.Multiline    Enables multiline reading
         * Pattern.Dotall       Ignores normal line ending
         */
        Matcher m = Pattern.compile("([^, \"]\\S*|\"\"\".+?\"\"\")\\s*",Pattern.MULTILINE|Pattern.DOTALL).matcher(str);
        while (m.find()){
            String s = m.group(1).replaceAll("\"","");
            if(s.length()==1 && s.equals("-")) s = " ";
            if(s.length()>0 && s.charAt(s.length()-1)==',') s=s.substring(0,s.length()-1);
            list.add(s);
        }
        return list;
    }
    //</editor-fold>
    
    //SIZE
    //<editor-fold defaultstate="collapsed" desc="Byte Conversion">
    public static int compareByte(String s1,String s2){
        float s1_ = toByte(s1.split(" "));
        float s2_ = toByte(s2.split(" "));
        if(s1_>s2_) return 1;
        else if (s1_==s2_) return 0;
        else return -1;
    }
    public static float toByte(String[] s){
        float l = Float.parseFloat(s[0]);
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
    public static String toHR(float b){
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
        float s_1 = toByte(s1.split(" "));
        float s_2 = toByte(s2.split(" "));
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
    
    //<editor-fold defaultstate="collapsed" desc="DEBUGGING TOOLS">
    //DEBUGGING THINGS
    static String OUTPUT = "output.txt";
    public static void writeOUT(String toWrite){
        createFile("",OUTPUT);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
            bw.append(toWrite);
            bw.newLine();
            bw.close();
        }catch (IOException e){
            System.out.println("??? "+e);
        }
    }
    public static String wtf(int i){
        String toRet = "";
        i += 65;
        int j=64;
        boolean morethan = false;
        while(i>90){
            j++;
            i-=26;
            morethan = true;
        }
        if(morethan) toRet += (char) j;
        toRet += (char) i;
        return toRet;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SORTING BY RATING">
    //merge sort
    public static ArrayList<MobilePhone> merge_sort(ArrayList<MobilePhone> arr){  //merge sort algorithm
        if(arr.size()<9)    return bubble_sort(arr);    //use bubble sort once the arr gets small enough
        else    
            return merge_arr(
                merge_sort(new ArrayList<MobilePhone>(arr.subList(0, arr.size()/2)))
                ,merge_sort(new ArrayList<MobilePhone>(arr.subList(arr.size()/2,arr.size())))
            ); //recursion
    }
    private static ArrayList<MobilePhone> merge_arr(ArrayList<MobilePhone> a, ArrayList<MobilePhone> b) {   //merging arrays
        ArrayList<MobilePhone> answer = new ArrayList<>();
        if(a.get(a.size()-1).getRating()>=b.get(0).getRating()){
            answer.addAll(a);
            answer.addAll(b);
        }else if(b.get(b.size()-1).getRating()>=a.get(0).getRating()){
            answer.addAll(b);
            answer.addAll(a);
        }else{
            while (a.size()>0 && b.size()>0){
                if (a.get(0).getRating()>=b.get(0).getRating())    answer.add(a.remove(0));
                else    answer.add(b.remove(0));
            }
            answer.addAll(a); answer.addAll(b);
        }
        return answer;
    }
    private static ArrayList<MobilePhone> bubble_sort(ArrayList<MobilePhone> arr) {    //bubble sort algorithm
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 1; j < (arr.size() - i); j++) {
                if (arr.get(j - 1).getRating()<arr.get(j).getRating()) {
                    MobilePhone temp = arr.get(j-1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j, temp);
                }
            }
        }return arr;
    }
    //</editor-fold>
    
}

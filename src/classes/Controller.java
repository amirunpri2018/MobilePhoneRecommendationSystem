/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import java.io.*;
import static lib.Tools.*;

/**
 *
 * @author JA
 */
public class Controller {
    
    //LOAD FILE LOCATION
    private static final String PATH = "";
    private static final String FILE = "hehe.csv";
    
    //CHECKER FOR INITIALIZED
    protected static boolean INIT = false;
    
    //ARRAYLIST OF CREATED PHONES
    public static ArrayList<MobilePhone> list = new ArrayList<>();
    
    //ARRAYLIST OF BRANDS
    public static ArrayList<String> BRANDS = new ArrayList<>();
    public static String[] brands = { "Samsung","Apple"};
    
    //LOAD FILE FROM CSV
    public static void readFile(){
        if(!INIT){
            for(String s:brands)BRANDS.add("\"\"\""+s+"\"\"\"");
            if(createFile(PATH,FILE)){
                try {
                    BufferedReader br = new BufferedReader(new FileReader(FILE));
                    String line;
                    String holder="";
                    boolean holding=false;
                    //DONOT REMOVE THESE
                    line = br.readLine();       //GROUP
                    line = br.readLine();       //DETAILS
                    //
                    while(true){
                        //READING LINES
                        /*
                        Due to BufferedReader unable to bypass "\n" thing by design
                        This part will go right through it
                        */
                        if(holder!=null) line = holder;
                        if(holder==null) break;
                        if(!holding) line = br.readLine();
                        while((holder = br.readLine())!=null){
                            if(BRANDS.contains(holder.split(",")[0])) break;
                            if(holder.charAt(0)=='-'){
                                line+=combine("\n",holder); 
                                holding = false;
                            }else{
                                holding = true;
                            }
                        }
                        //
                        ArrayList<String> temp = readLine(line);
                        MobilePhone p;
                        COMBINELIMIT = 16;
                        
                        //SEE GOT WHAT BRAND THEN ADD WHAT BRAND HERE
                        /*
                        Phone format
                        p = new <BRAND>(line,Float.parseFloat(temp[temp.length-1]));
                        temp[temp.length-1] == Phone rating
                        */
                        switch(temp.get(0)){
                            case "Samsung":
                                p = new Samsung(line,Float.parseFloat(temp.get(temp.size()-1)));
                                break;
                            case "Apple":
                                p = new Apple(line,Float.parseFloat(temp.get(temp.size()-1)));
                                break;
                            case "Nokia":
                                p = new Nokia(line,Float.parseFloat(temp.get(temp.size()-1)));
                                break;
                            case "":
                                p = new Apple(line,Float.parseFloat(temp.get(temp.size()-1)));
                                break;
                            default:
                                p = new Samsung("",0.0f);
                        }
                        //
                        list.add(p);
                    }
                }catch(FileNotFoundException ex) {
                    System.out.println("!!!DATABASE NOT FOUND!!!");
                    System.exit(1);
                } catch (IOException e){
                    System.out.println("ERROR FILE READER FILE");
                }catch(NullPointerException e){
                    //FILE FINISH READING
                }
            }else{
                System.out.println("!!!DATABASE NOT FOUND!!!");
                System.exit(1);
            }
        }else{
            //FILE ALREADY LOADED
        }
        INIT = true;
    }
    
    public static void main(String[] args) {
        readFile();
        int i =0;
        if(!list.isEmpty()){
            for(MobilePhone p:list){
                System.out.println("PHONE "+(i++));
                for(String s: p.getInfo()){
                    System.out.println(s);
                }
            }
        }
    }
    
}

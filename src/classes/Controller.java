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
    
    //LOAD FILE FROM CSV
    public static void readFile(){
        if(!INIT){
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
                        line = holder;
                        if(!holding) line = br.readLine();
                        while((holder = br.readLine())!=null){
                            if(holder.charAt(0)=='-'){
                                line+=combine("\n",holder);
                                holding = false;
                            }
                            else{
                                holding = true;
                            }
                        }
                        ArrayList<String> temp = readLine(line);
                        MobilePhone p;
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
                        INIT = true;
                    }
                }catch(FileNotFoundException ex) {
                    System.out.println("!!!DATABASE NOT FOUND!!!");
                    System.exit(1);
                } catch (IOException e){
                    System.out.println("ERROR FILE READER FILE");
                }catch(NullPointerException e){
//                    System.out.println("READ FINISH LIAO LAR");
                }
            }else{
                System.out.println("!!!DATABASE NOT FOUND!!!");
                System.exit(1);
            }
        }else{
            //FILE ALREADY LOADED
        }
    }
    
    public static void main(String[] args) {
//        String s = "\"\"\"Samsung\"\"\",\"\"\"Galaxy S8\"\"\",\"\"\"RM 3299\"\"\",\"\"\"<insert path here>\"\"\",\"\"\"GSM/HSPA/LTE\"\"\",\"\"\"Available. Released 2017, April\"\"\",\"\"\"148.9 x 68.1 x 8 mm (5.86 x 2.68 x 0.31 in)\"\"\",\"\"\"155 g (5.47 oz)\"\"\",\"\"\"Corning Gorilla Glass 5 back panel\"\"\",\"\"\"2\"\"\",\"\"\"Nano-SIM\"\"\",\"\"\"Super AMOLED capacitive touchscreen, 16M colors\"\"\",\"\"\"5.8 inches (~83.6% screen-to-body ratio)\"\"\",\"\"\"1440 x 2960 pixels (~570 ppi pixel density)\"\"\",\"\"\"Yes\"\"\",\"\"\"Corning Gorilla Glass 5\"\"\",\"\"\"- 3D Touch (home button only)\n" +
//"- Always-on display\n" +
//"- TouchWiz UI\"\"\",\"\"\"Android 7.0 (Nougat)\"\"\",\"\"\"Exynos 8895 Octa - EMEA\"\"\",\"\"\"Qualcomm MSM8998 Snapdragon 835 - US model\"\"\",\"\"\"Octa-core (4x2.3 GHz & 4x1.7 GHz) - EMEA\"\"\",\"\"\"Octa-core (4x2.35 GHz Kryo & 4x1.9 GHz Kryo) - US model\"\"\",\"\"\"Mali-G71 MP20 - EMEA\"\"\",\"\"\"Adreno 540 - US model\"\"\",\"\"\"microSD\"\"\",\"\"\"256 GB\"\"\",\"\"\"64 GB\"\"\",\"\"\"4 GB\"\"\",\"\"\"12 MP, f/1.7, 26mm, phase detection autofocus, OIS, LED flash\"\"\",\"\"\"1/2.5\"\" sensor size, 1.4 µm pixel size, geo-tagging, simultaneous 4K video and 9MP image recording, touch focus, face/smile detection, Auto HDR, panorama\"\"\",\"\"\"2160p@30fps, 1080p@60fps, HDR, dual-video rec.\"\"\",\"\"\"8 MP, f/1.7, autofocus, 1440p@30fps, dual video call, Auto HDR\"\"\",\"\"\"Vibration; MP3, WAV ringtones\"\"\",\"\"\"Yes\"\"\",\"\"\"Yes\"\"\",\"\"\"Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot\"\"\",\"\"\"5.0, A2DP, LE, aptX\"\"\",\"\"\" Yes, with A-GPS, GLONASS, BDS, GALILEO\"\"\",\"\"\"Yes\"\"\",\"\"\"No\"\"\",\"\"\"3.1, Type-C 1.0 reversible connector\"\"\",\"\"\"Iris scanner, fingerprint (rear-mounted), accelerometer, gyro, proximity, compass, barometer, heart rate, SpO2\"\"\",\"\"\"SMS(threaded view), MMS, Email, Push Mail, IM\"\"\",\"\"\"HTML\"\"\",\"\"\"No\"\"\",\"\"\"- Samsung DeX (desktop experience support)\n" +
//"- Fast battery charging (Quick Charge 2.0)\n" +
//"- Qi/PMA wireless charging (market dependent)\n" +
//"- ANT+ support\n" +
//"- S-Voice natural language commands and dictation\n" +
//"- MP4/DivX/XviD/H.265 player\n" +
//"- MP3/WAV/eAAC+/FLAC player\n" +
//"- Photo/video editor\n" +
//"- Document editor\"\"\",\"\"\"Non-removable Li-Ion 3000 mAh battery\"\"\",\"\"\"-\"\"\",\"\"\"-\"\"\",\"\"\"-\"\"\",\"\"\"Midnight Black, Orchid Gray, Arctic Silver, Coral Blue, Maple Gold\"\"\",\"\"\"0.32 W/kg (head)     1.27 W/kg (body) \"\"\",\"\"\"9/10\"\"\",\"\"\"Basemark OS II: 3272 / Basemark OS II 2.0: 3376\n" +
//"Basemark X: 42370\"\"\",\"\"\"Contrast ratio: Infinite (nominal), 4.768 (sunlight)\"\"\",\"\"\"-\"\"\",\"\"\"Voice 68dB / Noise 69dB / Ring 70dB\"\"\",\"\"\"Noise -92.5dB / Crosstalk -92.8dB\"\"\",\"\"\"Endurance rating 84h\"\"\",\"\"\"-\"\"\",\"\"\"-\"\"\",\"\"\"-\"\"\",\"\"\"4.8\"\"\"";
//        ArrayList<String> t = readLine(s);
//        System.out.println(t.size());
//        for(int i=0;i<t.size();i++){
//            System.out.println("t:"+i+" @"+t.get(i));
//        }
        readFile();
        if(!list.isEmpty()){
            for(MobilePhone p:list){
                System.out.println(p.brand);
                System.out.println(p.name);
                for(String s:p.getCamera()) System.out.println(s);
                for(String s:(p.c_display.getInfo())) System.out.println(s);
            }
        }
    }
    
}

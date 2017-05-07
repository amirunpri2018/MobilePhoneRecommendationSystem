/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import classes.phonecomponent.*;
import java.util.ArrayList;
import static lib.Tools.combine;
import static lib.Tools.loadInfo;
import static lib.Tools.readLine;
import static lib.Tools.COMBINELIMIT;
import static lib.Tools.returnInfo;

/**
 *
 * @author JA
 */
public abstract class MobilePhone {
    
    //BASIC INFO
    protected String brand;
    protected String name;
    protected String price;
    protected String image;
    protected float rating;
    
    //ADDITIONAL INFO
    protected String c_network;
//    protected boolean c_isLaunch;
    protected String c_launch;
    protected Body c_body;
    protected Display c_display;
    protected Platform c_platform;
    protected Memory c_memory;
    protected Camera c_camera;
    protected Sound c_sound;
    protected Comms c_comms;
    protected Features c_feature;
    protected Battery c_battery;
    protected Misc c_misc;
    protected Tests c_tests;
    protected boolean keypad;
    protected boolean touchscreen;
    
    protected int loadDao = 0;
    public boolean loaded = false;
    
    //GET BASIC INFO
    public String getImage(){return image;}
    public String getPrice(){return price;}             
    public String getBrand(){return brand;}            
    public String getName(){return name;}               
    public String getFullName(){return brand+" "+name;}
    
    //GET ADD INFO
    public String getNetwork(){return combine("Technology",c_network);}
//  public boolean isLaunch(){return c_isLaunch;}
    public String getLaunch(){return combine("Status",c_launch);}
    public ArrayList<String> getBody(){return c_body.getInfo();}
    public ArrayList<String> getDisplay(){return c_display.getInfo();}
    public ArrayList<String> getPlatform(){return c_platform.getInfo();}
    public ArrayList<String> getMemory(){return c_memory.getInfo();}
    public ArrayList<String> getCamera(){return c_camera.getInfo();}
    public ArrayList<String> getSound(){return c_sound.getInfo();}
    public ArrayList<String> getComms(){return c_comms.getInfo();}
    public ArrayList<String> getFeatures(){return c_feature.getInfo();}
    public ArrayList<String> getBattery(){return c_battery.getInfo();}
    public ArrayList<String> getMisc(){return c_misc.getInfo();}
    public ArrayList<String> getTests(){return c_tests.getInfo();}
    
    //GET ALL INFO
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        COMBINELIMIT = 32;
        info.add(combine("Brand",getBrand()));
        info.add(combine("Name",getName()));
        info.add(combine("Image",getImage()));
        info.add(combine("Price",getPrice()));
        COMBINELIMIT = 16;
        info.add(combine("Network",getNetwork()));
        info.add(combine("Launch",getLaunch()));
        info.addAll(returnInfo("Body",getBody()));
        info.addAll(returnInfo("Display",getDisplay()));
        info.addAll(returnInfo("Platform",getPlatform()));
        info.addAll(returnInfo("Memory",getMemory()));
        info.addAll(returnInfo("Camera",getCamera()));
        info.addAll(returnInfo("Sound",getSound()));
        info.addAll(returnInfo("Comms",getComms()));
        info.addAll(returnInfo("Features",getFeatures()));
        info.addAll(returnInfo("Battery",getBattery()));
        info.addAll(returnInfo("Misc",getMisc()));
        info.addAll(returnInfo("Tests",getTests()));
        return info;
    }
    
    //FILTER
    public String cameraF(){return c_camera.pPhoto_Quality;}
    public String cameraB(){return c_camera.sPhoto_Quality;}
    public String storage(){return c_memory.Internal;}
    public String memory(){return c_memory.RAM;}
    public String price(){return getPrice();}
    public String brand(){return getBrand();}
    public float getRating(){return rating;}
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public MobilePhone(String information){
//        loadDao = 0;
        ArrayList<String> info = readLine(information);
        brand = loadInfo(info.get(loadDao++));
        name = loadInfo(info.get(loadDao++));
        price = loadInfo(info.get(loadDao++));
        image = loadInfo(info.get(loadDao++));
        c_network = loadInfo(info.get(loadDao++));
        c_launch = loadInfo(info.get(loadDao++));
        
        c_body = new Body(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,Integer.parseInt(loadInfo(info.get(loadDao++)))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_display = new Display(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_platform = new Platform(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_memory = new Memory(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_camera = new Camera(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_sound = new Sound(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_comms = new Comms(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_feature = new Features(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_battery = new Battery(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_misc = new Misc(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        c_tests = new Tests(loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
                ,loadInfo(info.get(loadDao++))
        );
        
        loaded = true;
    }
    //</editor-fold>
}

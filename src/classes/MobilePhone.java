/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import classes.phonecomponent.*;
import java.util.ArrayList;
import static lib.Tools.loadInfo;

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
    protected boolean c_isLaunch;
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
    public String getNetwork(){return c_network;}
    public boolean isLaunch(){return c_isLaunch;}
    public String getLaunch(){return c_launch;}
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
    
    //FILTER
    public String cameraF(){return c_camera.pPhoto_Quality;}
    public String cameraB(){return c_camera.sPhoto_Quality;}
    public String storage(){return c_memory.Internal;}
    public String memory(){return c_memory.RAM;}
    public String price(){return getPrice();}
    public String brand(){return getBrand();}
    
    public MobilePhone(String information){
        String[] info = information.split("\t");
        name = loadInfo(info[loadDao++]);
        price = loadInfo(info[loadDao++]);
        image = loadInfo(info[loadDao++]);
        c_network = loadInfo(info[loadDao++]);
        c_launch = loadInfo(info[loadDao++]);
        
        c_body = new Body(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,Integer.parseInt(loadInfo(info[loadDao++]))
                ,loadInfo(info[loadDao++])
        );
        
        c_display = new Display(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_platform = new Platform(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_memory = new Memory(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_camera = new Camera(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_sound = new Sound(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_comms = new Comms(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_feature = new Features(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_battery = new Battery(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_misc = new Misc(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        c_tests = new Tests(loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
                ,loadInfo(info[loadDao++])
        );
        
        loaded = true;
    }
    
}

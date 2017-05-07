/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import classes.phonecomponent.*;
import java.util.ArrayList;

/**
 *
 * @author JA
 */
public abstract class MobilePhone {
    
    //BASIC INFO
    String brand;
    String name;
    String price;
    String image;
    
    //ADDITIONAL INFO
    String c_network;
    boolean c_isLaunch;
    String c_launch;
    Body c_body;
    Display c_display;
    Platform c_platform;
    Memory c_memory;
    Camera c_camera;
    Sound c_sound;
    Comms c_comms;
    Features c_feature;
    Battery c_battery;
    Misc c_misc;
    Tests c_tests;
    boolean keypad;
    boolean touchscreen;
    
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
    
}

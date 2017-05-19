/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones;

import phones.phonecomponent.*;
import java.util.ArrayList;
import java.util.HashMap;
import static lib.Tools.*;

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
    protected String type;
    
    //ADDITIONAL INFO
    //<editor-fold defaultstate="collapsed" desc="Components">
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
    //</editor-fold>
    
    public ArrayList<String> title = new ArrayList<String>(){{
            add("Brand");
            add("Name");
            add("Price");
            add("Network");
            add("Launch");
            add("Body");
            add("Display");
            add("Platform");
            add("Memory");
            add("Camera");
            add("Sound");
            add("Comms");
            add("Features");
            add("Battery");
            add("Misc");
            add("Tests");
        }};
    
    protected int loadDao = 0;
    public boolean loaded = false;
    
    //<editor-fold defaultstate="collapsed" desc="Getting Info">
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
    //</editor-fold>
    
    //GET ALL INFO
    //<editor-fold defaultstate="collapsed" desc="getInfo()">
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        COMBINELIMIT = 32;
        info.add(combine("Brand",getBrand()));
        info.add(combine("Name",getName()));
        info.add(combine("Price","RM "+getPrice()));
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
    public HashMap<String,ArrayList<String>> getInfo2(){
        HashMap<String,ArrayList<String>> info = new HashMap<>();
        COMBINELIMIT = 16;
        info.put("Brand",new ArrayList<String>(){{add(getBrand());}});
        info.put("Name",new ArrayList<String>(){{add(getName());}});
        info.put("Price",new ArrayList<String>(){{add("RM "+getPrice());}});
        info.put("Network",new ArrayList<String>(){{add(getNetwork());}});
        info.put("Launch",new ArrayList<String>(){{add(getLaunch());}});
        info.put("Body",getBody());
        info.put("Display",getDisplay());
        info.put("Platform",getPlatform());
        info.put("Memory",getMemory());
        info.put("Camera",getCamera());
        info.put("Sound",getSound());
        info.put("Comms",getComms());
        info.put("Features",getFeatures());
        info.put("Battery",getBattery());
        info.put("Misc",getMisc());
        info.put("Tests",getTests());
        return info;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="FILTERS">
    //FILTER
    public ArrayList<String> FILTER(){
        ArrayList<String> filter = new ArrayList<>();
        filter.add(brand());
        filter.add(price());
        filter.add(os());
        filter.add(memory());
        filter.add(storage());
        filter.add(simslot());
        filter.add(cameraF());
        filter.add(cameraB());
        return filter;
    }
    public String cameraB(){return c_camera.pPhoto_Quality;}
    public String cameraF(){return c_camera.sPhoto_Quality;}
    public String storage(){return c_memory.SD_size;}
    public String memory(){return c_memory.RAM;}
    public String price(){return getPrice();}
    public String brand(){return getBrand();}
    public ArrayList<String> colors(){return c_misc.Colors;}
    public String os(){return c_platform.OS;}
    public String simslot(){return Integer.toString(c_body.SIM_slot);}
    public String getType(){return type;}
    public float getRating(){return rating;}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public MobilePhone(String information){
//        loadDao = 0;
        ArrayList<String> info = readLine(information);
        type = loadInfo(info.get(loadDao++));
        brand = loadInfo(info.get(loadDao++));
        name = loadInfo(info.get(loadDao++));
        price = loadInfo(info.get(loadDao++));
        image = loadInfo("images/"+info.get(loadDao++));
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

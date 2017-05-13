/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import knowledge.Result;
import knowledge.SimpleInformation;
import lib.Search;
import lib.Tools;

/**
 *
 * @author Woh
 */
public class FilterPanel extends javax.swing.JPanel {

    /**
     * Creates new form FilterPanel
     */
    public HashMap<String, JCheckBox> checkboxes;
    public HashMap<String, JTextField> textfields;
    public ArrayList<String> keyword;
    private Runnable searchRunnable = new Runnable() {
        @Override
        public void run() {
            HashMap<String, ArrayList<String>> keyword = new HashMap<>();
            Iterator checkboxIterator = checkboxes.keySet().iterator();
            String[] key = {"type","brand", "price", "os", "memory", "storage", "numberOfSimSlots", "f_camera", "b_camera"};
            for (String k : key) {
                keyword.put(k, new ArrayList<>());
            }
            while (checkboxIterator.hasNext()) {
                String prefix = (String) checkboxIterator.next();
                JCheckBox checkbox = checkboxes.get(prefix);
                if (checkbox.isSelected()) {
                    for (String k : key) {
                        if (prefix.contains(k)) {
                            if (prefix.contains("other")) {
                                String newPrefix = prefix + "TextField";
                                keyword.get(k).add(textfields.get(newPrefix).getText());
                            } else {
                                keyword.get(k).add(checkbox.getText());
                            }
                            break;
                        }
                    }
                }
            }
            Iterator textfieldIterator = textfields.keySet().iterator();
            while (textfieldIterator.hasNext()) {
                String prefix = (String) textfieldIterator.next();
                if (prefix.contains("price")) {
                    keyword.get("price").add(textfields.get(prefix).getText());
                }
            }
            keyword.put("search", new ArrayList<>());
            keyword.get("search").add(searchTextField.getText());
            //searching start here
//            Result[] results = Search.search(keyword);
//            showSearchResult(results);
        }
    };
    private Thread searchThread = new Thread(searchRunnable);

    public FilterPanel() {
        initComponents();
        checkboxes = new HashMap<>();
        textfields = new HashMap<>();

        checkboxes.put("type_smartphone", type_smartphone);
        checkboxes.put("type_keypad", type_keypad);
        
        checkboxes.put("brand_samsung", brand_samsung);
        checkboxes.put("brand_apple", brand_apple);
        checkboxes.put("brand_sony", brand_sony);
        checkboxes.put("brand_xiaomi", brand_xiaomi);
        checkboxes.put("brand_huawei", brand_huawei);
        checkboxes.put("brand_asus", brand_asus);
        checkboxes.put("brand_oneplus", brand_oneplus);
        checkboxes.put("brand_htc", brand_htc);
        checkboxes.put("brand_nokia", brand_nokia);
        checkboxes.put("brand_other", brand_other);
        textfields.put("brand_otherTextField", brand_otherTextField);

        textfields.put("price_from", priceFromTextField);
        textfields.put("price_to", priceToTextField);

        checkboxes.put("os_android", os_android);
        checkboxes.put("os_ios", os_ios);
        checkboxes.put("os_windowPhone", os_windowPhone);
        checkboxes.put("os_other", os_other);
        textfields.put("os_otherTextField", os_otherTextField);

        checkboxes.put("memory_256", memory_256);
        checkboxes.put("memory_512", memory_512);
        checkboxes.put("memory_1", memory_1);
        checkboxes.put("memory_2", memory_2);
        checkboxes.put("memory_3", memory_3);
        checkboxes.put("memory_other", memory_other);
        textfields.put("memory_otherTextField", memory_otherTextField);

        checkboxes.put("numberOfSimSlots_1", number_1);
        checkboxes.put("numberOfSimSlots_2", number_2);

        checkboxes.put("f_camera_zeroToOneMP", f_camera_zeroToOneMP);
        checkboxes.put("f_camera_oneToTwoMP", f_camera_oneToTwoMP);
        checkboxes.put("f_camera_twoToThreeMP", f_camera_twoToThreeMP);
        checkboxes.put("f_camera_threeToFourMP", f_camera_threeToFourMP);
        checkboxes.put("f_camera_fourToFiveMP", f_camera_fourToFiveMP);
        checkboxes.put("f_camera_fiveAndupMP", f_camera_fiveAndupMP);

        checkboxes.put("b_camera_oneToFiveMP", b_camera_oneToFiveMP);
        checkboxes.put("b_camera_sixToTenMP", b_camera_sixToTenMP);
        checkboxes.put("b_camera_11To15MP", b_camera_11To15MP);
        checkboxes.put("b_camera_16To20MP", b_camera_16To20MP);
        checkboxes.put("b_camera_21AndupMP", b_camera_21AndupMP);
        checkboxes.put("b_camera_noCamera", b_camera_noCamera);

    }

    public void searchOnClick() {
        searchThread.start();
    }

    public void showSearchResult(Result[] results) {
        displayInnerPanel.removeAll();
        for (Result result : results) {
            SimpleInformation si = result.getSimpleInformation();
            SimplePhoneInfoPanel spip = new SimplePhoneInfoPanel();
            spip.setup(si.brand, si.phoneName, si.price, result);
            displayInnerPanel.add(spip);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterLabel = new javax.swing.JLabel();
        displayScrollPane = new javax.swing.JScrollPane();
        displayInnerPanel = new javax.swing.JPanel();
        simplePhoneInfoPanel1 = new gui.SimplePhoneInfoPanel();
        simplePhoneInfoPanel2 = new gui.SimplePhoneInfoPanel();
        simplePhoneInfoPanel3 = new gui.SimplePhoneInfoPanel();
        filterScrollPane = new javax.swing.JScrollPane();
        filterPanel = new javax.swing.JPanel();
        brandFilterLabel = new javax.swing.JLabel();
        brandFilterScrollPane = new javax.swing.JScrollPane();
        brandFilterPanel = new javax.swing.JPanel();
        brand_samsung = new javax.swing.JCheckBox();
        brand_apple = new javax.swing.JCheckBox();
        brand_sony = new javax.swing.JCheckBox();
        brand_xiaomi = new javax.swing.JCheckBox();
        brand_huawei = new javax.swing.JCheckBox();
        brand_asus = new javax.swing.JCheckBox();
        brand_oneplus = new javax.swing.JCheckBox();
        brand_htc = new javax.swing.JCheckBox();
        brand_nokia = new javax.swing.JCheckBox();
        brand_other = new javax.swing.JCheckBox();
        brand_otherTextField = new javax.swing.JTextField();
        priceFilterLabel = new javax.swing.JLabel();
        priceFilterPanel = new javax.swing.JPanel();
        priceFromLabel = new javax.swing.JLabel();
        priceFromTextField = new javax.swing.JTextField();
        priceToLabel = new javax.swing.JLabel();
        priceToTextField = new javax.swing.JTextField();
        osFilterLabel = new javax.swing.JLabel();
        osFilterScrollPane = new javax.swing.JScrollPane();
        osFilterPanel = new javax.swing.JPanel();
        os_android = new javax.swing.JCheckBox();
        os_ios = new javax.swing.JCheckBox();
        os_windowPhone = new javax.swing.JCheckBox();
        os_other = new javax.swing.JCheckBox();
        os_otherTextField = new javax.swing.JTextField();
        memoryFilterLabel = new javax.swing.JLabel();
        memoryFilterScrollPane = new javax.swing.JScrollPane();
        memoryFilterPanel = new javax.swing.JPanel();
        memory_256 = new javax.swing.JCheckBox();
        memory_512 = new javax.swing.JCheckBox();
        memory_1 = new javax.swing.JCheckBox();
        memory_2 = new javax.swing.JCheckBox();
        memory_3 = new javax.swing.JCheckBox();
        memory_other = new javax.swing.JCheckBox();
        memory_otherTextField = new javax.swing.JTextField();
        storageFilterLabel = new javax.swing.JLabel();
        storageFilterScrollPane = new javax.swing.JScrollPane();
        storageFilterPanel = new javax.swing.JPanel();
        storage_4 = new javax.swing.JCheckBox();
        storage_8 = new javax.swing.JCheckBox();
        storage_16 = new javax.swing.JCheckBox();
        storage_32 = new javax.swing.JCheckBox();
        storage_64 = new javax.swing.JCheckBox();
        storage_128 = new javax.swing.JCheckBox();
        storage_other = new javax.swing.JCheckBox();
        storage_otherTextField = new javax.swing.JTextField();
        numberOfSimSlotsFilterLabel = new javax.swing.JLabel();
        numberOfSimSlotsFilterPanel = new javax.swing.JPanel();
        number_1 = new javax.swing.JCheckBox();
        number_2 = new javax.swing.JCheckBox();
        frontCameraFilterLabel = new javax.swing.JLabel();
        frontCameraFilterScrollPane = new javax.swing.JScrollPane();
        frontCameraFilterCamera = new javax.swing.JPanel();
        f_camera_zeroToOneMP = new javax.swing.JCheckBox();
        f_camera_oneToTwoMP = new javax.swing.JCheckBox();
        f_camera_twoToThreeMP = new javax.swing.JCheckBox();
        f_camera_threeToFourMP = new javax.swing.JCheckBox();
        f_camera_fourToFiveMP = new javax.swing.JCheckBox();
        f_camera_fiveAndupMP = new javax.swing.JCheckBox();
        backCameraFilterLabel = new javax.swing.JLabel();
        backCameraFilterScrollPane = new javax.swing.JScrollPane();
        backCameraFilterPanel = new javax.swing.JPanel();
        b_camera_oneToFiveMP = new javax.swing.JCheckBox();
        b_camera_sixToTenMP = new javax.swing.JCheckBox();
        b_camera_11To15MP = new javax.swing.JCheckBox();
        b_camera_16To20MP = new javax.swing.JCheckBox();
        b_camera_21AndupMP = new javax.swing.JCheckBox();
        b_camera_noCamera = new javax.swing.JCheckBox();
        typeFilterLabel = new javax.swing.JLabel();
        typeFilterScrollPane = new javax.swing.JScrollPane();
        typeFilterPanel = new javax.swing.JPanel();
        type_smartphone = new javax.swing.JCheckBox();
        type_keypad = new javax.swing.JCheckBox();
        searchTextField = new javax.swing.JTextField();
        searchButtonTop = new javax.swing.JButton();

        filterLabel.setText("Filter");

        displayInnerPanel.setLayout(new java.awt.GridLayout(0, 1));
        displayInnerPanel.add(simplePhoneInfoPanel1);
        displayInnerPanel.add(simplePhoneInfoPanel2);
        displayInnerPanel.add(simplePhoneInfoPanel3);

        displayScrollPane.setViewportView(displayInnerPanel);

        filterScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        filterScrollPane.setMaximumSize(new java.awt.Dimension(325, 780));
        filterScrollPane.setMinimumSize(new java.awt.Dimension(325, 780));
        filterScrollPane.setName(""); // NOI18N
        filterScrollPane.setPreferredSize(new java.awt.Dimension(325, 780));

        filterPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        brandFilterLabel.setText("Brand");

        brandFilterScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        brand_samsung.setText("Samsung");

        brand_apple.setText("Apple");
        brand_apple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_appleActionPerformed(evt);
            }
        });

        brand_sony.setText("Sony");

        brand_xiaomi.setText("XiaoMi");

        brand_huawei.setText("HuaWei");

        brand_asus.setText("Asus");

        brand_oneplus.setText("OnePlus");

        brand_htc.setText("HTC");
        brand_htc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_htcActionPerformed(evt);
            }
        });

        brand_nokia.setText("Nokia");

        brand_other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_otherActionPerformed(evt);
            }
        });

        brand_otherTextField.setText("Other");

        javax.swing.GroupLayout brandFilterPanelLayout = new javax.swing.GroupLayout(brandFilterPanel);
        brandFilterPanel.setLayout(brandFilterPanelLayout);
        brandFilterPanelLayout.setHorizontalGroup(
            brandFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandFilterPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(brandFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(brandFilterPanelLayout.createSequentialGroup()
                        .addComponent(brand_other)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brand_otherTextField))
                    .addGroup(brandFilterPanelLayout.createSequentialGroup()
                        .addGroup(brandFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brand_samsung)
                            .addComponent(brand_apple)
                            .addComponent(brand_sony)
                            .addComponent(brand_xiaomi)
                            .addComponent(brand_huawei)
                            .addComponent(brand_asus)
                            .addComponent(brand_oneplus)
                            .addComponent(brand_htc)
                            .addComponent(brand_nokia))
                        .addGap(0, 173, Short.MAX_VALUE)))
                .addContainerGap())
        );
        brandFilterPanelLayout.setVerticalGroup(
            brandFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(brand_samsung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_apple)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_sony)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_xiaomi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_huawei)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_asus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_oneplus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_htc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brand_nokia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(brandFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brand_other)
                    .addComponent(brand_otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        brandFilterScrollPane.setViewportView(brandFilterPanel);

        priceFilterLabel.setText("Price");

        priceFromLabel.setText("from");

        priceFromTextField.setText("123");
        priceFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFromTextFieldActionPerformed(evt);
            }
        });

        priceToLabel.setText("to");

        priceToTextField.setText("456");

        javax.swing.GroupLayout priceFilterPanelLayout = new javax.swing.GroupLayout(priceFilterPanel);
        priceFilterPanel.setLayout(priceFilterPanelLayout);
        priceFilterPanelLayout.setHorizontalGroup(
            priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(priceFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, priceFilterPanelLayout.createSequentialGroup()
                        .addComponent(priceFromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(priceFilterPanelLayout.createSequentialGroup()
                        .addComponent(priceToLabel)
                        .addGap(21, 21, 21)))
                .addGroup(priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceFromTextField)
                    .addComponent(priceToTextField))
                .addContainerGap())
        );
        priceFilterPanelLayout.setVerticalGroup(
            priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(priceFilterPanelLayout.createSequentialGroup()
                .addGroup(priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceFromLabel)
                    .addComponent(priceFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(priceFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceToLabel)
                    .addComponent(priceToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        osFilterLabel.setText("Operating System");

        os_android.setText("Android");

        os_ios.setText("iOS");

        os_windowPhone.setText("Window Phone");

        os_other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                os_otherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout osFilterPanelLayout = new javax.swing.GroupLayout(osFilterPanel);
        osFilterPanel.setLayout(osFilterPanelLayout);
        osFilterPanelLayout.setHorizontalGroup(
            osFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(osFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(osFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(os_android)
                    .addComponent(os_ios)
                    .addComponent(os_windowPhone)
                    .addGroup(osFilterPanelLayout.createSequentialGroup()
                        .addComponent(os_other)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(os_otherTextField)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        osFilterPanelLayout.setVerticalGroup(
            osFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(osFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(os_android)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(os_ios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(os_windowPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(os_other)
                    .addComponent(os_otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        osFilterScrollPane.setViewportView(osFilterPanel);

        memoryFilterLabel.setText("Memory");

        memory_256.setText("256MB");
        memory_256.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memory_256ActionPerformed(evt);
            }
        });

        memory_512.setText("512MB");

        memory_1.setText("1GB");

        memory_2.setText("2GB");

        memory_3.setText("3GB");

        memory_other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memory_otherActionPerformed(evt);
            }
        });

        memory_otherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memory_otherTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout memoryFilterPanelLayout = new javax.swing.GroupLayout(memoryFilterPanel);
        memoryFilterPanel.setLayout(memoryFilterPanelLayout);
        memoryFilterPanelLayout.setHorizontalGroup(
            memoryFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoryFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(memoryFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memoryFilterPanelLayout.createSequentialGroup()
                        .addComponent(memory_other)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memory_otherTextField))
                    .addGroup(memoryFilterPanelLayout.createSequentialGroup()
                        .addGroup(memoryFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memory_256)
                            .addComponent(memory_512)
                            .addComponent(memory_1)
                            .addComponent(memory_2)
                            .addComponent(memory_3))
                        .addGap(0, 189, Short.MAX_VALUE)))
                .addContainerGap())
        );
        memoryFilterPanelLayout.setVerticalGroup(
            memoryFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoryFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memory_256)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memory_512)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memory_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memory_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memory_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(memoryFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(memory_other)
                    .addComponent(memory_otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        memoryFilterScrollPane.setViewportView(memoryFilterPanel);

        storageFilterLabel.setText("Storage");

        storage_4.setText("4GB");

        storage_8.setText("8GB");

        storage_16.setText("16GB");

        storage_32.setText("32GB");

        storage_64.setText("64GB");

        storage_128.setText("128GB");

        javax.swing.GroupLayout storageFilterPanelLayout = new javax.swing.GroupLayout(storageFilterPanel);
        storageFilterPanel.setLayout(storageFilterPanelLayout);
        storageFilterPanelLayout.setHorizontalGroup(
            storageFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storageFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(storageFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(storage_4)
                    .addComponent(storage_8)
                    .addComponent(storage_16)
                    .addComponent(storage_32)
                    .addComponent(storage_64)
                    .addComponent(storage_128)
                    .addGroup(storageFilterPanelLayout.createSequentialGroup()
                        .addComponent(storage_other)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storage_otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        storageFilterPanelLayout.setVerticalGroup(
            storageFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storageFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(storage_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage_8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage_16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage_32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage_64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage_128)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(storageFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(storage_other)
                    .addComponent(storage_otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        storageFilterScrollPane.setViewportView(storageFilterPanel);

        numberOfSimSlotsFilterLabel.setText("Number of Sim Slots");

        number_1.setText("1");

        number_2.setText("2");

        javax.swing.GroupLayout numberOfSimSlotsFilterPanelLayout = new javax.swing.GroupLayout(numberOfSimSlotsFilterPanel);
        numberOfSimSlotsFilterPanel.setLayout(numberOfSimSlotsFilterPanelLayout);
        numberOfSimSlotsFilterPanelLayout.setHorizontalGroup(
            numberOfSimSlotsFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberOfSimSlotsFilterPanelLayout.createSequentialGroup()
                .addGroup(numberOfSimSlotsFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(number_1)
                    .addComponent(number_2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        numberOfSimSlotsFilterPanelLayout.setVerticalGroup(
            numberOfSimSlotsFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberOfSimSlotsFilterPanelLayout.createSequentialGroup()
                .addComponent(number_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(number_2))
        );

        frontCameraFilterLabel.setText("Front camera");

        f_camera_zeroToOneMP.setText("0-1MP");

        f_camera_oneToTwoMP.setText("1-2MP");

        f_camera_twoToThreeMP.setText("2-3MP");

        f_camera_threeToFourMP.setText("3-4MP");

        f_camera_fourToFiveMP.setText("4-5MP");

        f_camera_fiveAndupMP.setText("5MP and up");

        javax.swing.GroupLayout frontCameraFilterCameraLayout = new javax.swing.GroupLayout(frontCameraFilterCamera);
        frontCameraFilterCamera.setLayout(frontCameraFilterCameraLayout);
        frontCameraFilterCameraLayout.setHorizontalGroup(
            frontCameraFilterCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontCameraFilterCameraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frontCameraFilterCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_camera_zeroToOneMP)
                    .addComponent(f_camera_oneToTwoMP)
                    .addComponent(f_camera_twoToThreeMP)
                    .addComponent(f_camera_threeToFourMP)
                    .addComponent(f_camera_fourToFiveMP)
                    .addComponent(f_camera_fiveAndupMP))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        frontCameraFilterCameraLayout.setVerticalGroup(
            frontCameraFilterCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontCameraFilterCameraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(f_camera_zeroToOneMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_camera_oneToTwoMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_camera_twoToThreeMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_camera_threeToFourMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_camera_fourToFiveMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_camera_fiveAndupMP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frontCameraFilterScrollPane.setViewportView(frontCameraFilterCamera);

        backCameraFilterLabel.setText("Back camera");

        b_camera_oneToFiveMP.setText("1-5MP");

        b_camera_sixToTenMP.setText("6-10MP");

        b_camera_11To15MP.setText("11-15MP");

        b_camera_16To20MP.setText("16-20MP");

        b_camera_21AndupMP.setText("21MP and up");

        b_camera_noCamera.setText("No camera");

        javax.swing.GroupLayout backCameraFilterPanelLayout = new javax.swing.GroupLayout(backCameraFilterPanel);
        backCameraFilterPanel.setLayout(backCameraFilterPanelLayout);
        backCameraFilterPanelLayout.setHorizontalGroup(
            backCameraFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backCameraFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backCameraFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_camera_oneToFiveMP)
                    .addComponent(b_camera_sixToTenMP)
                    .addComponent(b_camera_11To15MP)
                    .addComponent(b_camera_16To20MP)
                    .addComponent(b_camera_21AndupMP)
                    .addComponent(b_camera_noCamera))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        backCameraFilterPanelLayout.setVerticalGroup(
            backCameraFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backCameraFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_camera_oneToFiveMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_camera_sixToTenMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_camera_11To15MP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_camera_16To20MP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_camera_21AndupMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_camera_noCamera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backCameraFilterScrollPane.setViewportView(backCameraFilterPanel);

        typeFilterLabel.setText("Type");

        typeFilterScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        type_smartphone.setText("Smartphone");

        type_keypad.setText("Keypad Phone");
        type_keypad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_keypadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout typeFilterPanelLayout = new javax.swing.GroupLayout(typeFilterPanel);
        typeFilterPanel.setLayout(typeFilterPanelLayout);
        typeFilterPanelLayout.setHorizontalGroup(
            typeFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeFilterPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(typeFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type_smartphone)
                    .addComponent(type_keypad))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        typeFilterPanelLayout.setVerticalGroup(
            typeFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(type_smartphone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(type_keypad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        typeFilterScrollPane.setViewportView(typeFilterPanel);

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfSimSlotsFilterPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(osFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(brandFilterScrollPane)
                    .addComponent(memoryFilterScrollPane)
                    .addComponent(storageFilterScrollPane)
                    .addComponent(frontCameraFilterScrollPane)
                    .addComponent(backCameraFilterScrollPane)
                    .addGroup(filterPanelLayout.createSequentialGroup()
                        .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceFilterLabel)
                            .addComponent(osFilterLabel)
                            .addComponent(memoryFilterLabel)
                            .addComponent(storageFilterLabel)
                            .addComponent(numberOfSimSlotsFilterLabel)
                            .addComponent(frontCameraFilterLabel)
                            .addComponent(backCameraFilterLabel)
                            .addComponent(typeFilterLabel)
                            .addComponent(brandFilterLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(typeFilterScrollPane))
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memoryFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memoryFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storageFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storageFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberOfSimSlotsFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberOfSimSlotsFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frontCameraFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frontCameraFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backCameraFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backCameraFilterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filterScrollPane.setViewportView(filterPanel);

        searchButtonTop.setText("Search");
        searchButtonTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonTopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButtonTop))
                    .addComponent(displayScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterLabel)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButtonTop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void memory_otherTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memory_otherTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memory_otherTextFieldActionPerformed

    private void memory_otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memory_otherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memory_otherActionPerformed

    private void memory_256ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memory_256ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memory_256ActionPerformed

    private void os_otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_os_otherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_os_otherActionPerformed

    private void priceFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFromTextFieldActionPerformed

    private void brand_htcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_htcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_htcActionPerformed

    private void brand_otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_otherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_otherActionPerformed

    private void brand_appleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_appleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_appleActionPerformed

    private void searchButtonTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonTopActionPerformed
        // TODO add your handling code here:
        searchOnClick();
    }//GEN-LAST:event_searchButtonTopActionPerformed

    private void type_keypadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_keypadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_keypadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox b_camera_11To15MP;
    private javax.swing.JCheckBox b_camera_16To20MP;
    private javax.swing.JCheckBox b_camera_21AndupMP;
    private javax.swing.JCheckBox b_camera_noCamera;
    private javax.swing.JCheckBox b_camera_oneToFiveMP;
    private javax.swing.JCheckBox b_camera_sixToTenMP;
    private javax.swing.JLabel backCameraFilterLabel;
    private javax.swing.JPanel backCameraFilterPanel;
    private javax.swing.JScrollPane backCameraFilterScrollPane;
    private javax.swing.JLabel brandFilterLabel;
    private javax.swing.JPanel brandFilterPanel;
    private javax.swing.JScrollPane brandFilterScrollPane;
    private javax.swing.JCheckBox brand_apple;
    private javax.swing.JCheckBox brand_asus;
    private javax.swing.JCheckBox brand_htc;
    private javax.swing.JCheckBox brand_huawei;
    private javax.swing.JCheckBox brand_nokia;
    private javax.swing.JCheckBox brand_oneplus;
    private javax.swing.JCheckBox brand_other;
    private javax.swing.JTextField brand_otherTextField;
    private javax.swing.JCheckBox brand_samsung;
    private javax.swing.JCheckBox brand_sony;
    private javax.swing.JCheckBox brand_xiaomi;
    private javax.swing.JPanel displayInnerPanel;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JCheckBox f_camera_fiveAndupMP;
    private javax.swing.JCheckBox f_camera_fourToFiveMP;
    private javax.swing.JCheckBox f_camera_oneToTwoMP;
    private javax.swing.JCheckBox f_camera_threeToFourMP;
    private javax.swing.JCheckBox f_camera_twoToThreeMP;
    private javax.swing.JCheckBox f_camera_zeroToOneMP;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JScrollPane filterScrollPane;
    private javax.swing.JPanel frontCameraFilterCamera;
    private javax.swing.JLabel frontCameraFilterLabel;
    private javax.swing.JScrollPane frontCameraFilterScrollPane;
    private javax.swing.JLabel memoryFilterLabel;
    private javax.swing.JPanel memoryFilterPanel;
    private javax.swing.JScrollPane memoryFilterScrollPane;
    private javax.swing.JCheckBox memory_1;
    private javax.swing.JCheckBox memory_2;
    private javax.swing.JCheckBox memory_256;
    private javax.swing.JCheckBox memory_3;
    private javax.swing.JCheckBox memory_512;
    private javax.swing.JCheckBox memory_other;
    private javax.swing.JTextField memory_otherTextField;
    private javax.swing.JLabel numberOfSimSlotsFilterLabel;
    private javax.swing.JPanel numberOfSimSlotsFilterPanel;
    private javax.swing.JCheckBox number_1;
    private javax.swing.JCheckBox number_2;
    private javax.swing.JLabel osFilterLabel;
    private javax.swing.JPanel osFilterPanel;
    private javax.swing.JScrollPane osFilterScrollPane;
    private javax.swing.JCheckBox os_android;
    private javax.swing.JCheckBox os_ios;
    private javax.swing.JCheckBox os_other;
    private javax.swing.JTextField os_otherTextField;
    private javax.swing.JCheckBox os_windowPhone;
    private javax.swing.JLabel priceFilterLabel;
    private javax.swing.JPanel priceFilterPanel;
    private javax.swing.JLabel priceFromLabel;
    private javax.swing.JTextField priceFromTextField;
    private javax.swing.JLabel priceToLabel;
    private javax.swing.JTextField priceToTextField;
    private javax.swing.JButton searchButtonTop;
    private javax.swing.JTextField searchTextField;
    private gui.SimplePhoneInfoPanel simplePhoneInfoPanel1;
    private gui.SimplePhoneInfoPanel simplePhoneInfoPanel2;
    private gui.SimplePhoneInfoPanel simplePhoneInfoPanel3;
    private javax.swing.JLabel storageFilterLabel;
    private javax.swing.JPanel storageFilterPanel;
    private javax.swing.JScrollPane storageFilterScrollPane;
    private javax.swing.JCheckBox storage_128;
    private javax.swing.JCheckBox storage_16;
    private javax.swing.JCheckBox storage_32;
    private javax.swing.JCheckBox storage_4;
    private javax.swing.JCheckBox storage_64;
    private javax.swing.JCheckBox storage_8;
    private javax.swing.JCheckBox storage_other;
    private javax.swing.JTextField storage_otherTextField;
    private javax.swing.JLabel typeFilterLabel;
    private javax.swing.JPanel typeFilterPanel;
    private javax.swing.JScrollPane typeFilterScrollPane;
    private javax.swing.JCheckBox type_keypad;
    private javax.swing.JCheckBox type_smartphone;
    // End of variables declaration//GEN-END:variables
}

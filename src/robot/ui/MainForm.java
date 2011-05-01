/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainForm.java
 *
 * Created on Jan 8, 2010, 3:25:17 PM
 */
package robot.ui;

import robot.HardwareRobot;
import robot.eye.EyeImage;
import robot.joystick.JoystickDriver;
import vivae.robots.IRobotInterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class MainForm extends javax.swing.JFrame {

    private HardwareRobot robotInterf;
    private Timer timer;
    private Timer timerEye;

    /** Creates new form MainForm */
    public MainForm(final HardwareRobot robot) {
        this(robot, null);
    }

    public MainForm(final HardwareRobot robot, JoystickDriver joystickDriver) {
        initComponents();


        this.robotInterf = (HardwareRobot)robot;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @Override
            public void run() {

                if (robot != null && robot.isConnected()) {
                    updateSpeed();
                    if (jCheckBoxAutomaticUpdateStatus.isSelected()) {
                        updateStatus();
                        try {
                            updateEyeImages();
                        } catch (IOException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }
        }, new Date(), 100);
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        timerEye = new Timer();
        timerEye.scheduleAtFixedRate(new TimerTask() {
            long x = 0;
            @Override
            public void run() {
                System.out.println("tick 1 - " + (System.currentTimeMillis() - x));
                x = System.currentTimeMillis();
                if (robot != null && robot.isConnected()) {
                    if (jCheckBoxAutomaticUpdateStatus.isSelected()) {
                        try {
                System.out.println("tick 2 - " + (System.currentTimeMillis() - x));
                x = System.currentTimeMillis();
                            updateEyeImages();
                System.out.println("tick 3 - " + (System.currentTimeMillis() - x));
                x = System.currentTimeMillis();
                        } catch (IOException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }
        }, new Date(), 1000);

        navigator.setJoystickDriver(joystickDriver);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eyeDistPanel = new javax.swing.JPanel();
        eyeDistImagePanel = new robot.ui.ImagePanel();
        rightEyePanel = new javax.swing.JPanel();
        eyeRightImagePanel = new robot.ui.ImagePanel();
        leftEyePanel = new javax.swing.JPanel();
        eyeLeftImagePanel = new robot.ui.ImagePanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        fieldMaxSpeed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonSetWheelMaxSpeed = new javax.swing.JButton();
        jTextFieldPidK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPidTi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPidTd = new javax.swing.JTextField();
        jButtonSetPidParams = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPidk0 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        navigator = new robot.ui.Navigator();
        jPanel1 = new javax.swing.JPanel();
        buttonGetStatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaStatus = new javax.swing.JTextArea();
        jCheckBoxAutomaticUpdateStatus = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        eyeDistPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(" Distance map"));
        eyeDistPanel.setPreferredSize(new java.awt.Dimension(360, 280));

        eyeDistImagePanel.setBackground(java.awt.Color.cyan);

        javax.swing.GroupLayout eyeDistImagePanelLayout = new javax.swing.GroupLayout(eyeDistImagePanel);
        eyeDistImagePanel.setLayout(eyeDistImagePanelLayout);
        eyeDistImagePanelLayout.setHorizontalGroup(
            eyeDistImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        eyeDistImagePanelLayout.setVerticalGroup(
            eyeDistImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout eyeDistPanelLayout = new javax.swing.GroupLayout(eyeDistPanel);
        eyeDistPanel.setLayout(eyeDistPanelLayout);
        eyeDistPanelLayout.setHorizontalGroup(
            eyeDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eyeDistImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eyeDistPanelLayout.setVerticalGroup(
            eyeDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eyeDistImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rightEyePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(" Right Eye"));
        rightEyePanel.setPreferredSize(new java.awt.Dimension(320, 240));

        eyeRightImagePanel.setBackground(java.awt.Color.pink);

        javax.swing.GroupLayout eyeRightImagePanelLayout = new javax.swing.GroupLayout(eyeRightImagePanel);
        eyeRightImagePanel.setLayout(eyeRightImagePanelLayout);
        eyeRightImagePanelLayout.setHorizontalGroup(
            eyeRightImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        eyeRightImagePanelLayout.setVerticalGroup(
            eyeRightImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rightEyePanelLayout = new javax.swing.GroupLayout(rightEyePanel);
        rightEyePanel.setLayout(rightEyePanelLayout);
        rightEyePanelLayout.setHorizontalGroup(
            rightEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eyeRightImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rightEyePanelLayout.setVerticalGroup(
            rightEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eyeRightImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        leftEyePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(" Left Eye "));
        leftEyePanel.setPreferredSize(new java.awt.Dimension(320, 240));

        eyeLeftImagePanel.setBackground(java.awt.Color.yellow);

        javax.swing.GroupLayout eyeLeftImagePanelLayout = new javax.swing.GroupLayout(eyeLeftImagePanel);
        eyeLeftImagePanel.setLayout(eyeLeftImagePanelLayout);
        eyeLeftImagePanelLayout.setHorizontalGroup(
            eyeLeftImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        eyeLeftImagePanelLayout.setVerticalGroup(
            eyeLeftImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftEyePanelLayout = new javax.swing.GroupLayout(leftEyePanel);
        leftEyePanel.setLayout(leftEyePanelLayout);
        leftEyePanelLayout.setHorizontalGroup(
            leftEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
            .addGroup(leftEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(eyeLeftImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftEyePanelLayout.setVerticalGroup(
            leftEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(leftEyePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(eyeLeftImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Disconnect");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Get Eye Image");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        fieldMaxSpeed.setText("10");

        jLabel1.setText("cm/s");

        buttonSetWheelMaxSpeed.setText("Set Max Speed");
        buttonSetWheelMaxSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetWheelMaxSpeedActionPerformed(evt);
            }
        });

        jTextFieldPidK.setText("0.4");

        jLabel2.setText("K");

        jTextFieldPidTi.setText("3");

        jLabel3.setText("Ti");

        jLabel4.setText("Td");

        jTextFieldPidTd.setText("0.02");

        jButtonSetPidParams.setText("Set PID params");
        jButtonSetPidParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetPidParamsActionPerformed(evt);
            }
        });

        jLabel5.setText("k0");

        jTextFieldPidk0.setText("1");
        jTextFieldPidk0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPidk0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSetWheelMaxSpeed)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPidK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPidTi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPidTd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPidk0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButtonSetPidParams, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(fieldMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(buttonSetWheelMaxSpeed)
                    .addComponent(jButton5)
                    .addComponent(jTextFieldPidK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPidTi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPidTd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSetPidParams)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPidk0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" Navigator "));

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Status "));

        buttonGetStatus.setText("Get Status");
        buttonGetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetStatusActionPerformed(evt);
            }
        });

        textAreaStatus.setColumns(20);
        textAreaStatus.setFont(new java.awt.Font("Courier New", 0, 14));
        textAreaStatus.setRows(5);
        textAreaStatus.setDoubleBuffered(true);
        jScrollPane1.setViewportView(textAreaStatus);

        jCheckBoxAutomaticUpdateStatus.setText("Automatic Update");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jCheckBoxAutomaticUpdateStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(buttonGetStatus)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGetStatus)
                    .addComponent(jCheckBoxAutomaticUpdateStatus)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(eyeDistPanel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftEyePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightEyePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leftEyePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(rightEyePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eyeDistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateSpeed() {
        try {
            robotInterf.setWheelSpeed(navigator.getLeftSpeed(),
                    navigator.getRightSpeed(), 5.000);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateStatus() {
        try {
            Map<String, HardwareRobot.StatusValue> status = robotInterf.getStatus();
            Object[] keys = status.keySet().toArray();
            Arrays.sort(keys);
            int sz = 0;
            int szn = 0;
            for (Object key : keys) {
                HardwareRobot.StatusValue val = status.get((String) key);
                sz = Math.max(sz, ((val.getName()).length()));
                szn = Math.max(szn, ((String.format(Locale.US, "%.3f",
                        val.getValueAsDouble())).length()));
            }
            String s = "";
            String sx = "";
            for (Object key : keys) {
                HardwareRobot.StatusValue v = status.get((String) key);
                String format = String.format(Locale.US, "%%-%ds: %%%d.3f \n",
                        sz + 1, szn + 1);
                s +=
                        String.format(Locale.US, format,
                        v.getName(),
                        v.getValueAsDouble());
                sx +=
                        String.format(Locale.US, "%.3f ",
                        v.getValueAsDouble());
            }
            textAreaStatus.setText(s);
 //           System.out.println(sx);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateEyeImages() throws IOException {
        EyeImage leftEye = robotInterf.getEyeImage(
                HardwareRobot.EYE_IMAGE_LEFT, true);
        ((ImagePanel) eyeLeftImagePanel).setImage(
                leftEye.getImage(eyeLeftImagePanel));
        EyeImage rightEye = robotInterf.getEyeImage(
                HardwareRobot.EYE_IMAGE_RIGHT, false);
        ((ImagePanel) eyeRightImagePanel).setImage(
                rightEye.getImage(eyeRightImagePanel));
        EyeImage distEye = robotInterf.getEyeImage(
                HardwareRobot.EYE_IMAGE_DEPTH_MAP, false);
        ((ImagePanel) eyeDistImagePanel).setImage(
                distEye.getImage(eyeDistImagePanel));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        this.dispose();
        System.exit(0);//to kill the joystick thread
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            robotInterf.connect();
            navigator.setRobot(robotInterf);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot connect the robot ("
                    + robotInterf.getHostname() + ":" + robotInterf.getPort() + ")", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            // TODO add your handling code here:
            robotInterf.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            robotInterf.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            updateEyeImages();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buttonSetWheelMaxSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetWheelMaxSpeedActionPerformed
        try {
            buttonSetWheelMaxSpeed.setEnabled(false);
            try {
                robotInterf.setMaxWheelSpeed(Double.parseDouble(fieldMaxSpeed.getText()));
            } finally {
                buttonSetWheelMaxSpeed.setEnabled(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSetWheelMaxSpeedActionPerformed

    private void buttonGetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetStatusActionPerformed
        updateStatus();
    }//GEN-LAST:event_buttonGetStatusActionPerformed

    private void jButtonSetPidParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetPidParamsActionPerformed
        try {
            double K = 0;
            double Ti = 0;
            double Td = 0;
            double k0 = 0;
            try {
                K = Double.parseDouble(jTextFieldPidK.getText());
                Ti = Double.parseDouble(jTextFieldPidTi.getText());
                Td = Double.parseDouble(jTextFieldPidTd.getText());
                k0 = Double.parseDouble(jTextFieldPidk0.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "PID parameter: Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            robotInterf.setPidParams(K, Ti, Td, k0);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonSetPidParamsActionPerformed

    private void jTextFieldPidk0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPidk0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPidk0ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainForm(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGetStatus;
    private javax.swing.JButton buttonSetWheelMaxSpeed;
    private robot.ui.ImagePanel eyeDistImagePanel;
    private javax.swing.JPanel eyeDistPanel;
    private robot.ui.ImagePanel eyeLeftImagePanel;
    private robot.ui.ImagePanel eyeRightImagePanel;
    private javax.swing.JTextField fieldMaxSpeed;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonSetPidParams;
    private javax.swing.JCheckBox jCheckBoxAutomaticUpdateStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPidK;
    private javax.swing.JTextField jTextFieldPidTd;
    private javax.swing.JTextField jTextFieldPidTi;
    private javax.swing.JTextField jTextFieldPidk0;
    private javax.swing.JPanel leftEyePanel;
    private robot.ui.Navigator navigator;
    private javax.swing.JPanel rightEyePanel;
    private javax.swing.JTextArea textAreaStatus;
    // End of variables declaration//GEN-END:variables
}

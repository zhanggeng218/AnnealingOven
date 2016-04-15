/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annealingoven;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Gabriel
 */
@SuppressWarnings("serial")
public class StatusFrame extends JFrame {

	// Variables declaration
    private JPanel currentTPanel;
    private JTextField currentTTextField;
    private JProgressBar step1ProgressBar;
    private JLabel step1endTLabel;
    private JLabel step1startTLabel;
    private JProgressBar step2ProgressBar;
    private JLabel step2endTLabel;
    private JLabel step2startTLabel;
    private JProgressBar step3ProgressBar;
    private JLabel step3endTLabel;
    private JLabel step3startTLabel;
    private JProgressBar step4ProgressBar;
    private JLabel step4endTLabel;
    private JLabel step4startTLabel;
    private JProgressBar step5ProgressBar;
    private JLabel step5endTLabel;
    private JLabel step5startTLabel;
    private JProgressBar step6ProgressBar;
    private JLabel step6endTLabel;
    private JLabel step6startTLabel;
    private JProgressBar step7ProgressBar;
    private JLabel step7endTLabel;
    private JLabel step7startTLabel;
    private JProgressBar step8ProgressBar;
    private JLabel step8endTLabel;
    private JLabel step8startTLabel;
    private JToggleButton turnOffButton;
   
    private CycleTimer timer;
    public List<Part> list;
    public List<ProcessBar> processList;
	
    /**
     * Creates new form StatusFrame
     */
    public StatusFrame(List<Part> list) {
    	
    	this.list = list;
    	initComponents();
    	initprocessbar();
    	timer = new CycleTimer();
        timer.Tick();
    }

    /**Initialize the processBar*/
    private void initprocessbar() {
    	
    	processList = new ArrayList<ProcessBar>();
    	processList.add(new ProcessBar(step1startTLabel, step1endTLabel, step1ProgressBar));
    	processList.add(new ProcessBar(step2startTLabel, step2endTLabel, step2ProgressBar));
    	processList.add(new ProcessBar(step3startTLabel, step3endTLabel, step3ProgressBar));
    	processList.add(new ProcessBar(step4startTLabel, step4endTLabel, step4ProgressBar));
    	processList.add(new ProcessBar(step5startTLabel, step5endTLabel, step5ProgressBar));
    	processList.add(new ProcessBar(step6startTLabel, step6endTLabel, step6ProgressBar));
    	processList.add(new ProcessBar(step7startTLabel, step7endTLabel, step7ProgressBar));
    	processList.add(new ProcessBar(step8startTLabel, step8endTLabel, step8ProgressBar));
    	
    	for(int i = 0; i < processList.size(); i++) {
    		if (i < list.size()) {
    			processList.get(i).setProcessBar(list.get(i));
    		} else {
    			processList.get(i).setProcessBar();
    		}
    	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        currentTPanel = new JPanel();
        currentTTextField = new JTextField();
        step4startTLabel = new JLabel();
        step4ProgressBar = new JProgressBar();
        step4endTLabel = new JLabel();
        turnOffButton = new JToggleButton();
        step1startTLabel = new JLabel();
        step1ProgressBar = new JProgressBar();
        step1endTLabel = new JLabel();
        step2startTLabel = new JLabel();
        step2ProgressBar = new JProgressBar();
        step2endTLabel = new JLabel();
        step3startTLabel = new JLabel();
        step3ProgressBar = new JProgressBar();
        step3endTLabel = new JLabel();
        step5startTLabel = new JLabel();
        step5ProgressBar = new JProgressBar();
        step5endTLabel = new JLabel();
        step6startTLabel = new JLabel();
        step6ProgressBar = new JProgressBar();
        step6endTLabel = new JLabel();
        step7startTLabel = new JLabel();
        step7ProgressBar = new JProgressBar();
        step7endTLabel = new JLabel();
        step8startTLabel = new JLabel();
        step8ProgressBar = new JProgressBar();
        step8endTLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("StatusFrame");

        currentTPanel.setBorder(BorderFactory.createTitledBorder("Current Temperature"));

        currentTTextField.setFont(new Font("Estrangelo Edessa", 1, 48));
        currentTTextField.setHorizontalAlignment(JTextField.RIGHT);

        GroupLayout currentTPanelLayout = new GroupLayout(currentTPanel);
        currentTPanel.setLayout(currentTPanelLayout);
        currentTPanelLayout.setHorizontalGroup(
            currentTPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentTTextField)
        );
        currentTPanelLayout.setVerticalGroup(
            currentTPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(currentTPanelLayout.createSequentialGroup()
                .addComponent(currentTTextField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        turnOffButton.setForeground(new Color(102, 0, 102));
        turnOffButton.setSelected(true);
        turnOffButton.setText("TURN OFF");
        turnOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                turnOffButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentTPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(turnOffButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(step4startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step4ProgressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step4endTLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step1startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step1ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step1endTLabel))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(step2startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step2ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step2endTLabel))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(step3startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step3ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step3endTLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step5startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step5ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step5endTLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step6startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step6ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step6endTLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step7startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step7ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step7endTLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step8startTLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step8ProgressBar, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(step8endTLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentTPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step1endTLabel)
                        .addComponent(step1ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step1startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step2endTLabel)
                        .addComponent(step2ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step2startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step3endTLabel)
                        .addComponent(step3ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step3startTLabel))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step4endTLabel)
                        .addComponent(step4ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step4startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step5endTLabel)
                        .addComponent(step5ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step5startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step6endTLabel)
                        .addComponent(step6ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step6startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step7endTLabel)
                        .addComponent(step7ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step7startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(step8endTLabel)
                        .addComponent(step8ProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(step8startTLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(turnOffButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(483, 410));
        setLocationRelativeTo(null);
    }

    /**Turn off the running cycle*/
    private void turnOffButtonActionPerformed(ActionEvent evt) {
    	
        this.setVisible(false);
        timer.timer.cancel();
        new SelectFrame(list, false, timer.currentTemperature).setVisible(true);
    }
    
    /** A timer to simulate the running cycle*/
    class CycleTimer extends OvenTimer {
    	
    	public double startTemperature;
    	public double endTemperature;
    	public double targetTemperature;
    	public double tick;
    	public int index;
    	public int process;
    	
    	public CycleTimer() {
    		
    		super();
    		this.currentTemperature = list.get(0).startTemprature;
    		setCycle(list.get(index));
    	}
    	
    	/**Set start time, end time, and target temperature at first*/
    	public void setCycle(Part p) {
    		
    		startTemperature = p.startTemprature;
    		endTemperature = p.endTemprature;
    		tick = (endTemperature - startTemperature) / p.lengthOftime;
    		targetTemperature = startTemperature;
    	}
    	
    	public void Tick() {

    		timerTask = new TimerTask() {
    			@Override
    			public void run() {
    				//System.out.println(currentTemperature + " " + targetTemperature + " " + (currentTemperature - targetTemperature));
    				currentTTextField.setText(getCurrentTemperature() + "F");
    				if (currentTemperature == 0) { // the cycle is ending
    					StatusFrame.this.setVisible(false);
    					list.get(0).startTemprature = 0;
    					new SelectFrame(list, true, currentTemperature).setVisible(true);
    					this.cancel();
    				} else if (currentTemperature == endTemperature) { // One part of cycle is ending
    					if (index + 1 < list.size()) { // wrap a new line
    						index++;
    						process = 0;
        					setCycle(list.get(index));
    					} else { // If the end is not zero, stop here
    						this.cancel();
    					}
    				}
    				
    				if (currentTemperature < targetTemperature) { // Adjust current temperature according to target temperature
    					turnOn();
    				} else {
    					turnOff();
    				}
    				targetTemperature += tick; // update target temperature every minutes
    				processList.get(index).progressBar.setValue(process++); //update process bar every minutes
    			}
    		};
    		timer.schedule(timerTask, 0, 1000);
    	}
    }
}

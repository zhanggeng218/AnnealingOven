/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annealingoven;

import java.util.List;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Gabriel
 */
@SuppressWarnings("serial")
public class SelectFrame extends JFrame {

	// Variables declaration
    private JPanel buttonPanel;
    private JPanel currentTPanel;
    private JTextField currentTTextField;
    private JButton setCycleButton;
    private JButton startCycleButton;
    private JLabel startTLabel;
    private JTextField startTTextField;
    private JToggleButton turnOnOffButton;

    public boolean isButtonturnOn;
    public boolean isOventurnOn;
    public double currentTemperature;
    private TurnOnOffTimer timer;
    public List<Part> list;
	
    /**
     * Creates new form SelectFrame
     */
    public SelectFrame() {
    	
        initComponents();
        isButtonturnOn = false;
        isOventurnOn = false;
        currentTemperature = 0;
    }
    
    /**Initialize from two other interfaces*/
    public SelectFrame(List<Part> list, boolean isButtonturnOn, double currentTemperature) {
    	
    	initComponents();
    	this.list = list;
    	this.isButtonturnOn = isButtonturnOn;
    	double startT = list.get(0).startTemprature;
    	startTTextField.setText(startT + "F");
    	if (isButtonturnOn) {
    		turnOnOffButton.setSelected(true);
        	turnOnOffButton.setText("TURN OFF");
        	timer = new TurnOnOffTimer(currentTemperature, startT);
    	} else {
    		turnOnOffButton.setSelected(false);
        	turnOnOffButton.setText("TURN ON");
        	timer = new TurnOnOffTimer(currentTemperature, 0);
    	}
    	isOventurnOn = true;
    	timer.Tick();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        buttonPanel = new JPanel();
        turnOnOffButton = new JToggleButton();
        setCycleButton = new JButton();
        startTLabel = new JLabel();
        startTTextField = new JTextField();
        startCycleButton = new JButton();
        currentTPanel = new JPanel();
        currentTTextField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SelectFrame");

        turnOnOffButton.setBackground(new Color(204, 204, 204));
        turnOnOffButton.setForeground(new Color(102, 0, 255));
        turnOnOffButton.setText("TURN ON");
        turnOnOffButton.setToolTipText("");
        turnOnOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                turnOnOffButtonActionPerformed(evt);
            }
        });

        setCycleButton.setText("SET CYCLE");
        setCycleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setCycleButtonActionPerformed(evt);
            }
        });

        startTLabel.setText("Starting Temperature");
        startTLabel.setToolTipText("");

        startTTextField.setEditable(false);
        startTTextField.setText("0F");
        startTTextField.setBackground(new Color(255, 255, 255));
        startTTextField.setHorizontalAlignment(JTextField.RIGHT);
        startTTextField.setText("0F");

        startCycleButton.setForeground(new Color(0, 0, 255));
        startCycleButton.setText("START CYCLE");
        startCycleButton.setEnabled(false);
        startCycleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startCycleButtonActionPerformed(evt);
            }
        });

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(setCycleButton)
                .addGap(43, 43, 43)
                .addComponent(startCycleButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(turnOnOffButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(startTLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startTTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(turnOnOffButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(setCycleButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(startCycleButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        turnOnOffButton.getAccessibleContext().setAccessibleName("TURN ON\n");

        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        currentTPanel.setBorder(BorderFactory.createTitledBorder("Current Temperature"));

        currentTTextField.setEditable(false);
        currentTTextField.setText("0F");
        currentTTextField.setBackground(new Color(255, 255, 255));
        currentTTextField.setFont(new Font("Dotum", 1, 48)); 
        currentTTextField.setHorizontalAlignment(JTextField.RIGHT);

        GroupLayout currentTPanelLayout = new GroupLayout(currentTPanel);
        currentTPanel.setLayout(currentTPanelLayout);
        currentTPanelLayout.setHorizontalGroup(
            currentTPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentTTextField, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        currentTPanelLayout.setVerticalGroup(
            currentTPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(currentTPanelLayout.createSequentialGroup()
                .addComponent(currentTTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(currentTPanel, BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }

    /**Turn On or Off button*/
    private void turnOnOffButtonActionPerformed(ActionEvent evt) {
    	
        if (turnOnOffButton.isSelected()) {
            turnOnOffButton.setText("TURN OFF");
            isButtonturnOn = true;
            if (!isOventurnOn) {
            	timer = new TurnOnOffTimer(currentTemperature, Double.parseDouble(startTTextField.getText().substring(0, startTTextField.getText().length() - 1)));
                timer.Tick();
                isOventurnOn = true;
            } else {
            	timer.goalTemperature = Double.parseDouble(startTTextField.getText().substring(0, startTTextField.getText().length() - 1));
            }
        } else {
            turnOnOffButton.setText("TURN ON");
            isButtonturnOn = false;
            timer.goalTemperature = 0;
        }
    }

    /**The button to select a Cycle*/
    private void setCycleButtonActionPerformed(ActionEvent evt) {
       
        this.setVisible(false);
        if (isOventurnOn) {
        	isOventurnOn = false;
        	timer.timer.cancel();
        }
        new OperationFrame(isButtonturnOn, currentTemperature).setVisible(true);
    }

    /** The button to start a Cycle*/
    private void startCycleButtonActionPerformed(ActionEvent evt) {
        
        this.setVisible(false);
        timer.timer.cancel();
        new StatusFrame(list).setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectFrame().setVisible(true);
            }
        });
    }

    /**Turn on or off the timer to simulate the Oven of increase speed is 2/min and decrease speed is 1/min.*/
    class TurnOnOffTimer extends OvenTimer {
	
		public double goalTemperature;
		
		/**Set the current temperature and goal temperature*/
		public TurnOnOffTimer(double currentTemperature, double goalTemperature) {
			
			super();
			this.currentTemperature = currentTemperature;
			this.goalTemperature = goalTemperature;
		}
		
		public void Tick() {
	
			timerTask = new TimerTask() {
	
				@Override
				public void run() {//System.out.println(currentTemperature);
				
					SelectFrame.this.currentTemperature = currentTemperature;
					currentTTextField.setText(currentTemperature + "F");
					startCycleButton.setEnabled(false);
					/*Adjust current temperature according to the goal temperature */
					if (currentTemperature < goalTemperature) {
						turnOn();
					} else if (currentTemperature > goalTemperature) {
						turnOff();
					} else if (currentTemperature == 0) {//If current temperature is zero, terminate the timer
						isOventurnOn = false;
						timer.cancel();
					} else { //If current temperature holds and is not zero, enable the start cycle button to start the cycle
                        startCycleButton.setEnabled(true);
                    }
				}
			};
			timer.schedule(timerTask, 0, 1000);
		}
    }
}


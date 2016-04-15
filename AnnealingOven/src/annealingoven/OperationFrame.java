/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annealingoven;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Gabriel
 */
@SuppressWarnings("serial")
public class OperationFrame extends JFrame {

	// Variables declaration
    private JList<String> cycleList;
    private JScrollPane cycleScrollPane;
    private JButton deleteButton;
    private JLabel endTLabel;
    private JButton newButton;
    private JPanel operatePanel;
    private JButton saveButton;
    private JButton selectButton;
    private JPanel setPanel;
    private JLabel startTLabel;
    private JTextField step1EndTTextField;
    private JLabel step1Label;
    private JTextField step1StartTTextField;
    private JTextField step1TimeTextField;
    private JTextField step2EndTTextField;
    private JLabel step2Label;
    private JTextField step2StartTTextField;
    private JTextField step2TimeTextField;
    private JTextField step3EndTTextField;
    private JLabel step3Label;
    private JTextField step3StartTTextField;
    private JTextField step3TimeTextField;
    private JTextField step4EndTTextField;
    private JLabel step4Label;
    private JTextField step4StartTTextField;
    private JTextField step4TimeTextField;
    private JTextField step5EndTTextField;
    private JLabel step5Label;
    private JTextField step5StartTTextField;
    private JTextField step5TimeTextField;
    private JTextField step6EndTTextField;
    private JLabel step6Label;
    private JTextField step6StartTTextField;
    private JTextField step6TimeTextField;
    private JTextField step7EndTTextField;
    private JLabel step7Label;
    private JTextField step7StartTTextField;
    private JTextField step7TimeTextField;
    private JTextField step8EndTTextField;
    private JLabel step8Label;
    private JTextField step8StartTTextField;
    private JTextField step8TimeTextField;
    private JLabel timeinHoursLabel;

    public List<Part> list;
    public List<List<Part>> cycles;
    public List<JTextField> textList;
    public boolean isturnOff;
    public double currentTemperature;
    public int row;
    
    /**
     * Creates new form OperationFrame
     */
    public OperationFrame() {
    	
        initComponents();
        initOperations();
    }
    
    public OperationFrame(boolean isturnOff, double currentTemperature) {
    	
    	this();
    	this.isturnOff = isturnOff;
    	this.currentTemperature = currentTemperature;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        cycleScrollPane = new JScrollPane();
        cycleList = new JList<String>();
        operatePanel = new JPanel();
        setPanel = new JPanel();
        step1Label = new JLabel();
        step1StartTTextField = new JTextField();
        step1EndTTextField = new JTextField();
        startTLabel = new JLabel();
        endTLabel = new JLabel();
        step2Label = new JLabel();
        step2StartTTextField = new JTextField();
        step2EndTTextField = new JTextField();
        step3Label = new JLabel();
        step3StartTTextField = new JTextField();
        step3EndTTextField = new JTextField();
        step4Label = new JLabel();
        step4StartTTextField = new JTextField();
        step4EndTTextField = new JTextField();
        step5Label = new JLabel();
        step5StartTTextField = new JTextField();
        step5EndTTextField = new JTextField();
        step6Label = new JLabel();
        step6StartTTextField = new JTextField();
        step6EndTTextField = new JTextField();
        step7Label = new JLabel();
        step7StartTTextField = new JTextField();
        step7EndTTextField = new JTextField();
        step8Label = new JLabel();
        step8StartTTextField = new JTextField();
        step8EndTTextField = new JTextField();
        step1TimeTextField = new JTextField();
        step2TimeTextField = new JTextField();
        step3TimeTextField = new JTextField();
        step4TimeTextField = new JTextField();
        step5TimeTextField = new JTextField();
        step6TimeTextField = new JTextField();
        step7TimeTextField = new JTextField();
        step8TimeTextField = new JTextField();
        timeinHoursLabel = new JLabel();
        newButton = new JButton();
        saveButton = new JButton();
        deleteButton = new JButton();
        selectButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("OperationFrame");

        cycleList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cycleListMouseClicked(evt);
            }
        });
        cycleScrollPane.setViewportView(cycleList);

        getContentPane().add(cycleScrollPane, BorderLayout.CENTER);

        setPanel.setBorder(BorderFactory.createTitledBorder("Cycle"));
        setPanel.setToolTipText("");

        startTLabel.setText("Starting Temperature");
        endTLabel.setText("Ending Temperature");
        timeinHoursLabel.setText("Time in Hours");
        
        step1Label.setText("Step1");
        step1StartTTextField.setDocument(new JTextFieldLimit(4));
        step1EndTTextField.setDocument(new JTextFieldLimit(4));

        step2Label.setText("Step2");
        step2StartTTextField.setEditable(false);
        step2StartTTextField.setBackground(new Color(255, 255, 255));
        step2EndTTextField.setDocument(new JTextFieldLimit(4));

        step3Label.setText("Step3");
        step3StartTTextField.setEditable(false);
        step3StartTTextField.setBackground(new Color(255, 255, 255));
        step3EndTTextField.setDocument(new JTextFieldLimit(4));
   
        step4Label.setText("Step4");
        step4StartTTextField.setEditable(false);
        step4StartTTextField.setBackground(new Color(255, 255, 255));
        step4EndTTextField.setDocument(new JTextFieldLimit(4));
   
        step5Label.setText("Step5");
        step5StartTTextField.setEditable(false);
        step5StartTTextField.setBackground(new Color(255, 255, 255));
        step5EndTTextField.setDocument(new JTextFieldLimit(4));
  
        step6Label.setText("Step6");
        step6StartTTextField.setEditable(false);
        step6StartTTextField.setBackground(new Color(255, 255, 255));
        step6EndTTextField.setDocument(new JTextFieldLimit(4));
  
        step7Label.setText("Step7");
        step7StartTTextField.setEditable(false);
        step7StartTTextField.setBackground(new Color(255, 255, 255));
        step7EndTTextField.setDocument(new JTextFieldLimit(4));

        step8Label.setText("Step8");
        step8StartTTextField.setEditable(false);
        step8StartTTextField.setBackground(new Color(255, 255, 255));
        step8EndTTextField.setDocument(new JTextFieldLimit(4));

        step1TimeTextField.setDocument(new JTextFieldLimit(5));
        step2TimeTextField.setDocument(new JTextFieldLimit(5));
        step3TimeTextField.setDocument(new JTextFieldLimit(5));
        step4TimeTextField.setDocument(new JTextFieldLimit(5));
        step5TimeTextField.setDocument(new JTextFieldLimit(5));
        step6TimeTextField.setDocument(new JTextFieldLimit(5));
        step7TimeTextField.setDocument(new JTextFieldLimit(5));
        step8TimeTextField.setDocument(new JTextFieldLimit(5));

        GroupLayout setPanelLayout = new GroupLayout(setPanel);
        setPanel.setLayout(setPanelLayout);
        setPanelLayout.setHorizontalGroup(
            setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(step1Label)
                                .addGap(18, 18, 18)
                                .addComponent(step1StartTTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addComponent(startTLabel))
                        .addGap(18, 18, 18)
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(endTLabel)
                            .addComponent(step1EndTTextField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addComponent(step2Label)
                        .addGap(18, 18, 18)
                        .addComponent(step2StartTTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(step2EndTTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, setPanelLayout.createSequentialGroup()
                                .addComponent(step6Label)
                                .addGap(18, 18, 18)
                                .addComponent(step6StartTTextField))
                            .addGroup(GroupLayout.Alignment.LEADING, setPanelLayout.createSequentialGroup()
                                .addComponent(step5Label)
                                .addGap(18, 18, 18)
                                .addComponent(step5StartTTextField))
                            .addGroup(GroupLayout.Alignment.LEADING, setPanelLayout.createSequentialGroup()
                                .addComponent(step3Label)
                                .addGap(18, 18, 18)
                                .addComponent(step3StartTTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, setPanelLayout.createSequentialGroup()
                                .addComponent(step4Label)
                                .addGap(18, 18, 18)
                                .addComponent(step4StartTTextField)))
                        .addGap(18, 18, 18)
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(step4EndTTextField)
                            .addComponent(step3EndTTextField)
                            .addComponent(step5EndTTextField)
                            .addComponent(step6EndTTextField, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(step8Label)
                                .addGap(18, 18, 18)
                                .addComponent(step8StartTTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(step7Label)
                                .addGap(18, 18, 18)
                                .addComponent(step7StartTTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(step7EndTTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addComponent(step8EndTTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(step5TimeTextField, GroupLayout.Alignment.TRAILING)
                            .addComponent(step4TimeTextField, GroupLayout.Alignment.TRAILING)
                            .addComponent(step6TimeTextField)
                            .addComponent(step7TimeTextField)
                            .addComponent(step8TimeTextField)
                            .addComponent(step3TimeTextField)))
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(step2TimeTextField)
                            .addComponent(step1TimeTextField)
                            .addComponent(timeinHoursLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        setPanelLayout.setVerticalGroup(
            setPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTLabel)
                    .addComponent(endTLabel)
                    .addComponent(timeinHoursLabel))
                .addGap(7, 7, 7)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step1Label)
                    .addComponent(step1StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step1EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step1TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step2Label)
                    .addComponent(step2StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step2EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step2TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step3Label)
                    .addComponent(step3StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step3EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step3TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step4EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step4Label)
                    .addComponent(step4StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step4TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step5Label)
                    .addComponent(step5StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step5EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step5TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step6Label)
                    .addComponent(step6StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step6EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step6TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step7Label)
                    .addComponent(step7StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step7EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step7TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(step8Label)
                    .addComponent(step8StartTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step8EndTTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(step8TimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newButton.setText("NEW");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        saveButton.setText("SAVE");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setForeground(new Color(255, 0, 0));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        selectButton.setForeground(new Color(0, 51, 255));
        selectButton.setText("SELECT");
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        GroupLayout operatePanelLayout = new GroupLayout(operatePanel);
        operatePanel.setLayout(operatePanelLayout);
        operatePanelLayout.setHorizontalGroup(
            operatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatePanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(operatePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(operatePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(newButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(deleteButton)
                        .addGap(73, 73, 73)
                        .addComponent(selectButton))
                    .addComponent(setPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        operatePanelLayout.setVerticalGroup(
            operatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatePanelLayout.createSequentialGroup()
                .addComponent(setPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(operatePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(selectButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(operatePanel, BorderLayout.LINE_END);

        setSize(new Dimension(575, 376));
        setLocationRelativeTo(null);
    }

    /** Initialize the whole text fields*/
    public void initOperations() {
    	
    	cycles = new ReadWriteFile().readFromfile();
    	
    	textList = new ArrayList<JTextField>();
    	textList.add(step1StartTTextField);
    	textList.add(step1EndTTextField);
    	textList.add(step1TimeTextField);
    	textList.add(step2StartTTextField);
    	textList.add(step2EndTTextField);
    	textList.add(step2TimeTextField);
    	textList.add(step3StartTTextField);
    	textList.add(step3EndTTextField);
    	textList.add(step3TimeTextField);
    	textList.add(step4StartTTextField);
    	textList.add(step4EndTTextField);
    	textList.add(step4TimeTextField);
    	textList.add(step5StartTTextField);
    	textList.add(step5EndTTextField);
    	textList.add(step5TimeTextField);
    	textList.add(step6StartTTextField);
    	textList.add(step6EndTTextField);
    	textList.add(step6TimeTextField);
    	textList.add(step7StartTTextField);
    	textList.add(step7EndTTextField);
    	textList.add(step7TimeTextField);
    	textList.add(step8StartTTextField);
    	textList.add(step8EndTTextField);
    	textList.add(step8TimeTextField);
    	
    	listShow();
    	
    	for(int i = 0; i < textList.size(); i += 3) {
    		textList.get(i).addKeyListener(new TemperatureKeyAdapter(textList));
    		textList.get(i + 1).addKeyListener(new TemperatureKeyAdapter(textList));
    		textList.get(i + 2).addKeyListener(new TimeKeyAdapter());
    	}
    }
    
    /** Show the left list*/
	public void listShow() {
    	
    	cycleList.setModel(new AbstractListModel<String>() {

    		String[] ss;
    		
    		public void setString() {
    			ss = new String[cycles.size()];
    			for(int i = 0; i < ss.length; i++) {
    	        	ss[i] = "Cycle " + (int)(i + 1);
    	        }
    		}
    		    		
			@Override
			public String getElementAt(int i) {

				return ss[i];
			}

			@Override
			public int getSize() {
				
				setString();
				return ss.length;
			}
        });
    }
    
	/**select a cycle and jump next interface*/
    private void selectButtonActionPerformed(ActionEvent evt) {
        
    	SaveInList();
        this.setVisible(false);
        new SelectFrame(list, isturnOff, currentTemperature).setVisible(true);
    }

    /**save a the cycle in file*/
    private void saveButtonActionPerformed(ActionEvent evt) {
    	
    	SaveInList();
    	cycles.add(list);
    	new ReadWriteFile().writeTofile(cycles);
    	listShow();
    }

    /**Click a cycle in CycleList and show the details in TextFields*/
    private void cycleListMouseClicked(MouseEvent evt) {
        
    	row = cycleList.locationToIndex(evt.getPoint());
    	ClearTextFields();
    	int i = 0;
    	for(i = 0; i < cycles.get(row).size(); i++) {
    		textList.get(i * 3).setText((int)cycles.get(row).get(i).startTemprature + "");
    		textList.get(i * 3 + 1).setText((int)cycles.get(row).get(i).endTemprature + "");
    		int time = (int)cycles.get(row).get(i).lengthOftime;
    		int hour = time / 60;
    		int min = time % 60;
    		String minString = min + "";
    		if (minString.length() == 1) {
    			minString += "0";
    		}
    		textList.get(i * 3 + 2).setText(hour + ":" + minString);
    	}
    	textList.get(i * 3).setText((int)cycles.get(row).get(i - 1).endTemprature + "");
    }

    /**Remove selected Cycle*/
    private void deleteButtonActionPerformed(ActionEvent evt) {
       
        cycles.remove(row);
        new ReadWriteFile().writeTofile(cycles);
        ClearTextFields();
        listShow();
    }

    /**Create a new Cycle*/ 
    private void newButtonActionPerformed(ActionEvent evt) {
        
    	ClearTextFields();
    }
    
    /**Clear the whole text fields*/
    private void ClearTextFields() {
    	
    	for (JTextField t : textList) {
        	t.setText("");
        }
    }
    
    /**Save the current text fields in a new List*/
    private void SaveInList() {
    	
    	list = new ArrayList<Part>();
    	for(int i = 1; i < textList.size(); i += 3) {
    		if (!textList.get(i).getText().isEmpty()) {
    			String[] ss = textList.get(i + 1).getText().split(":");
    			list.add(new Part(textList.get(i - 1).getText(), textList.get(i).getText(), ss));
    		} else {
    			break;
    		}
    	}
    }
}

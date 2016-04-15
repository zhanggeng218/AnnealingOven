package annealingoven;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**A class to set ProcessBar in running cycle*/
public class ProcessBar {

    public JLabel startTLabel;
    public JLabel endTLabel;
    public JProgressBar progressBar;
	
    public ProcessBar(JLabel startTLabel, JLabel endTLabel, JProgressBar progressBar) {
		
	this.startTLabel = startTLabel;
	this.endTLabel = endTLabel;
	this.progressBar = progressBar;
    }
	
    public void setProcessBar(Part p) {
        
	startTLabel.setText(p.startTemprature + "F");
	endTLabel.setText(p.endTemprature + "F");
	progressBar.setMaximum((int)p.lengthOftime);
    }
	
    public void setProcessBar() {
        
	startTLabel.setText("0.0F");
	endTLabel.setText("0.0F");
	progressBar.setMaximum(100);
    }
}

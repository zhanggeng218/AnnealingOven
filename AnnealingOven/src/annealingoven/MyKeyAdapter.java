package annealingoven;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTextField;

public abstract class MyKeyAdapter extends KeyAdapter{
	
}

/**limit the pattern of input of temperature*/
class TemperatureKeyAdapter extends MyKeyAdapter {
    
    public List<JTextField> textList;	
    public TemperatureKeyAdapter(List<JTextField> textList) {
	
        this.textList = textList;
    }
	
    @Override
    public void keyReleased(KeyEvent evt) {
        JTextField text = (JTextField)evt.getSource();
	String s = text.getText();
	char c = s.charAt(s.length() - 1);
	int index = textList.indexOf(text);
	if (c < '0' || c > '9') {
            text.setText("");
	}
	if (index != 0) {
            JTextField textforCopy = textList.get(index + 2);
            textforCopy.setText(s);
	} 
    }
}

/**limit the pattern of input of length of time*/
class TimeKeyAdapter extends MyKeyAdapter {
	
    @Override
    public void keyReleased(KeyEvent evt) {
        
        JTextField text = (JTextField)evt.getSource();
	String s = text.getText();
	if (s.length() == 1) {
            if (s.charAt(0) < '0' || s.charAt(0) > '9') {
		text.setText("");
            }
	}
	if (s.length() == 3) {
            if (!(s.charAt(1) >= '0' && s.charAt(1) <= '9' && s.charAt(2) == ':' || s.charAt(1) == ':' && s.charAt(2) >= '0' && s.charAt(2) <= '9')) {
		text.setText("");
            }
        }
	if (s.length() > 3) {
            if (s.charAt(s.length() - 1) < '0' || s.charAt(s.length() - 1) > '9') {
		text.setText("");
            }
	}
    }
}

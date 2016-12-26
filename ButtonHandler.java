import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonHandler implements ActionListener {

	private JButton button;
	private JLabel label;

	
	public ButtonHandler(JButton button, JLabel label){
		this.button = button;
		this.label = label;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (label.getText().equalsIgnoreCase("It's Blacks turn")){
			label.setText("It's Whites turn");
		}else if (label.getText().equalsIgnoreCase("It's Whites turn")){
			label.setText("It's Blacks turn");
		}else{
			label.setText("It's Blacks turn");			
		}
		button.setEnabled(false);
	}

}

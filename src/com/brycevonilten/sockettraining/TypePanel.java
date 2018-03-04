package com.brycevonilten.sockettraining;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JPanel implements Serializable, for now suppress
@SuppressWarnings("serial")
public class TypePanel extends JPanel{
	private JPanel mainpanel;
	private JLabel label;
	private JTextField typeField;
	private String input = null;
	
	public TypePanel() {
		label = new JLabel("");
		typeField = new JTextField(12);
		
		typeField.addActionListener(new EnterActionListener());
		
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		
		mainpanel.add(typeField, BorderLayout.NORTH);
		mainpanel.add(label, BorderLayout.SOUTH);
		
		add(mainpanel);
	}
	
	public String getInput() {
		return input;
	}
	
	public void setInput(String userInput) {
		input = userInput;
	}
	public String getLabel() {
		return label.getText();
	}
	
	public void setLabel(String userInput) {
		label.setText(userInput);
	}
	
	public String getTextField() {
		return typeField.getText();
	}
	
	public void setTextField(String userInput) {
		typeField.setText(userInput);
	}
	
	private class EnterActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			setInput(typeField.getText());
			typeField.setText("");
		}
	}
}
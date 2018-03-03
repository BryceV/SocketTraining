package com.brycevonilten.sockettraining;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectPanel extends JPanel{
	private JPanel mainpanel, panel1, panel2;
	private JLabel ipMessage, portMessage;
	private JTextField ipField, portField;
	private JButton enterButton;
	private String ipAddress = null;
	private int portNum = 0;
	
	public ConnectPanel() {
		ipMessage = new JLabel("Enter the server ip: ");
		portMessage = new JLabel("Enter the server port: ");
		ipField = new JTextField(12);
		portField = new JTextField(4);
		enterButton = new JButton("Enter");
		
		enterButton.addActionListener(new EnterActionListener());
		
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		panel1.add(ipMessage);
		panel1.add(ipField);
		panel1.add(portMessage);
		panel1.add(portField);
		panel2.add(enterButton);
		
		mainpanel.add(panel1, BorderLayout.NORTH);
		mainpanel.add(panel2, BorderLayout.SOUTH);
		add(mainpanel);
	}
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ip) {
		this.ipAddress = ip;
	}

	public int getPortNum() {
		return portNum;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}

	private class EnterActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String input;
			
			setIpAddress(ipField.getText());
			input = portField.getText();
			setPortNum(Integer.parseInt(input));
		}
	}
}
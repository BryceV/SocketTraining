package com.brycevonilten.sockettraining;

import javax.swing.JFrame;

//JPanel implements Serializable, for now suppress
@SuppressWarnings("serial")
public class UIManager extends JFrame{
	JFrame window = new JFrame();
	ConnectPanel connectpanel;
	TypePanel typepanel;
	
	public UIManager(String section) {
		if (section.equals("connect")) {
			window.setTitle("Connect Information");
			window.setSize(500,120);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			connectpanel = new ConnectPanel();
			window.add(connectpanel);
			window.setVisible(true); 
		}
		else if (section.equals("type")) {
			window.setTitle("Echo box");
			window.setSize(500,120);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			typepanel = new TypePanel();
			window.add(typepanel);
			window.setVisible(true); 
		}
	}
}

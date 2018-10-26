package visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class SearchOptionsJDialog extends JDialog implements ActionListener{

	public static final String SEARCH = "Search";
	
	private MainWindow main;
	
	private JComboBox<String> optionsCB;
	private JTextField value;
	private JLabel valuelbl;
	private JButton search;
	private JLabel options;
	
	public SearchOptionsJDialog(MainWindow mw) {
		main = mw;
		
		setTitle("Search options");
		setLayout(new FlowLayout());
		
		String[] op = {"Blocks per match","Assists per match", "Points per match",
				"Rebounds per match", "Steals per match"};
		optionsCB = new JComboBox<String>(op);
		valuelbl = new JLabel("Set value");
		value = new JTextField();
		value.setPreferredSize(new Dimension(120,20));
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		options = new JLabel("Set search parameter:");
		
		search = new JButton(SEARCH);
		search.setActionCommand(SEARCH);
		search.addActionListener(this);
		
		add(options);
		add(optionsCB);
		add(valuelbl);
		add(value);
		add(search);
		
		pack();
	}
	
	public String getSelectedOption(){
		return optionsCB.getSelectedItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(SEARCH)) {
			main.searchPlayer(getSelectedOption(), value.getText());
			this.setVisible(false);
			main.enable();

		}
	}

}

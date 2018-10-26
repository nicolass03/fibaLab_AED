package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements ActionListener{

	public static final String ADD = "Add player";
	public static final String DELETE = "Delete player";
	public static final String SEARCH = "Search player";
	public static final String LOAD = "Load data";
	
	private JButton searchBt;
	private JButton addBt;
	private JButton deleteBt;
	private JButton loadBt;
	
	private MainWindow main;
	
	public OptionsPanel(MainWindow mw){
		main = mw;
		
		searchBt = new JButton(SEARCH);
		searchBt.setActionCommand(SEARCH);
		searchBt.addActionListener(this);
		searchBt.setEnabled(false);
		
		addBt = new JButton(ADD);
		addBt.setActionCommand(ADD);
		addBt.addActionListener(this);
		addBt.setEnabled(false);
		
		deleteBt = new JButton(DELETE);
		deleteBt.setActionCommand(DELETE);
		deleteBt.addActionListener(this);
		deleteBt.setEnabled(false);
		
		loadBt = new JButton(LOAD);
		loadBt.setActionCommand(LOAD);
		loadBt.addActionListener(this);
		
		add(loadBt);
		add(addBt);
		add(deleteBt);
		add(searchBt);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(SEARCH)){
			main.launchSearchJDialog();
		}
		else if(e.getActionCommand().equals(ADD)){
			
		}
		else if(e.getActionCommand().equals(DELETE)){
			
		}
		else if(e.getActionCommand().equals(LOAD)){
			main.loadData();
		}
	}

	public void enableButtons() {
		searchBt.setEnabled(true);
		deleteBt.setEnabled(true);
		addBt.setEnabled(true);
	}
}


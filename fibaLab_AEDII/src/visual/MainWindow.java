package visual;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dataStructures.Node;
import model.Main;

public class MainWindow extends JFrame{

	private AssistPerMatchPanel assistPanel;
	private BlocksPerMatchPanel blocksPanel;
	private OptionsPanel optionsPanel;
	private PointsPerMatchPanel pointsPanel;
	private ProfilePanel profilePanel;
	private ReboundsPerMatch reboundsPanel;
	private SearchOptionsJDialog soDialog;
	private JDialogSearchResults resultsDialog;
	private StealsPerMatchPanel stealsPanel;
	
	private Main model;

	public MainWindow() {
		setTitle("FIBA Players Management Software");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(680,480));

		model = new Main();
		
		optionsPanel = new OptionsPanel(this);
		profilePanel = new ProfilePanel(this);
		assistPanel = new AssistPerMatchPanel();
		blocksPanel = new BlocksPerMatchPanel();
		pointsPanel = new PointsPerMatchPanel();
		reboundsPanel = new ReboundsPerMatch();
		stealsPanel = new StealsPerMatchPanel();

		add(profilePanel);
		add(assistPanel);
		add(blocksPanel);
		add(pointsPanel);
		add(reboundsPanel);
		add(stealsPanel);
		add(optionsPanel);
		pack();
	}
	public static void main(String[] args) {
		MainWindow m = new MainWindow();
		m.setVisible(true);
	}

	public void launchSearchJDialog() {
		soDialog = new SearchOptionsJDialog(this);
		soDialog.setVisible(true);
		soDialog.setFocusable(true);
		soDialog.setFocusableWindowState(true);
		soDialog.setAlwaysOnTop(true);
		this.disable();
	}

	public void selectPlayer(int i) {
		Node sel = (Node) model.foundPlayers.get(i);
		String[] data = model.getPlayerData((String) sel.getValue());
		profilePanel.setData(data[2], data[3], data[1]);
		assistPanel.setData(data[model.INDEX_ASSIST]);
		blocksPanel.setData(data[model.INDEX_BLOCKS]);
		pointsPanel.setData(data[model.INDEX_POINTS]);
		reboundsPanel.setData(data[model.INDEX_REBOUNDS]);
		stealsPanel.setData(data[model.INDEX_STEALS]);
	}
	
	public void launchResultsJDialog(String selectedOption,String key) {
		
		String[] res = null;
		switch(selectedOption) {
		case "Rebounds per match":
			res = model.toArray(model.searchRebounds(Double.valueOf(key)));
			break;
			
		case "Assists per match":
			res = model.toArray(model.searchAssist(Double.valueOf(key)));
			break;
			
		case "Points per match":
			res = model.toArray(model.searchPoints(Double.valueOf(key)));
			break;

		case "Steals per match":
			res = model.toArray(model.searchSteals(Double.valueOf(key)));
			break;
		}
		resultsDialog = new JDialogSearchResults(this, res);
		resultsDialog.setVisible(true);
		resultsDialog.setFocusable(true);
		resultsDialog.setFocusableWindowState(true);
		resultsDialog.setAlwaysOnTop(true);
		this.disable();
	}

	public void searchPlayer(String selectedOption, String value) {
		soDialog.dispose();
		this.setAlwaysOnTop(true);
		launchResultsJDialog(selectedOption, value);
	}
	public void loadData() {
		JFileChooser fch = new JFileChooser("./");
		int returnValue = fch.showOpenDialog(this);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File f = fch.getSelectedFile();
			model.loadData(f);
			JOptionPane.showMessageDialog(this, "Data loaded successfully");
			String[] data = model.getPlayerData(((String) model.getRootSteals().raiz.getValue()));
			profilePanel.setData(data[2], data[3], data[1]);
			optionsPanel.enableButtons();
			profilePanel.setData(data[2], data[3], data[1]);
			assistPanel.setData(data[model.INDEX_ASSIST]);
			blocksPanel.setData(data[model.INDEX_BLOCKS]);
			pointsPanel.setData(data[model.INDEX_POINTS]);
			reboundsPanel.setData(data[model.INDEX_REBOUNDS]);
			stealsPanel.setData(data[model.INDEX_STEALS]);
		}
	}
	
	public void addPlayer() {
		
	}
}

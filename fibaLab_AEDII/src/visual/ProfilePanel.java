package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfilePanel extends JPanel{
	
	private JLabel nName;
	private JLabel name;
	private JLabel nAge;
	private JLabel age;
	private JLabel nTeam;
	private JLabel team;
	
	private MainWindow m;
	
	public ProfilePanel(MainWindow main) {
		m = main;
		
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createTitledBorder("Profile"));
		setPreferredSize(new Dimension(200,190));
		
		Font titles = new Font("Arial", Font.BOLD, 17);
		Font txt = new Font("Arial", Font.PLAIN, 12);

		name = new JLabel("Name");
		name.setPreferredSize(new Dimension(190,30));
		name.setFont(titles);
		nName = new JLabel("");
		nName.setPreferredSize(new Dimension(190,15));
		nName.setFont(txt);
		age = new JLabel("Age");
		age.setPreferredSize(new Dimension(190,30));
		age.setFont(titles);
		nAge = new JLabel("");
		nAge.setPreferredSize(new Dimension(190,15));
		nAge.setFont(txt);
		team = new JLabel("Team");
		team.setPreferredSize(new Dimension(190,30));
		team.setFont(titles);
		nTeam = new JLabel("");
		nTeam.setPreferredSize(new Dimension(190,15));
		nTeam.setFont(txt);
		
		add(name);
		add(nName);
		add(age);
		add(nAge);
		add(team);
		add(nTeam);

	}
	
	public void setData(String name, String age, String team) {
		nName.setText(name);
		nAge.setText(age);
		nTeam.setText(team);
	}
	
}

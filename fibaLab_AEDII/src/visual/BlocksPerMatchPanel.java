package visual;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlocksPerMatchPanel extends JPanel{

	private JLabel lbl;
	
	public BlocksPerMatchPanel(){
		setPreferredSize(new Dimension(200,190));
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createTitledBorder("Blocks"));
		
		Font titles = new Font("Arial", Font.BOLD, 100);
		
		lbl = new JLabel("");
		lbl.setFont(titles);
		
		add(lbl);
	}
	
	public void setData(String s) {
		lbl.setText(s);
	}
}

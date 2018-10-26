package visual;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogSearchResults extends JDialog implements ActionListener, ListSelectionListener {

	public static final String SELECT = "s";
	
    private JList<String> list;

    private JButton select;
    
    private MainWindow main;

    public JDialogSearchResults(MainWindow m, String[] s){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(200,400));
        setResizable(false);
        select = new JButton("Select");
        main = m;
        
        list = new JList<String>(s);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.addListSelectionListener(this);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(190,330));
        
        select = new JButton("Select");
        select.addActionListener(this);
        select.setActionCommand(SELECT);
        
        add(listScroller);
        add(select);
        pack();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals(SELECT)) {
    		main.selectPlayer(list.getSelectedIndex());
    	}
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting() == false){
            if(list.getSelectedIndex() == -1){
                select.setEnabled(false);
            }
            else{
                select.setEnabled(true);
            }
        }
    }
}

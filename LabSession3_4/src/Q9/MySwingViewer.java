package Q9;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class MySwingViewer extends  JFrame {
	public JTextArea txtArea ;
    public MySwingViewer() 
    { 
        setSize(740, 200); 
        setResizable(false);
        
        setTitle("Hello Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
        CtlPanel ctlP = new CtlPanel(this);
        
        txtArea = new JTextArea("JTextArea",20,49);
        txtArea.setFont(txtArea.getFont().deriveFont(16.0f));
        txtArea.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(txtArea);
        
        
        
        
        add(BorderLayout.WEST, jsp);
        add(BorderLayout.EAST, ctlP);
    }
    public static void main(String[] args) {
    	MySwingViewer viewer = new MySwingViewer();
    	viewer.setVisible(true);
    }

}

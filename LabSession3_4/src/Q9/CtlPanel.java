package Q9;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.io.InputStreamReader;


import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CtlPanel extends JPanel {

	JRadioButton rBox1,rBox2,rBox3;
    ButtonGroup bGroup;
    JButton bExit;
    CtlPanel(MySwingViewer parent){
    	
        setLayout(new GridLayout(5,1));
        
        
        rBox1 = new JRadioButton("Kiwi",false);
        rBox2 = new JRadioButton("Penguin",false);
        rBox3 = new JRadioButton("Dorphin",false);
        

        rBox1.setFont(rBox1.getFont().deriveFont(18.0f)); 
        rBox2.setFont(rBox1.getFont().deriveFont(18.0f)); 
        rBox3.setFont(rBox1.getFont().deriveFont(18.0f)); 
        
        
        bExit = new JButton("Exit");
        bExit.setPreferredSize( new Dimension(80,40));
        
        bGroup = new ButtonGroup();
        bGroup.add(rBox1);
        bGroup.add(rBox2);
        bGroup.add(rBox3);
        
        add(rBox1);
        add(rBox2);
        add(rBox3);
        add(bExit);
        
        bExit.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				
 				parent.dispose();
 				
 			}
 			
 		});
        
        // kiwi radiobox listener
        rBox1.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				
 				
 				try {
 					
					parent.txtArea.read(new InputStreamReader(
		                    getClass().getResourceAsStream("kiwi.txt")),
		                    null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	
 			}
 			
 		});
        
     // penguin radiobox listener
        rBox2.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				
 				
 				try {
 					
					parent.txtArea.read(new InputStreamReader(
		                    getClass().getResourceAsStream("penguin.txt")),
		                    null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	
 			}
 			
 		});
        
     // Dolphin radiobox listener
        rBox3.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				
 				
 				try {
 					
					parent.txtArea.read(new InputStreamReader(
		                    getClass().getResourceAsStream("dorphin.txt")),
		                    null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	
 			}
 			
 		});
       
      
    }
}

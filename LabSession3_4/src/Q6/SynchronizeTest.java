package Q6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class SynchronizeTest {
	public static void main(String[] args) {
		
	JFrame fr = new JFrame("FlowLayout");
	JButton b1 = new JButton("No Synchronise");
	JButton b2 = new JButton("Synchronise");
	

	
	
	
	fr.setLayout(new FlowLayout());
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
	fr.add(b1);
	fr.add(b2);
	
	
	
	
	fr.setSize(430, 150);
	fr.setVisible(true);
	
	b1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent event) {
					PrintMessage shared=new PrintMessage();
					NoSynThread t1= new NoSynThread("9999999999999999999999999999999999",shared);
					NoSynThread t2= new NoSynThread("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",shared);
					NoSynThread t3= new NoSynThread("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK",shared);
					
					
						t1.start();
						t2.start();
						t3.start();
					

			}
			
		});
	b2.addActionListener(new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent event) {
				PrintMessage shared=new PrintMessage();;
				SynThread t1= new SynThread("9999999999999999999999999999999999",shared);
				SynThread t2= new SynThread("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",shared);
				SynThread t3= new SynThread("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK",shared);
				
				
					t1.start();
					t2.start();
					t3.start();
				

		}
		
	});
	
	}
}

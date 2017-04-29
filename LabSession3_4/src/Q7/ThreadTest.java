package Q7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class ThreadTest {
	static MyThread mythread=null;
	public static void main(String[] args) {
		JFrame fr = new JFrame("FlowLayout");
		JButton b1 = new JButton("Start Again");
		JButton b2 = new JButton("Enter Dead State");
		JButton b3 = new JButton("Dead state Restart");
		JButton b4 = new JButton("Graceful Stop");
		JLabel lb = new JLabel("thread");
		
		final boolean  threadRun = true;
		
		
		fr.setLayout(new FlowLayout());
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
		fr.add(b4);
		fr.add(lb);
		
		mythread  = new MyThread(lb);
		
		
		mythread.start();
		
		fr.setSize(430, 150);
		fr.setVisible(true);
		
		b1.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 			
 					mythread.start();
	
 			}
 			
 		});
		
		b2.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 			
 				mythread.enterDeadState();
	
 			}
 			
 		});
		
		b3.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 			
 				mythread.start();
	
 			}
 			
 		});
		
		b4.addActionListener(new ActionListener()
 		{
 			
 			@Override
 			public void actionPerformed(ActionEvent event) {
 			
 				mythread.stopGraceful();
 				try {
					mythread.join(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 					
 			}
 			
 		});
	}
}

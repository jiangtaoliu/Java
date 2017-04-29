package Q7;

import java.util.Date;

import javax.swing.JLabel;

public class MyThread extends Thread {

	private boolean run = true;
	private JLabel myJl = null;
	
	//MyThread self = null;
	public void stopGraceful()
	{
		//self = null;
		run = false;
	}
	public void enterDeadState()
	{
		//self = null;
		run = false;
	}
	public MyThread(JLabel jl)
	{
		myJl = jl;
		//self = this;
	}
	public void run()
	{
		while(run)
		{
			Date date = new Date();
			myJl.setText(date.toString());
		}
	}
}

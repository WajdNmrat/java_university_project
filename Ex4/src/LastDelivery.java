import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

public class LastDelivery extends JFrame implements ActionListener {
	public LastDelivery() {
	}
	

	private JPanel contentPane;
	private JTextField textField;
	public double helpid;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "There is not Delivery of this id" , false);
	Choice choicein = new Choice();
	public String in="";
	 public int helpid2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void  LastDelivery() {
		jd.getContentPane().add( new JLabel ("There is not Delivery of this id - show  is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		choicein.setBounds(110, 81, 200, 100);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Details of Last orders");
		lblNewLabel.setBounds(274, 11, 133, 24);
		JLabel lblNewLabel_1 = new JLabel("Choose order");
		lblNewLabel_1.setBounds(117, 56, 94, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(110, 152, 89, 23);
		getContentPane().add(btnNewButton);
		
		for(Map.Entry<Members,NormalDelivery> r:DataBase.ourLastDeliveries.entrySet())
		{
			choicein.add(r.getKey().getMembername()+"--"+"Delivery id ="+(int)r.getValue().getId());
		}
		getContentPane().add(choicein);
		JButton btnNewButton_1 = new JButton("Return to choose page");
		btnNewButton_1.setBounds(328, 150, 185, 23);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(choicein.getSelectedItem()!=null)
		{
		 in=choicein.getSelectedItem();
		  double helpid2=Character.getNumericValue(in.charAt(in.length()-1));
		}
		else 
		{
			 this.setVisible(false);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage();
		}
	String arg = ev.getActionCommand();
	Manager d=null;
	int flag=0;
	if(arg.equals("Finish"))
	{
		for(Map.Entry<Members,NormalDelivery> r:DataBase.ourLastDeliveries.entrySet())
		{
			if(r.getValue().getId()==helpid2)
			{
				helpid=r.getKey().getId();
				flag=1;
			}
		}
		for(Manager M: DataBase.managerarr)
		{
			for(Map.Entry<Integer,Members> r:M.arrmember.entrySet())
			{
	 			if(r.getKey()==helpid)
	 			{
	 				d=M;
	 			}
	 		}
		}
		for(Map.Entry<Members,NormalDelivery> r:DataBase.ourLastDeliveries.entrySet())
		{
			if(r.getValue().getId()==helpid2)
			{
				TextArea textArea = new TextArea();
				textArea.setBounds(289, 60, 380, 335);
				textArea.setText(d.toString()+r.getKey().toString()+r.getValue().toString());
				getContentPane().add(textArea);
				this.setVisible(true);
				
			}
		}
		if(flag==0)
		{
			 jd.setVisible(true);
				this.setVisible(false);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage();
		}
		
	}
	if(arg.equals("Return to choose page"))
	{
		 this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
	}
     }
}

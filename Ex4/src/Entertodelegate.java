import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Entertodelegate extends JFrame implements ActionListener {
	public Entertodelegate() {
	}
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static int countdelegatemanager=0;
    public static  ArrayList<Integer> delegatedelete =new ArrayList<Integer>();
    protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "Wrong data", false);
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public void  Entertodelegate() {
		jd.getContentPane().add( new JLabel ("Wrong data Enter is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter to delegate manager area ");
		lblNewLabel.setBounds(206, 55, 239, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delegate manager name");
		lblNewLabel_1.setBounds(88, 104, 186, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(284, 101, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Delegate Manager password");
		lblNewLabel_1_1.setBounds(88, 142, 186, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 139, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add short delivery");
		btnNewButton.setBounds(65, 201, 138, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enter to delegate page");
		btnNewButton_1.setBounds(320, 201, 162, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("What you want to do with this manager :");
		lblNewLabel_2.setBounds(65, 167, 286, 30);
		contentPane.add(lblNewLabel_2);
		countdelegatemanager=0;
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	try 
	{
		int i=Integer.parseInt(textField_1.getText());
	}
	catch (NumberFormatException n) {
	     System.out.println("wrong input .Please enter a number.");
			this.setVisible(false);
			jd.setVisible(true);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
	}
	if(textField.getText()!=""&&textField_1.getText()!="")
	{
	if(arg.equals("Add short delivery"))
	{
		int flag=0;
		for(Managerdelegate M: DataBase.delegatemanagerarr)
		{
			countdelegatemanager=countdelegatemanager+1;
			if(M.getPassword()==Integer.parseInt(textField_1.getText()))
			{
				delegatedelete.add(countdelegatemanager);
				flag=1;
				Entertodelegatepage test1=new Entertodelegatepage();
				this.setVisible(false);
				test1.setVisible(true);
				test1.AddShortDelivery();
			
			}
		}
		if (flag==0)
		{
			jd.setVisible(true);
			this.setVisible(false);
			Entertodelegate test2=new Entertodelegate();
			test2.setVisible(true);
			test2.Entertodelegate();
		}
	}
	if(arg.equals("Enter to delegate page"))
	{
		int flag=0;
		for(Managerdelegate M: DataBase.delegatemanagerarr)
		{
			countdelegatemanager=countdelegatemanager+1;
			if(M.getPassword()==Integer.parseInt(textField_1.getText()))
			{
				delegatedelete.add(countdelegatemanager);
				flag=1;
				Enterpagedelegate test1=new Enterpagedelegate();
				this.setVisible(false);
				test1.setVisible(true);
				test1.Enterpagedelegate();
			
			}
		}
		if (flag==0)
		{
			jd.setVisible(true);
			this.setVisible(false);
			Entertodelegate test2=new Entertodelegate();
			test2.setVisible(true);
			test2.Entertodelegate();
		}
	}
	}
	else
	{
		this.setVisible(false);
		jd.setVisible(true);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	}
     }
}

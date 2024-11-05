import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;

public class Enterpage extends JFrame implements ActionListener {
	public Enterpage() {
	}
	
	
    public static ArrayList<Integer> savemanagerid=new ArrayList<Integer>();
	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public static int count=0;
	protected JFrame frame2= new JFrame();
	public static int flag=0;
	protected JDialog jd = new JDialog(frame2 , "Manager password is worng", false);
	public static  ArrayList<Manager> managerarr;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	    public void Enterpage() {
	    	jd.getContentPane().add( new JLabel ("Manager password is worng Enter is not succeded...")); 
			jd.getContentPane().setLayout( new FlowLayout() ); 
			jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EnterPage");
		lblNewLabel.setBounds(252, 31, 125, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manager name:");
		lblNewLabel_1.setBounds(152, 93, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("password");
		lblNewLabel_1_1.setBounds(152, 130, 113, 14);
		contentPane.add(lblNewLabel_1_1);
		textField = new JTextField();
		textField.setBounds(275, 90, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 127, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		Button button = new Button("Ok");
		button.setBounds(186, 162, 217, 50);
		contentPane.add(button);
		count=0;
		button.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	
	if(arg.equals("Ok"))
	{
		try 
		{
			int i=Integer.parseInt(textField_1.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
		     jd.setVisible(true);
				this.setVisible(false);
				Enterpage test2=new Enterpage();
				test2.setVisible(true);
				test2.Enterpage();
		}
		if(textField.getText()!="")
		{
		for(Manager M: DataBase.managerarr)
		{
			count=count+1;
			if(M.getPassword()==Integer.parseInt(textField_1.getText()))
			{
				savemanagerid.add(M.getPassword());
				Choosepage test1=new Choosepage();
				this.setVisible(false);
				test1.setVisible(true);
				test1.Choosepage();
				jd.setVisible(false);
				flag=1;
			}
		}
		}
		if(flag==0)
		{
			
			jd.setVisible(true);
			this.setVisible(false);
			Enterpage test2=new Enterpage();
			test2.setVisible(true);
			test2.Enterpage();
		}
		
		
	}
     }
}

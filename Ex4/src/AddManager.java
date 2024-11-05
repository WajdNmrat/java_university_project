import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;


public class AddManager extends JFrame implements ActionListener {
	public AddManager() {
	}
	
	
	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "one of the data is wrong  add is not succeded", false);
	
    
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void  AddManager() {
		jd.getContentPane().add( new JLabel ("one of the data is wrong or you adding same password of manager > add is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(187, 40, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("manager area :");
		lblNewLabel.setBounds(59, 36, 118, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setBounds(59, 75, 118, 28);
		contentPane.add(lblPassword);
		
		JLabel lblManagerName = new JLabel("manager name :");
		lblManagerName.setBounds(59, 123, 118, 28);
		contentPane.add(lblManagerName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 81, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 127, 86, 20);
		contentPane.add(textField_2);
		
		lblNewLabel_1 = new JLabel("Adding a new manager");
		lblNewLabel_1.setBounds(262, 11, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(138, 172, 118, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Finish"))
	{
		try 
		{
			int i=Integer.parseInt(textField_1.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
				this.setVisible(false);
				jd.setVisible(true);
				AddManager test2=new AddManager();
				test2.setVisible(true);
				test2.AddManager();
		}
		if(((textField.getText().equals("north")||textField.getText().equals("south")||textField.getText().equals("center")))&&textField_2.getText()!=""&&DataBase.managerarr.size()<Integer.parseInt(textField_1.getText()))
		{
			Manager newmanager=new Manager(textField.getText(),Integer.parseInt(textField_1.getText()),textField_2.getText());
		DataBase.managerarr.add(newmanager);
		try(FileWriter f=new FileWriter("src\\Manager.txt",true);
		
            BufferedWriter b=new BufferedWriter(f);
			 PrintWriter pw=new PrintWriter(b);){
			 pw.println("1"+"--"+Integer.parseInt(textField_1.getText())+"--"+"Manager number="+Integer.toString(Enterpage.count+1)+"--"+"Manager area="+textField.getText()+"--"+"password="+Integer.parseInt(textField_1.getText())+"--"+"Manager name="+textField_2.getText()+"--");
			 
	 		System.out.println("Add is successed");
			}
			catch(Exception ex) {
				 ex.printStackTrace();	
			}
		jd.setVisible(false);
		}
	else
	{
		jd.setVisible(true);
		
	}
	this.setVisible(false);
	Choosepage test2=new Choosepage();
	test2.setVisible(true);
	test2.Choosepage();
}
		
	}
     }


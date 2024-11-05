import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class AddDelegateManager extends JFrame implements ActionListener {
	public AddDelegateManager() {
	}
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "one of the data is wrong  add is not succeded", false);
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void   AddDelegateManager() {
		jd.getContentPane().add( new JLabel ("one of the data is wrong or you adding same password of delegate manager add is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagerArea = new JLabel("manager area  :");
		lblManagerArea.setBounds(103, 92, 128, 28);
		contentPane.add(lblManagerArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(241, 96, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 146, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(241, 200, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(241, 252, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblPassword = new JLabel("password  :");
		lblPassword.setBounds(103, 142, 128, 28);
		contentPane.add(lblPassword);
		JLabel lblManagerName = new JLabel("manager name :");
		lblManagerName.setBounds(103, 196, 128, 28);
		contentPane.add(lblManagerName);
		
		JLabel lblDeliveryNum = new JLabel("delivery num :");
		lblDeliveryNum.setBounds(103, 248, 128, 28);
		contentPane.add(lblDeliveryNum);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(179, 297, 126, 23);
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
				AddDelegateManager test2=new AddDelegateManager();
				test2.setVisible(true);
				test2.AddDelegateManager();
		}
		try 
		{
			int i=Integer.parseInt(textField_3.getText());
		}
		catch (NumberFormatException n) {
			System.out.println("ssssssssssssssssssssssssssssssssssssssssss");
		     System.out.println("Please enter a number.");
		     this.setVisible(false);
		     jd.setVisible(true);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage ();
		}
		System.out.println(DataBase.delegatemanagerarr);
		if(((textField.getText().equals("north")||textField.getText().equals("south")||textField.getText().equals("center")))&&(textField_2.getText()!="")&&DataBase.delegatemanagerarr.size()<Integer.parseInt(textField_1.getText()))
		{
		Managerdelegate newmanagerdelegate=new Managerdelegate(textField.getText(),Integer.parseInt(textField_1.getText()),textField_2.getText(),Integer.parseInt(textField_3.getText()));
		DataBase.delegatemanagerarr.add(newmanagerdelegate);
		try(FileWriter f=new FileWriter("src\\Manager.txt",true);
				
	            BufferedWriter b=new BufferedWriter(f);
				 PrintWriter pw=new PrintWriter(b);){
				 pw.println("2"+"--"+Integer.toString(Enterpage.count)+"--"+Integer.parseInt(textField_1.getText())+"--"+"Manager delegate number="+Integer.toString(Enterpage.count)+"--"+"Manager delegate area="+textField.getText()+"--"+"Manager delegate password="+Integer.parseInt(textField_1.getText())+"--"+"Manager delegate name="+textField_2.getText()+"--"+"Manager delegate delivery num="+textField_3.getText()+"--");				 
		 		System.out.println("Add is successed");
				}
				catch(Exception ex) {
					 ex.printStackTrace();	
				}
		}
		else
		{
			jd.setVisible(true);
			this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
		}
		
		this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	}
	
	
     }
}

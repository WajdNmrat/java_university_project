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

public class AddMember extends JFrame implements ActionListener {
	public AddMember() {
	}
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , " add is not succeded", false);
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void AddMember() {
		jd.getContentPane().add( new JLabel ("member dont delow to this area or one of the data is wrong add is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberName_1 = new JLabel("member name  :");
		lblMemberName_1.setBounds(112, 105, 154, 28);
		contentPane.add(lblMemberName_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(276, 109, 86, 20);
		contentPane.add(textField);
		
		JLabel lblMemberFamily = new JLabel("member family  :");
		lblMemberFamily.setBounds(112, 160, 140, 28);
		contentPane.add(lblMemberFamily);
		
		JLabel lblMemberArea = new JLabel("member area  :");
		lblMemberArea.setBounds(112, 219, 140, 28);
		contentPane.add(lblMemberArea);
		
		JLabel lblMemberName = new JLabel("id :");
		lblMemberName.setBounds(123, 276, 117, 28);
		contentPane.add(lblMemberName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 164, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(276, 223, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(276, 280, 86, 20);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(176, 330, 117, 23);
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
			int i=Integer.parseInt(textField_3.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
				this.setVisible(false);
				jd.setVisible(true);
				AddMember test2=new AddMember();
				test2.setVisible(true);
				test2.AddMember();
		}
		System.out.println(Enterpage.count-1);
		if(DataBase.managerarr.get(Enterpage.count-1).getManagerarea().equals(textField_2.getText())&&textField.getText()!=""&&textField_1.getText()!=""&&((textField_2.getText().equals("north")||textField_2.getText().equals("south")||textField_2.getText().equals("center")))&&DataBase.managerarr.get(Enterpage.count-1).arrmember.size()<Integer.parseInt(textField_3.getText()))
		{
		Members newmember=new Members(textField.getText(),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_3.getText()));
		DataBase.managerarr.get(Enterpage.count-1).arrmember.put(DataBase.managerarr.get(Enterpage.count-1).arrmember.size()+1, newmember);
try(FileWriter f=new FileWriter("src\\Manager.txt",true);
				
	            BufferedWriter b=new BufferedWriter(f);
				 PrintWriter pw=new PrintWriter(b);){
				 pw.println("3"+"--"+Enterpage.count+"--"+Integer.parseInt(textField_3.getText())+"--"+"Manager number="+Integer.toString(Enterpage.count)+"--"+"Member name="+textField.getText()+"--"+"Member family="+textField_1.getText()+"--"+"Member area="+textField_2.getText()+"--"+"Member id="+Integer.parseInt(textField_3.getText())+"--");
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

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class AddnormalDelivery extends JFrame implements ActionListener {
	public AddnormalDelivery() {
	}
	
	
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	protected Choice countries= new Choice();
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , " add is not succeded", false);

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public  void  AddnormalDelivery() {
		jd.getContentPane().add( new JLabel ("you Enter this delivery before or one of the data is wrong >> add is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add normal delivery");
		lblNewLabel.setBounds(269, 36, 104, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("object name :");
		lblNewLabel_1.setBounds(90, 107, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(202, 104, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("id :");
		lblNewLabel_1_1.setBounds(90, 143, 74, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("price :");
		lblNewLabel_1_2.setBounds(90, 183, 86, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("quantity :");
		lblNewLabel_1_2_1.setBounds(90, 228, 104, 14);
		contentPane.add(lblNewLabel_1_2_1);
		JLabel lblNewLabel_1_2_4 = new JLabel("place of manufacture :");
		lblNewLabel_1_2_4.setBounds(309, 107, 170, 14);
		contentPane.add(lblNewLabel_1_2_4);
		JLabel lblNewLabel_1_2_5 = new JLabel("Delivery price :");
		lblNewLabel_1_2_5.setBounds(309, 143, 170, 14);
		contentPane.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("recipient name :");
		lblNewLabel_1_2_2.setBounds(309, 183, 170, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("recipient address :");
		lblNewLabel_1_2_3.setBounds(309, 228, 170, 14);
		contentPane.add(lblNewLabel_1_2_3);
		
		

		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 140, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 180, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(202, 225, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(486, 105, 86, 17);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(489, 140, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(489, 180, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(489, 225, 86, 20);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("recupient phone :");
		lblNewLabel_1_2_3_1.setBounds(145, 282, 137, 14);
		contentPane.add(lblNewLabel_1_2_3_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(292, 279, 86, 20);
		contentPane.add(textField_8);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(322, 350, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Id of wanter member :");
		lblNewLabel_2.setBounds(79, 317, 203, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(292, 314, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		lblNewLabel_1 = new JLabel("click to show members list:");
		lblNewLabel_1.setBounds(0, 333, 275, 14);
		contentPane.add(lblNewLabel_1);
		for(Manager M: DataBase.managerarr)
		{
			for(Map.Entry<Integer,Members>S: M.arrmember.entrySet())
			{
				countries.add(S.getValue().membername.concat(":"+Integer.toString(S.getKey())));
			}
		}
		countries.setBounds(0, 350, 275, 14);
		contentPane.add(countries);
		btnNewButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
		try 
		{
			int i=Integer.parseInt(textField_3.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
				this.setVisible(false);
				jd.setVisible(true);
				AddnormalDelivery test2=new AddnormalDelivery();
				test2.setVisible(true);
				test2.AddnormalDelivery();
		}
		try 
		{
			double i=Double.parseDouble(textField_1.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
		     this.setVisible(false);
				jd.setVisible(true);
				AddnormalDelivery test2=new AddnormalDelivery();
				test2.setVisible(true);
				test2.AddnormalDelivery();
		}
		try 
		{
			double i=Double.parseDouble(textField_2.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
		     this.setVisible(false);
				jd.setVisible(true);
				AddnormalDelivery test2=new AddnormalDelivery();
				test2.setVisible(true);
				test2.AddnormalDelivery();
		}
		try 
		{
			double i=Double.parseDouble(textField_5.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
		     this.setVisible(false);
				jd.setVisible(true);
				AddnormalDelivery test2=new AddnormalDelivery();
				test2.setVisible(true);
				test2.AddnormalDelivery();
		}
		try 
		{
			int i=Integer.parseInt(textField_9.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
		     this.setVisible(false);
				jd.setVisible(true);
				AddnormalDelivery test2=new AddnormalDelivery();
				test2.setVisible(true);
				test2.AddnormalDelivery();
		}
		Manager d=null;
		for(Map.Entry<Integer,Members> r:DataBase.managerarr.get(Enterpage.count-1).arrmember.entrySet())
		{
 			if(r.getKey()==Integer.parseInt(textField_9.getText()))
 			{
 				d=DataBase.managerarr.get(Enterpage.count-1);
 			}
 		}
	if(d==null)
	{
		jd.getContentPane().add( new JLabel ("member not found on this manager")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		jd.setVisible(true);
		this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	}
	else
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Finish"))
	{
		if(textField.getText()!=""&&textField_3.getText()!=""&&textField_4.getText()!=""&&textField_6.getText()!=""&&textField_7.getText()!=""&&textField_8.getText()!=""&&DataBase.managerarr.get(Enterpage.count-1).arrmember.get(Integer.parseInt(textField_9.getText())).arr.size()<Double.parseDouble(textField_1.getText()))
		{
		NormalDelivery newmanagerdelegate=new NormalDelivery(textField.getText(),Double.parseDouble(textField_1.getText()),Double.parseDouble(textField_2.getText()),textField_3.getText(),textField_4.getText(),Double.parseDouble(textField_5.getText()),textField_6.getText(),textField_7.getText(),textField_8.getText());
		DataBase.managerarr.get(Enterpage.count-1).arrmember.get(Integer.parseInt(textField_9.getText())).arr.add(newmanagerdelegate);
		
		DataBase.ourLastDeliveries.put(DataBase.managerarr.get(Enterpage.count-1).arrmember.get(Integer.parseInt(textField_9.getText())),newmanagerdelegate);
try(FileWriter f=new FileWriter("src\\Manager.txt",true);
				
	            BufferedWriter b=new BufferedWriter(f);
				 PrintWriter pw=new PrintWriter(b);){
				 pw.println("4"+"--"+Integer.toString(Enterpage.count)+"--"+Integer.parseInt(textField_9.getText())+"--"+Double.parseDouble(textField_1.getText())+"--"+"Manager number="+Integer.toString(Enterpage.count)+"--"+"Member number="+Integer.parseInt(textField_9.getText())+"--"+"Delivery Type="+"Normal Delivery"+"--"+"object name="+textField.getText()+"--"+"id="+Integer.parseInt(textField_1.getText())+"--"+"price="+Integer.parseInt(textField_2.getText())+"--"+"quantity="+textField_3.getText()+"--"+"place of manufacture="+textField_4.getText()+"--"+"Delivery price="+Integer.parseInt(textField_5.getText())+"--"+"recipient name="+textField_6.getText()+"--"+"recipient address="+textField_7.getText()+"--"+"recupient phone="+textField_8.getText()+"--");
		 		System.out.println("Add is successed");
				}
				catch(Exception ex) {
					 ex.printStackTrace();	
				}
		jd.setVisible(false);
		this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	}
		else
		{
			jd.setVisible(true);
			this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
			
		
	}
		}
	}
	}
}

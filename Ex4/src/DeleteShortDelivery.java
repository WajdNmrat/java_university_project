import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class DeleteShortDelivery extends JFrame implements ActionListener {
	public DeleteShortDelivery() {
	}

	private JPanel contentPane;
	private JTextField textField;
	  protected JFrame frame2= new JFrame();
		protected JDialog jd = new JDialog(frame2 , "Not found this short delivery", false);
		static int d=0;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void DeleteShortDelivery() {
		jd.getContentPane().add( new JLabel ("Not found this short delivery- Delete not succeded..")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete a short delivert");
		lblNewLabel.setBounds(242, 11, 154, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter short delivery id to deleting ");
		lblNewLabel_1.setBounds(119, 71, 215, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(329, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(245, 109, 117, 23);
		contentPane.add(btnNewButton);
	btnNewButton.addActionListener(this);
}
public void actionPerformed(ActionEvent ev)
{
String arg = ev.getActionCommand();
int countdelegate=0;
int countshort=0;
int save1=0;
int save2=0;
int flag=0;
if(arg.equals("Finish"))
{
	try 
	{
		int i=Integer.parseInt(textField.getText());
	}
	catch (NumberFormatException n) {
	     System.out.println("wrong input .Please enter a number.");
			this.setVisible(false);
			jd.setVisible(true);
			DeleteShortDelivery test2=new DeleteShortDelivery();
			test2.setVisible(true);
			test2.DeleteShortDelivery();
	}
	for(Managerdelegate M:DataBase.delegatemanagerarr)
	{
		countshort=0;
		countdelegate=countdelegate+1;
		for(Shortdeliveries S:M.arrdelegate)
		{
			
			countshort=countshort+1;
			if(S.getId()==Integer.parseInt(textField.getText()))
           {
				if((DataBase.managerarr.get(Enterpage.count-1).arrmember!=null)&&DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.shortmember.getId()).arr.size()!=0)
				{
				if(S.getId()==1)
				{
					DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.shortmember.getId()).arr.remove(DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.shortmember.getId()).arr.get(Integer.parseInt(textField.getText())-1));
				}
				else 
				{
				DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.shortmember.getId()).arr.remove(DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.shortmember.getId()).arr.get(Integer.parseInt(textField.getText())-1-d));
				}
				
				save1=countdelegate;
				save2=countshort;
				flag=1;
				d++;
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
	if (flag==1)
	{
	DataBase.delegatemanagerarr.get(save1-1).arrdelegate.remove(save2-1);
	try
	{
	 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
	 String s;
	 new FileOutputStream("src\\Helperfile.txt").close();
	 PrintWriter writer = new PrintWriter("src\\Helperfile.txt");
	 writer.print("");
	 writer.close();
 		while((s=br.readLine())!=null)
 		{
 			if((s.charAt(0)=='5'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&(String.valueOf(s.charAt(6)).equals(Integer.toString(save1)))&&String.valueOf(s.charAt(12)).equals(Integer.toString(Integer.parseInt(textField.getText())))))
 			{
 				System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
 			}
 			 else
	 			{
 				 System.out.println("111111111");
                       try(FileWriter f=new FileWriter("src\\Helperfile.txt",true);
	 						
	 			            BufferedWriter b=new BufferedWriter(f);
	 						 PrintWriter pw=new PrintWriter(b);){
                    	   
	 						 pw.println(s);
	 				 		System.out.println("Add is successed");
	 						}
	 						catch(Exception y) {
	 							 y.printStackTrace();	
	 						}
	 			}
 			
 		}
 	    
 		InputStream is = null;
 	    OutputStream os = null;
 	    try {
 	    
 	        is = new FileInputStream("src\\Helperfile.txt");
 	        os = new FileOutputStream("src\\Manager.txt");
 	        byte[] buffer = new byte[1024];
 	        int length;
 	        while ((length = is.read(buffer)) > 0) {
 	            os.write(buffer, 0, length);
 	        }
 	    } finally {
 	        is.close();
 	        os.close();
 	    }
 		br.close();
 		new FileOutputStream("src\\Helperfile.txt").close();
 	    
	}
	catch(Exception z){
		return;
	}
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

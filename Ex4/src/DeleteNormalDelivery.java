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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class DeleteNormalDelivery extends JFrame implements ActionListener {
	public DeleteNormalDelivery() {
	}
	

	private JPanel contentPane;
	private JTextField textField;
	  protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "Not found this Normal Delivery", false);

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void DeleteNormalDelivery() {
		
		jd.getContentPane().add( new JLabel ("Not found this Normal Delivery - Delete  is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete a Normal Delivery");
		lblNewLabel.setBounds(269, 24, 190, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter id delivery for deleting");
		lblNewLabel_1.setBounds(134, 85, 209, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(294, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(254, 127, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	int countdelegate=0;
	int countshort=0;
	int countnormal=0;
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
				DeleteNormalDelivery test2=new DeleteNormalDelivery();
				test2.setVisible(true);
				test2.DeleteNormalDelivery();
		}
		for(Manager M:DataBase.managerarr)
		{
			countshort=0;
			countdelegate=countdelegate+1;
			for(Members S:M.arrmember.values())
			{
				countnormal=0;
				countshort=countshort+1;
				for(NormalDelivery R:S.arr)
				{
					if(DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.getId())!=null)
					{
					countnormal=countnormal+1;
					if(R.getId()==Integer.parseInt(textField.getText()))
		           {
					DataBase.managerarr.get(Enterpage.count-1).arrmember.get(S.getId()).arr.remove(countnormal-1);
					
					try
					{
					 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
					 String s;
					 new FileOutputStream("src\\Helperfile.txt").close();

				 		while((s=br.readLine())!=null)
				 		{
				 			if(s.charAt(0)=='4'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(9)).equals(Integer.toString(Integer.parseInt(textField.getText()))))
				 			{
				 			}
				 			 else
					 			{
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
					flag=1;
					break;
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
			}
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
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class MergeMember extends JFrame implements ActionListener {
	public MergeMember() {
	}
	

	private JPanel contentPane;
	private JTextField textField;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	public   ArrayList<NormalDelivery> memberdeliver=new  ArrayList<NormalDelivery>();
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "Wrong data", false);

	public void  MergeMember() {
		jd.getContentPane().add( new JLabel ("Wrong data...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mergemember");
		lblNewLabel.setBounds(278, 29, 150, 48);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(342, 88, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("member id");
		lblNewLabel_1.setBounds(246, 90, 86, 17);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(278, 132, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return to Enter page");
		btnNewButton_1.setBounds(427, 132, 178, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
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
				MergeMember test2=new MergeMember();
				test2.setVisible(true);
				test2.MergeMember();
		}
		
		int flag=0;
		 try
			{
			 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
			 String s;
		 		while((s=br.readLine())!=null)
		 		{
		 			
		 			
		 				if(s.charAt(0)=='5'&&s.charAt(3)==(Enterpage.count+'0')&&String.valueOf(s.charAt(9)).equals(textField.getText()))
		 				{
		 					 String shortname="";
		                      int count=69;
		                      while(s.charAt(count)!='-')
				 				{
		                      	shortname=shortname+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+14;
		                      double password;
		                      String help="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	help=help+s.charAt(count);
				 					count=count+1;
				 				}
		                      password=Double.parseDouble(help);
		                      count=count+11;
		                      
		                       help="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	help=help+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+17;
		                      double price ;
		                       help="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	help=help+s.charAt(count);
				 					count=count+1;
				 				}
		                      price=Double.parseDouble(help);
		                      count=count+17;
		                      String recapintname="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	recapintname=recapintname+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+18;
		                      String recapintphone="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	recapintphone=recapintphone+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+16;
		                      String deliverydate="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	deliverydate=deliverydate+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+14;
		                      String originarea="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	originarea=originarea+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+19;
		                      String destantion="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	destantion=destantion+s.charAt(count);
				 					count=count+1;
				 				}
		                      count=count+11;
		                      String distance="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	distance=distance+s.charAt(count);
				 					count=count+1;
				 				}
		                      int helpdistance;
		                      helpdistance=Integer.parseInt(distance);
		                      count=count+10;
		                      String pricekm="";
		                      while(s.charAt(count)!='-')
				 				{
		                      	pricekm=pricekm+s.charAt(count);
				 					count=count+1;
				 				}
		                      double helpprice=Double.parseDouble(pricekm);
				 			if(s.charAt(0)=='5'&&deliverydate.equals(textField.getText()))
				 			{
				 				NormalDelivery newshortdelivery=new Shortdeliveries(shortname,password,help,price,recapintname,recapintphone,deliverydate,originarea,destantion,helpdistance,helpprice);
				 				((Shortdeliveries)newshortdelivery).shortmember=DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9))));
		 				memberdeliver.add(newshortdelivery);
				 			}
		 				}
		 				if(s.charAt(0)=='4'&&s.charAt(3)==(Enterpage.count+'0')&&String.valueOf(s.charAt(6)).equals(textField.getText()))
		 				{
		 					int count=92;
		                       String normalname="";
		                       while(s.charAt(count)!='-')
				 				{
		                    	   normalname=normalname+s.charAt(count);
				 					count=count+1;
				 				}
		                       count=count+5;
		                       String id="";
		                       while(s.charAt(count)!='-')
				 				{
		                    	   id=id+s.charAt(count);
				 					count=count+1;
				 				}
		                      double helpid=Double.parseDouble(id);
		                      count=count+8;
		                      String price="";
		                      while(s.charAt(count)!='-')
				 				{
		                    	  price=price+s.charAt(count);
				 					count=count+1;
				 				}
		                     double helpprice=Double.parseDouble(price);
		                     count=count+11;
		                     String quantity="";
		                     while(s.charAt(count)!='-')
				 				{
		                    	 quantity=quantity+s.charAt(count);
				 					count=count+1;
				 				}
		                     count=count+23;
		                     String placeofmancefature="";
		                     while(s.charAt(count)!='-')
				 				{
		                    	 placeofmancefature= placeofmancefature+s.charAt(count);
				 					count=count+1;
				 				}
		                     count=count+17;
		                     String deliverprice="";
		                     while(s.charAt(count)!='-')
				 				{
		                    	 deliverprice=deliverprice+s.charAt(count);
				 					count=count+1;
				 				}
		                    double helpdeliverprice=Double.parseDouble(deliverprice);
		                    count=count+17;
		                    String recipentname="";
		                    while(s.charAt(count)!='-')
				 				{
		                    	recipentname=recipentname+s.charAt(count);
				 					count=count+1;
				 				}
		                    count=count+20;
		                    String recipentadrr="";
		                    while(s.charAt(count)!='-')
				 				{
		                    	recipentadrr=recipentadrr+s.charAt(count);
				 					count=count+1;
				 				}
		                    count=count+18;
		                    String recipephone="";
		                    while(s.charAt(count)!='-')
			 				{
		                    	recipephone=recipephone+s.charAt(count);
			 					count=count+1;
			 				}
		                    
				 			NormalDelivery newnormal=new NormalDelivery(normalname,helpid,helpprice,quantity, placeofmancefature,helpdeliverprice,recipentname,recipentadrr,recipephone);
		 					memberdeliver.add(newnormal);
		 				}
		 				

		 			 		
		 			}
		 		
		 		
		 		br.close();
		 		
			}
			catch(Exception z){
				return;
			}
		
		 int flag12=0;
		 System.out.println(memberdeliver);
			for(NormalDelivery G:memberdeliver)
			{
				if (flag12==0)
				{
				model.addColumn(G.toString());
				flag12++;
				}
				model.addRow(new Object[]{G.toString()});
			}
		 table.setBounds(30,40,200,300);
		 getContentPane().add(table);
		 this.setVisible(true);
     }
	if(arg.equals("Return to Enter page"))
	{
		 this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
	}
}
	
	
	

}

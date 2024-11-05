import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Mergedelegateshort extends JFrame  implements ActionListener {
	public Mergedelegateshort() {
	}
	
	private JPanel contentPane;
	private JTextField textField;
	String flag2;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	public   ArrayList<Shortdeliveries> shortdeliver=new  ArrayList<Shortdeliveries>();
	public void  Mergedelegateshort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Merge Short Delivers");
		lblNewLabel.setBounds(257, 33, 108, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Date:");
		lblNewLabel_1.setBounds(176, 77, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(267, 75, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(176, 117, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return to choose page");
		btnNewButton_1.setBounds(340, 117, 189, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Finish"))
	{
		
		int flag=0;
		 try
			{
			 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
			 String s;
		 		while((s=br.readLine())!=null)
		 		{
		 			if(s.charAt(0)=='5')
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
		 			if(deliverydate.equals(textField.getText()))
		 			{
		 				
		 				
		 				NormalDelivery newshortdelivery=new Shortdeliveries(shortname,password,help,price,recapintname,recapintphone,deliverydate,originarea,destantion,helpdistance,helpprice);
		 				((Shortdeliveries)newshortdelivery).shortmember=DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9))));
		 				shortdeliver.add((Shortdeliveries)newshortdelivery);

		 			}
		 		
		 		}
			}
		 		br.close();
		 		
			}
			catch(Exception z){
				return;
			}
		 int flag12=0;
				for(Shortdeliveries G:shortdeliver)
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
	if(arg.equals("Return to choose page"))
	{
		 this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	}
}

}

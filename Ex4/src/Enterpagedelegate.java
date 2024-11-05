import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Enterpagedelegate extends JFrame implements ActionListener {
	public Enterpagedelegate() {
	}
	

	private JPanel contentPane;

	public void Enterpagedelegate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("delegate Enter page");
		lblNewLabel.setBounds(276, 11, 120, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Merge Short");
		btnNewButton.setBounds(83, 100, 198, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save Short in file");
		btnNewButton_1.setBounds(353, 96, 205, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Member with less than 3 short deliver");
		btnNewButton_2.setBounds(186, 159, 247, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Choose what you want to do :");
		lblNewLabel_1.setBounds(83, 65, 183, 24);
		contentPane.add(lblNewLabel_1);
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Merge Short"))
	{
		this.setVisible(false);
		Mergedelegateshort test2=new Mergedelegateshort();
		test2.setVisible(true);
		test2.Mergedelegateshort();
    }
	if(arg.equals("Save Short in file"))
	{
		 try
			{
			 PrintWriter writer = new PrintWriter("src\\saveshortmember.txt");
			 writer.print("");
			 writer.close();
			 
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
		 				NormalDelivery newshortdelivery=new Shortdeliveries(shortname,password,help,price,recapintname,recapintphone,deliverydate,originarea,destantion,helpdistance,helpprice);
		 				((Shortdeliveries)newshortdelivery).shortmember=DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9))));
		 				try(FileWriter f=new FileWriter("src\\saveshortmember.txt",true);
		 						
		 			            BufferedWriter b=new BufferedWriter(f);
		 						 PrintWriter pw=new PrintWriter(b);){
		 					pw.println(((Shortdeliveries)newshortdelivery).shortmember);
		 					 pw.println("5"+"--"+Integer.toString(Enterpage.count)+"--"+Integer.toString(Entertodelegate.countdelegatemanager)+"--"+(DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9)))).getId())+"--"+password+"--"+"Manager delegate number="+Integer.toString(Entertodelegate.countdelegatemanager)+"--"+"Member id="+((Shortdeliveries)newshortdelivery).shortmember.getId()+"--"+"object name="+shortname+"--"+"id delivery="+password+"--"+"quantity="+help+"--"+"delivery price="+price+"--"+"recipient name="+recapintname+"--"+"recipient phone="+recapintphone+"--"+"date delivery="+deliverydate+"--"+"origin area="+originarea+"--"+"destination city="+destantion+"--"+"distance="+helpdistance+"--"+"pricekm="+helpprice+"--");
		 				 		System.out.println("Add is successed");
		 						}
		 						catch(Exception w) {
		 							 w.printStackTrace();	
		 						}
		 				
		 			}
		 		}
			}
		 
			catch(Exception z){
				return;
			}
		 this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
    }
	if(arg.equals("Member with less than 3 short deliver"))
	{
		this.setVisible(false);
		Savedelegate test2=new Savedelegate();
		test2.setVisible(true);
		test2.Savedelegate();
    }
	}
	}

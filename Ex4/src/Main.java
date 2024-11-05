
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import javax.swing.*;
public class Main extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	protected JFrame frame2= new JFrame();
	protected JFrame signup= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "add succeeded", false);
	 protected JPanel firstpage = new JPanel(new GridLayout(0,2));
	 public int flag=0;
	 
	 
	public Main() {
		 try
			{
			 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
			 String s;
			 if ((s=br.readLine())==null)
			 {
				 flag=0;
			 }
			 else 
			 {
				 flag=1;
			 }
			}
		 catch(Exception z){
				return;
			}
		 if(flag==0)
		 {
		getContentPane().setLayout(null);
		jd.getContentPane().add( new JLabel ("add succeeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300); 
		
				JLabel lblNewLabel = new JLabel("*First Page*");
				lblNewLabel.setBounds(294, 61, 118, 24);
				firstpage.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter datiles of first manager :");
		lblNewLabel_1.setBounds(40, 86, 158, 14);
		firstpage.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Manager area");
		lblNewLabel_1_1.setBounds(205, 129, 158, 14);
		firstpage.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(384, 167, 86, 20);
		firstpage.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("password");
		lblNewLabel_1_2.setBounds(205, 170, 158, 14);
		firstpage.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(384, 211, 86, 20);
		firstpage.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Manager name");
		lblNewLabel_1_1_1.setBounds(205, 214, 158, 14);
		firstpage.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(384, 126, 86, 20);
		firstpage.add(textField);
		
		Button button = new Button("Clear");
		button.setBounds(175, 247, 93, 22);
		firstpage.add(button);
		
		Button button_1 = new Button("Finish");
		button_1.setBounds(359, 247, 93, 22);
		firstpage.add(button_1);
		
		firstpage.setBounds(104, 39, 435, 253);
		getContentPane().add(firstpage);
		button.addActionListener(this);
		button_1.addActionListener(this);
		 }
		 else
		 {
			 try
				{
				 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
				 String s;
			 		while((s=br.readLine())!=null)
			 		{
			 			flag=1;
			 			if(s.charAt(0)=='1')
			 			{
			 				String managerarea="";
			 				int password;
			 				String managername="";
			 				int count=34;
			 				while(s.charAt(count)!='-')
			 				{
			 					managerarea=managerarea+s.charAt(count);
			 					count=count+1;
			 				}
			 				count=count+11;
			 				password=Integer.parseInt(String.valueOf(s.charAt(count)));
			 				count=count+16;
			 				while(s.charAt(count)!='-')
			 				{
			 					managername=managername+s.charAt(count);
			 					count=count+1;
			 				}
			 				Manager newmanager=new Manager(managerarea,password,managername);
			 				DataBase.managerarr.add(newmanager);
			 			}
			 			if(s.charAt(0)=='2')
			 			{
	                            String delegatearea="";
	                            int count=58;
	                            		
	                            while(s.charAt(count)!='-')
	    		 				{
	                            	delegatearea=delegatearea+s.charAt(count);
	    		 					count=count+1;
	    		 				}
	                            count=count+28;
	                            int password=Integer.parseInt(String.valueOf(s.charAt(count)));
	                            count=count+25;
	                            String delegatename="";
	                            while(s.charAt(count)!='-')
	    		 				{
	                            	delegatename=delegatename+s.charAt(count);
	    		 					count=count+1;
	    		 				}
	                            count=count+32;
	                            int deliverynum=Integer.parseInt(String.valueOf(s.charAt(count)));
			 				Managerdelegate newdelegate=new Managerdelegate(delegatearea,password,delegatename,deliverynum);
			 				DataBase.delegatemanagerarr.add(newdelegate);
			 			}
			 			if(s.charAt(0)=='3')
			 			{
	                         String membername="";
	                         int count;
	                         count=39;
	                         while(s.charAt(count)!='-')
	 		 				{
	                        	 membername=membername+s.charAt(count);
	 		 					count=count+1;
	 		 				}
	                         count=count+16;
	                         String memberfamily="";
	                         while(s.charAt(count)!='-')
	  		 				{
	                        	 memberfamily=memberfamily+s.charAt(count);
	  		 					count=count+1;
	  		 				}
	                         count=count+14;
	                         String memberarea="";
	                         while(s.charAt(count)!='-')
	  		 				{
	                        	 memberarea=memberarea+s.charAt(count);
	  		 					count=count+1;
	  		 				}
	                         count=count+12;
	                         String memberid="";
	                         while(s.charAt(count)!='-')
	   		 				{
	                        	 memberid=memberid+s.charAt(count);
	   		 					count=count+1;
	   		 				}
	                         int id=Integer.parseInt(memberid);
	                         System.out.println(id);
			 				Members newmember=new Members(membername,memberfamily,memberarea,id);
			 				DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.put(id, newmember);
			 				
			 			}
			 			if(s.charAt(0)=='4')
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
			 				DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(6)))).arr.add(newnormal);
			 				DataBase.ourLastDeliveries.put(DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(6)))),newnormal);
			 			}
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
			 				DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9)))).arr.add(newshortdelivery);
			 				DataBase.delegatemanagerarr.get(Integer.parseInt(String.valueOf(s.charAt(6)))-1).arrdelegate.add((Shortdeliveries)newshortdelivery);
			 				DataBase.ourLastDeliveries.put(DataBase.managerarr.get(Integer.parseInt(String.valueOf(s.charAt(3)))-1).arrmember.get(Integer.parseInt(String.valueOf(s.charAt(9)))),newshortdelivery);
			 			}
			 		}


			 		br.close();
			 		jd.setVisible(false);
					this.setVisible(false);
					Enterpage test1=new Enterpage();
					test1.setVisible(true);
					test1.Enterpage();
				}
			 
				catch(Exception z){
					return;
				}
		 }
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Clear"))
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		jd.setVisible(false);
	}
	else if (arg.equals("Finish"))
	{
		try 
		{
			int i=Integer.parseInt(textField_2.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
				this.setVisible(false);
				Main f=new Main();
				f.setVisible(true);
				
		}
		if(((textField_1.getText().equals("north")||textField_1.getText().equals("south")||textField_1.getText().equals("center"))&&textField.getText()!=""))
	{
		Manager newmanager=new Manager(textField_1.getText(),Integer.parseInt(textField_2.getText()),textField.getText());
		DataBase.managerarr.add(newmanager);
	 		try(FileWriter f=new FileWriter("src\\Manager.txt",true);
	 				
	 	            BufferedWriter b=new BufferedWriter(f);
	 				 PrintWriter pw=new PrintWriter(b);){
	 				 pw.println("1"+"--"+"Manager number="+"1"+"--"+"Manager area="+textField_1.getText()+"--"+"password="+Integer.parseInt(textField_2.getText())+"--"+"Manager name="+textField.getText()+"--");
	 				 BufferedReader br=new BufferedReader(new FileReader("src/Manager.txt"));
	 		 		String s=br.readLine();
	 		 		System.out.println("Add is successed");
	 				}
	 				catch(Exception ex) {
	 					 ex.printStackTrace();	
	 				}
		jd.setVisible(true);
		firstpage.setVisible(false);
		this.setVisible(false);
		Enterpage test1=new Enterpage();
		test1.setVisible(true);
		test1.Enterpage();
	}
		else
		{
			System.out.println("wrong input.");
			this.setVisible(false);
			Main f=new Main();
			f.setVisible(true);
		}
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		/*enter information of managers*/
		Scanner input=new Scanner(System.in);
		Members a1=null;
		int count=0;
		int t;
		DataBase.countTree=100;
		int testaddmanager=0;
		int countmanager=0;
		Main f=new Main();
		f.setVisible(true);
		System.out.println("enter 1 to add a manager or 0 to exit adding manager process");
	     
		t=input.nextInt();
		while(t!=0)
		{
			countmanager=countmanager+1;
			System.out.println("enter the name of manager :");
			String namemanager="ahmad";
			System.out.println("enter the area of manager :");
			String managerarea="north";
			System.out.println("Warning: the name of manager is "+namemanager+" and the password is "+countmanager);
			Integer password=countmanager;
			Manager newmanager=new Manager(managerarea,password,namemanager);
			DataBase.managerarr.add(newmanager);
			System.out.println("adding Manager process is succeeded");
			System.out.println("enter 1 to add a manager or 0 to exit adding manager process");
			t=input.nextInt();
			testaddmanager=testaddmanager+1;
		}
		int flag=0;
		String thisnamemanager2;
		if(testaddmanager!=0)
		{
		System.out.println("enter manager name you want to edit");
		thisnamemanager2=input.next();
		System.out.println("Warning:Password consists of 8 numbers or less only ");
		System.out.println("enter manager password you want to edit");
		int thispasswordmanager2=input.nextInt();
		for(Manager M: DataBase.managerarr)
		{
			if(M.getPassword()==thispasswordmanager2)
			{
				flag=1;
			}
		}
		while(flag==0)
		{
		
			System.out.println("this manager not found please enter another one :");
			System.out.println("enter manager name you want to edit");
			thisnamemanager2=input.next();
			System.out.println("enter manager password you want to edit");
			 thispasswordmanager2=input.nextInt();
			for(Manager M: DataBase.managerarr)
			{
				if(M.getPassword()==thispasswordmanager2)
				{
					flag=1;
				}
			}
		}
		int delegatesum=0;
		int delegatecount[]=new int[DataBase.managerarr.size()];
		  System.out.println("choose one of the opstion:");
	  		System.out.println("1-> add a member ");
	  		System.out.println("2-> delete a member ");
	  		System.out.println("3-> add a new object");
	  		System.out.println("4-> show last order and all odrders of member");
	  		System.out.println("5->  show all orders of area");
	  		System.out.println("6->to show all members with orders ");
	  		System.out.println("7-> add a delegate Manager");
	  		System.out.println("8-> return to the main screen");
		int check=input.nextInt();
		while(1==1)
		{
		while(check!=8)
		{
		if(check==1)/*It checks whether we have finished receiving clients or not*/
		{
			
			int managernumber=0;
			System.out.println("member1 name (string):");
			String name=input.next();
			System.out.println("member1 family:");
			String family=input.next();
			System.out.println("member1 area -> 1-north 2-center 3-south (string)");
			String memberarea=input.next();
		for(Manager M: DataBase.managerarr)
		{
			if(M.getPassword()!=thispasswordmanager2)
			{
				managernumber=managernumber+1;
			}
		}
		if( DataBase.managerarr.get(managernumber).getManagerarea().equals(memberarea))
		{
		count=count+1;
	    a1=new Members(name,family,memberarea,count);
		 DataBase.managerarr.get(managernumber).arrmember.put(count,a1);	
		 System.out.println("*the id of "+name+" is "+count+".*");
		 System.out.println("Add members is successfully");
		
		}
		 else 
		 {
			 System.out.println("error this manager not responsible on this area");
		
		 }
			}
		
		String productype;/*Check the type of product we want*/
		String normal="NormalDelivery";
		String norma2="ExpressDelivery";
		String norma3="WorkDelivery";
		String prodectname;
		int memberid;
		double prodectid;
		double prodectprice;
		String prodectquantity;
		String prodectplaceofmanufacture;
		double prodectDeliveryprice;
		String prodectrecipientname;
		String prodectrecipientaddress;
		String prodectrecupientphone;
		String prodecttransporttype;
		double  prodectdeliverytime;
		double prodectratetransmation;
		String prodectworktype;
		String prodectobjectsize;
		double prodectdeliverySecrecy;
		if(check==3)/*It helps us know whether we have finished receiving products or not*/
			{			
			System.out.println("Enter the member id you want to add the product to:");
			memberid=input.nextInt();/*It helps us to know the required customer*/
			if(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid)!=null)
			{
 			System.out.println("Enter the product type:NormalDelivery,ExpressDelivery,WorkDelivery (string)");
			productype=input.next();/*Know what kind of product you need*/
			System.out.println("Enter product attributes:");
			if(productype.equals(normal)==true)/*If the customer belongs to the north and wants a normal product*/
			{
				
				System.out.println("enter prodect name (string):");
				prodectname=input.next();
				System.out.println("enter prodect id (double):");
				prodectid=input.nextDouble();
				System.out.println("enter prodect price (double):");
				prodectprice=input.nextDouble();
				System.out.println("enter prodect quantity (string):");
				prodectquantity=input.next();
				System.out.println("enter prodect place of manufacture (string):");
				prodectplaceofmanufacture=input.next();
				System.out.println("enter prodect Delivery price (double):");
				prodectDeliveryprice=input.nextDouble();
				System.out.println("enter prodect recipient name (string):");
				prodectrecipientname=input.next();
				System.out.println("enter prodect recipient address (string):");
				prodectrecipientaddress=input.next();
				System.out.println("enter prodect recupient phone (string):");
				prodectrecupientphone=input.next();
			     NormalDelivery newdelivery=new NormalDelivery(prodectname,prodectid,prodectprice,prodectquantity,prodectplaceofmanufacture,prodectDeliveryprice,prodectrecipientname,prodectrecipientaddress,prodectrecupientphone);
			    (DataBase.managerarr.get(thispasswordmanager2-1)).arrmember.get(memberid).arr.add(newdelivery);/*Adding the client to the manager in charge of the center region*/						     
			    DataBase.ourLastDeliveries.put(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid),newdelivery);
			    DataBase.ourMembersAndDeluveries1.put(DataBase.countTree,DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid));
						DataBase.ourMembersAndDeluveries2.put(DataBase.countTree,newdelivery);
					    DataBase.countTree=DataBase.countTree+5;
					    System.out.println("ADD a product is succeed");
			}
			if(productype.equals(norma2)==true)/*If the customer belongs to the center and wants a Normal product*/
			{
				
				System.out.println("enter prodect name (string):");
				prodectname=input.next();
				System.out.println("enter prodect id (double):");
				prodectid=input.nextDouble();
				System.out.println("enter prodect price (double):");
				prodectprice=input.nextDouble();
				System.out.println("enter prodect quantity (string):");
				prodectquantity=input.next();
				System.out.println("enter prodect place of manufacture (string):");
				prodectplaceofmanufacture=input.next();
				System.out.println("enter prodect Delivery price (double):");
				prodectDeliveryprice=input.nextDouble();
				System.out.println("enter prodect recipient name (string):");
				prodectrecipientname=input.next();
				System.out.println("enter prodect recipient address (string):");
				prodectrecipientaddress=input.next();
				System.out.println("enter prodect recupient phone (string):");
				prodectrecupientphone=input.next();
				System.out.println("enter prodect transport type (string):");
				prodecttransporttype=input.next();
				System.out.println("enter prodect delivery time (double):");
				prodectdeliverytime=input.nextDouble();
				System.out.println("enter prodect rate transmation->->-> 1-3: 1:excelent,2:good,3:bad:");
				prodectratetransmation=input.nextDouble();
				NormalDelivery newexpressdelivery=new ExpressDelivery(prodectname,prodectid,prodectprice,prodectquantity,prodectplaceofmanufacture,prodectDeliveryprice,prodectrecipientname,prodectrecipientaddress,prodectrecupientphone,prodecttransporttype,prodectdeliverytime,prodectratetransmation);
				(((((DataBase.managerarr.get(thispasswordmanager2-1)).arrmember).get(memberid)).arr)).add(newexpressdelivery);/*Adding the client to the manager in charge of the center region*/				
				DataBase.ourLastDeliveries.put(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid),newexpressdelivery);
				 DataBase.ourMembersAndDeluveries1.put(DataBase.countTree,DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid));
					DataBase.ourMembersAndDeluveries2.put(DataBase.countTree,newexpressdelivery);
				    DataBase.countTree=DataBase.countTree+5;
				    System.out.println("ADD a product is succeed");
			}
			if(productype.equals(norma3)==true)/*If the customer belongs to the south and wants a Normal product*/
			{
				
				System.out.println("enter prodect name (string):");
				prodectname=input.next();
				System.out.println("enter prodect id (double):");
				prodectid=input.nextDouble();
				System.out.println("enter prodect price (double):");
				prodectprice=input.nextDouble();
				System.out.println("enter prodect quantity (string):");
				prodectquantity=input.next();
				System.out.println("enter prodect place of manufacture (string):");
				prodectplaceofmanufacture=input.next();
				System.out.println("enter prodect Delivery price (double):");
				prodectDeliveryprice=input.nextDouble();
				System.out.println("enter prodect recipient name (string):");
				prodectrecipientname=input.next();
				System.out.println("enter prodect recipient address (string):");
				prodectrecipientaddress=input.next();
				System.out.println("enter prodect recupient phone (string):");
				prodectrecupientphone=input.next();
				System.out.println("enter prodect work type(string):");
				prodectworktype=input.next();
				System.out.println("enter prodect object size(string):");
				prodectobjectsize=input.next();
				System.out.println("enter prodect delivery Secrecy->->-> 1-3; 1:simplesecret,2:middlesecret,3:hightsecret(double):");
				prodectdeliverySecrecy=input.nextDouble();
				NormalDelivery neweworkdelivery=new WorkDelivery(prodectname,prodectid,prodectprice,prodectquantity,prodectplaceofmanufacture,prodectDeliveryprice,prodectrecipientname,prodectrecipientaddress,prodectrecupientphone,prodectworktype,prodectobjectsize,prodectdeliverySecrecy);
				(((((DataBase.managerarr.get(thispasswordmanager2-1)).arrmember).get(memberid)).arr)).add(neweworkdelivery);/*Adding the client to the manager in charge of the south region*/								
				DataBase.ourLastDeliveries.put(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid),neweworkdelivery);
				 DataBase.ourMembersAndDeluveries1.put(DataBase.countTree,DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(memberid));
					DataBase.ourMembersAndDeluveries2.put(DataBase.countTree,neweworkdelivery);
				    DataBase.countTree=DataBase.countTree+5;
				    System.out.println("ADD a product is succeed");
				   
			}
		System.out.println(((((DataBase.managerarr.get(thispasswordmanager2-1)).arrmember).get(memberid)).arr));
		     }
			
			 else
			  {
			    	 System.out.println(" error: this member is not founed");
			  }
			}
		if(check==2)
		{
			int help=0;
			int i=0;
		 ArrayList<Integer>test2=new ArrayList<Integer>();
		System.out.println("id of member for delete:");
		Members d=null;
		Integer id=input.nextInt();/*The id of the customer we want to delete*/
		if(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(id)!=null)
		{
		for(Map.Entry<Integer,Members> r:DataBase.ourMembersAndDeluveries1.entrySet())
		{
			help=100+i*5;
 			i=i+1;
			if((r.getValue().getId()==id))
			{
				d=r.getValue();
				test2.add(help);
			}
		}
		NormalDelivery u=DataBase.ourLastDeliveries.remove(d);
		Object[] m=test2.toArray();
		for(i=0;i<m.length;i++)
		{
		DataBase.ourMembersAndDeluveries1.remove(m[i]);
		DataBase.ourMembersAndDeluveries2.remove(m[i]);
		}
		DataBase.managerarr.get(thispasswordmanager2-1).arrmember.remove(id);
		System.out.println("Delete is completed");
		System.out.println("The manager's data that remained after deletion");
		for(Manager M: DataBase.managerarr)
		{
			if(M.getPassword()==(thispasswordmanager2))
			{
				System.out.println(M.arrmember);;
			}
		}
		}
		else 
		{
			System.out.println("not found member of this id ");
		}
		}
		if(check==4)
		{
			System.out.println(" enter member id to show last order and all odrders");
			Integer lastid;
			lastid=input.nextInt();
			if(DataBase.managerarr.get(thispasswordmanager2-1).arrmember.get(lastid)!=null)
			{
				System.out.println("The last order of the member is : ");
				System.out.println(DataBase.ourLastDeliveries.get((DataBase.managerarr.get(thispasswordmanager2-1).arrmember).get(lastid)));
				System.out.println("All of order objects is :");
				System.out.println((DataBase.managerarr.get(thispasswordmanager2-1).arrmember).get(lastid));
			}
			
     		
		}
         if(check==5)
         {
        	int flag4=0;
     		System.out.println("enter area to show all orders of this area : ");
             String randomarea=input.next();
     		Integer help=0;
     		Integer i=0;
     		for(Map.Entry<Integer,Members> r:DataBase.ourMembersAndDeluveries1.entrySet())
    		{
     			help=100+i*5;
     			i=i+1;
     			if(r.getValue().getmemberarea().equals(randomarea))
     			{
     					flag4=1;
     				System.out.println(DataBase.ourMembersAndDeluveries2.get(help));
     			}
     		}
     		if(flag4==0)
     		{
     			System.out.println("*not found orders of area "+randomarea+".*");
     		}
             
         } 
          if (check==6)
          {
        	  /*print all: managers and members and prodeucts*/
        	
        		System.out.println("All deliveries ordered: ");
        		for(Manager M: DataBase.managerarr)
        		{
        			System.out.println(M.arrmember);
        		}
        	    
          }
		if(check==8)
		{
			delegatesum=delegatesum+1;
			System.out.println("Warning :   ");
			System.out.println("enter the name of delegate manager :");
			String delegatenamemanager=input.next();
			System.out.println("enter the area of delegate manager :");
			String delegatemanagerarea=input.next();
			System.out.println("enter the num of Short dliveries which can take the delegate manager ");
			Integer deliverynum1=input.nextInt();
			System.out.println("Warning: the name of manager is "+delegatenamemanager+" and the password is "+delegatesum);
			Managerdelegate newdelegatemanager=new Managerdelegate(delegatemanagerarea,delegatesum,delegatenamemanager,deliverynum1);
			DataBase.delegatemanagerarr.add(newdelegatemanager);
			delegatecount[thispasswordmanager2-1]++;
			System.out.println("adding delegatemanagerarr process is succeeded");
			System.out.println("Warning : this delegate of manager who have the password : "+thispasswordmanager2);
		}
		 System.out.println("choose one of the opstion:");
	  		System.out.println("1-> add a member ");
	  		System.out.println("2-> delete a member ");
	  		System.out.println("3-> add a new object");
	  		System.out.println("4-> show last order and all odrders of member");
	  		System.out.println("5->  show all orders of area");
	  		System.out.println("6->to show all members with orders ");
	  		System.out.println("7-> add a delegate Manager");
	  		System.out.println("8-> return to the main screen");
		check=input.nextInt();
	     }
		 flag=0;
		System.out.println("enter manager name you want to edit");
		thisnamemanager2=input.next();
		System.out.println("Warning:Password consists of 8 numbers or less only ");
		System.out.println("enter manager password you want to edit");
		 thispasswordmanager2=input.nextInt();
		for(Manager M: DataBase.managerarr)
		{
			if(M.getPassword()==(thispasswordmanager2))
			{
				flag=1;
			}
		}
      	while(flag==0)
		{
      		System.out.println("this manager not found please enter another one :");
			System.out.println("enter manager name you want to edit");
			thisnamemanager2=input.next();
			System.out.println("Warning:Password consists of 8 numbers or less only ");
			System.out.println("enter manager password you want to edit");
			 thispasswordmanager2=input.nextInt();
			for(Manager M: DataBase.managerarr)
			{
				if(M.getPassword()==(thispasswordmanager2))
				{
					flag=1;
				}
			}
		}
      	 System.out.println("choose one of the opstion:");
	  		System.out.println("1-> add a member ");
	  		System.out.println("2-> delete a member ");
	  		System.out.println("3-> add a new object");
	  		System.out.println("4-> show last order and all odrders of member");
	  		System.out.println("5->  show all orders of area");
	  		System.out.println("6->to show all members with orders ");
	  		System.out.println("7-> add a delegate Manager");
	  		System.out.println("8-> return to the main screen");
	     check=input.nextInt();
          }
		}
		else 
		{
			System.out.println("Not found any managers to edit.");
		}
		}
}





import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class DeleteMember extends JFrame implements ActionListener {

	private JTextField textField;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "Add is not succede", false);
	Choice choicein = new Choice();
	public String in="";
	 public int helpid=900;
	
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public void  DeleteMember() {
		jd.getContentPane().add( new JLabel ("member not found on this Manager or a wrong data is Enter - Delete is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		choicein.setBounds(60, 64, 101, 22);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Delete a Member");
		lblNewLabel.setBounds(268, 30, 137, 14);
		getContentPane().add(lblNewLabel);
		for(Members r:DataBase.managerarr.get(Enterpage.count-1).arrmember.values())
		{
			 
			choicein.add(r.getMembername()+"--"+r.getId());  
			
		}
		getContentPane().add(choicein);
		JButton btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.setBounds(268, 137, 89, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(choicein.getSelectedItem()!=null)
		{
		 in=choicein.getSelectedItem();
		  helpid=Character.getNumericValue(in.charAt(in.length()-1));
		}
		else
		{
			this.setVisible(false);
			  jd.setVisible(true);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage();
		}
		  if(helpid!=900)
		  {
		Manager d=null;
			for(Map.Entry<Integer,Members> r:DataBase.managerarr.get(Enterpage.count-1).arrmember.entrySet())
			{
	 			if(r.getKey()==helpid)
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
		EvenException ex = new EvenException();
		
		 try{
			 ex.isEven(DataBase.managerarr.get(Enterpage.count-1).arrmember.get(helpid));
			 DataBase.managerarr.get(Enterpage.count-1).arrmember.remove(helpid);
			 try
				{
				 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
				 String s;
				 new FileOutputStream("src\\Helperfile.txt").close();
			 		while((s=br.readLine())!=null)
			 		{
			 			if((s.charAt(0)=='3'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(6)).equals(String.valueOf(helpid)))||(s.charAt(0)=='5'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(9)).equals(String.valueOf(helpid)))||(s.charAt(0)=='4'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(6)).equals(String.valueOf(helpid))))
			 			{
			 			}
			 			 else
				 			{
			 				 System.out.println();
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
			}
		 catch(Exception e){
			 int countdelegate=0;
		System.out.println(e.getMessage());
		for(Managerdelegate M:DataBase.delegatemanagerarr)
		{
			countdelegate=countdelegate+1;
			int count=0;
			
			for(;count<M.arrdelegate.size();)
			{
				Shortdeliveries S=M.arrdelegate.get(count);
				count=count+1;
				if(S.shortmember.getId()==helpid)
               {
					
					int help=DataBase.managerarr.get(Enterpage.count-1).arrmember.get(helpid).arr.indexOf(S);
					DataBase.managerarr.get(Enterpage.count-1).arrmember.get(helpid).arr.remove(help);
					DataBase.delegatemanagerarr.get(countdelegate-1).arrdelegate.remove(count-1);
					count=count-1;
					
               
               }
				
			
			}
			DataBase.managerarr.get(DataBase.managerarr.indexOf(d)).arrmember.remove(helpid);
			try
			{
			 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
			 String s;
			 new FileOutputStream("src\\Helperfile.txt").close();
		 		while((s=br.readLine())!=null)
		 		{
		 			if((s.charAt(0)=='3'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(6)).equals(String.valueOf(helpid)))||(s.charAt(0)=='5'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(9)).equals(String.valueOf(helpid)))||(s.charAt(0)=='4'&&String.valueOf(s.charAt(3)).equals(Integer.toString(Enterpage.count))&&String.valueOf(s.charAt(6)).equals(String.valueOf(helpid))))
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
		}
		
		
		 }
	
		this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	     }
		}
		  }
		  else
		  {
			  this.setVisible(false);
			  jd.setVisible(true);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage();
		  }
	}
	public class EvenException {
		void isEven(Members membercheck) throws Exception{
		for(Managerdelegate M:DataBase.delegatemanagerarr)
		{
			for(Shortdeliveries S:M.arrdelegate)
			{
				if(S.shortmember.getId()==helpid)
               {
					throw new Memberexcaption();
                }
			}
		}
		}
		}
}

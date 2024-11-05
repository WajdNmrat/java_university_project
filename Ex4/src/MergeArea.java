import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MergeArea extends JFrame implements ActionListener  {
	public MergeArea() {
	}
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	private JPanel contentPane;
	public   ArrayList<NormalDelivery> areadeliver=new  ArrayList<NormalDelivery>();
	
	public void MergeArea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery in area");
		lblNewLabel.setBounds(282, 28, 113, 51);
		contentPane.add(lblNewLabel);
		 try
			{
			 BufferedReader br=new BufferedReader(new FileReader("src\\Manager.txt"));
			 String s;
		 		while((s=br.readLine())!=null)
		 		{
		 			
		 			if(s.charAt(0)=='4'&&s.charAt(3)==(Enterpage.count+'0'))
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
	                    
			 				NormalDelivery newnormal=new NormalDelivery(normalname,helpid,helpprice,quantity, placeofmancefature,helpdeliverprice,recipentname,recipentadrr,recipephone);                            areadeliver.add(newnormal);
		 			}
		 		}
		 		br.close();
		 		
			}
			catch(Exception z){
				return;
			}
		
				for(NormalDelivery G:areadeliver)
				{
					model.addColumn(G.toString());
					model.addRow(new Object[]{G.toString()});
				}
		 table.setBounds(30,40,200,300);
		 getContentPane().add(table);
		 
		 JButton btnNewButton = new JButton("Return to choose page");
		 btnNewButton.setBounds(297, 106, 200, 23);
		 contentPane.add(btnNewButton);
			btnNewButton.addActionListener(this);

    }
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();	
	if(arg.equals("Return to choose page"))
	{
		
		this.setVisible(false);
		Choosepage test2=new Choosepage();
		test2.setVisible(true);
		test2.Choosepage();
	
     }
	}
}

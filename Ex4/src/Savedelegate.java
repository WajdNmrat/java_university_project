import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Savedelegate extends JFrame implements ActionListener {
	public Savedelegate() {
	}

	private JPanel contentPane;
public int flag=0;
protected JFrame frame2= new JFrame();
protected JDialog jd = new JDialog(frame2 , "The file is empty", false);
DefaultTableModel model = new DefaultTableModel();
JTable table = new JTable(model);
public HashMap<Integer, Integer> arrmember2= new HashMap<Integer,Integer>();
	public void Savedelegate() {
		jd.getContentPane().add( new JLabel ("The file is empty...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Reaturn to choose page");
		btnNewButton.setBounds(229, 175, 300, 20);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("Show member with less than 3 short delivery");
		lblNewLabel.setBounds(211, 46, 239, 31);
		contentPane.add(lblNewLabel);
		try
		{
		 BufferedReader br=new BufferedReader(new FileReader("src\\saveshortmember.txt"));
		 String s;
	 		while((s=br.readLine())!=null)
	 		{
	 		      flag=1;
	 			if(s.charAt(0)!='5')
	 			{
	 			 if(arrmember2.get(Integer.parseInt(String.valueOf(s.charAt(s.length()-1))))==null)
	 			 {
	 				arrmember2.put(Integer.parseInt(String.valueOf(s.charAt(s.length()-1))),1);
	 			 }
	 			 else 
	 			 {
	 				arrmember2.put(Integer.parseInt(String.valueOf(s.charAt(s.length()-1))),arrmember2.get(Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))) + 1);
	 			 }
	 			}
  		 			
	 		}
	 		br.close();
			 BufferedReader br2=new BufferedReader(new FileReader("src\\saveshortmember.txt"));
			 String s1;
		 		while((s1=br2.readLine())!=null)
		 		{
			 		if(s1.charAt(0)!='5')
			 		{
		 			if(arrmember2.get(Integer.parseInt(String.valueOf(s1.charAt(s1.length()-1))))>=3&&arrmember2.get(Integer.parseInt(String.valueOf(s1.charAt(s1.length()-1))))!=0)
		 			{
		 				arrmember2.put(Integer.parseInt(String.valueOf(s1.charAt(s1.length()-1))),0);
						model.addColumn(s1);
						model.addRow(new Object[]{s1});
					}
			 		}
				 table.setBounds(30,40,200,300);
				 getContentPane().add(table);
		 		}
		 		br2.close();
		}
	 
		catch(Exception z){
			return;
		}
		btnNewButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String arg = ev.getActionCommand();
	if(arg.equals("Reaturn to choose page"))
	{
		
		
		if(flag==1)
		{
		 this.setVisible(false);
			Choosepage test2=new Choosepage();
			test2.setVisible(true);
			test2.Choosepage();
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

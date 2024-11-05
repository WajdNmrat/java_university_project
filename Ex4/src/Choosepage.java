import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Choosepage extends JFrame implements ActionListener {
	public Choosepage() {
	}
	
	
public static int flag=0;
	private JPanel contentPane;
	private JTable table_1;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public void  Choosepage() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose page");
		lblNewLabel.setBounds(280, 35, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose what you want :");
		lblNewLabel_1.setBounds(66, 66, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add Manager");
		btnNewButton.setBounds(242, 347, 196, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAddmember = new JButton("AddMember");
		btnAddmember.setBounds(10, 113, 209, 23);
		contentPane.add(btnAddmember);
		
		JButton btnAddShortDelivery = new JButton("Enter to delegate page");
		btnAddShortDelivery.setBounds(10, 163, 209, 23);
		contentPane.add(btnAddShortDelivery);
		
		JButton btnLastDelivery = new JButton("Last Delivery");
		btnLastDelivery.setBounds(10, 307, 209, 23);
		contentPane.add(btnLastDelivery);
		
		JButton btnDeleteMember = new JButton("Delete Member");
		btnDeleteMember.setBounds(229, 113, 209, 23);
		contentPane.add(btnDeleteMember);
		
		JButton btnDeleteShortDelivery = new JButton("Delete Short Delivery");
		btnDeleteShortDelivery.setBounds(461, 163, 181, 23);
		contentPane.add(btnDeleteShortDelivery);
		
		JButton btnAddDelegateManager = new JButton("Add Delegate Manager");
		btnAddDelegateManager.setBounds(448, 113, 209, 23);
		contentPane.add(btnAddDelegateManager);
		
		JButton btnNewButton_1 = new JButton("Return to enter page");
		btnNewButton_1.setBounds(242, 388, 196, 23);
		contentPane.add(btnNewButton_1);
DefaultTableModel model = new DefaultTableModel();
JTable table = new JTable(model);
for(Managerdelegate M:DataBase.delegatemanagerarr)
{
	for(Shortdeliveries G:M.arrdelegate)
	{
		model.addColumn(G.toString());
		model.addRow(new Object[]{G.toString()});
	}
}
JMenuBar mb=new JMenuBar();  	
		mb.setBounds(260, 246, 137, 26);
		JMenu menu=new JMenu("Menu");
		JMenu submenu=new JMenu("jtree");
		JMenu submenu2=new JMenu("members");
		JMenu submenu3=new JMenu("cities");
		submenu.add(table);
		menu.add(submenu);
		JTextArea jt = new JTextArea("Members details ", 40,40);
		for(Managerdelegate M:DataBase.delegatemanagerarr)
		{
			for(Shortdeliveries G:M.arrdelegate)
			{
				jt.append(G.shortmember.toString());
			}
		}
		JTextArea jt2 = new JTextArea("Members details ", 40,40);
		submenu2.add(jt);
	     menu.add(submenu2);
	     
	     Date secondDate=new Date();
	     int daysdiff=0;
	     String AllCities="";
	
	     for(Managerdelegate M:DataBase.delegatemanagerarr)
	     {
	     	for(Shortdeliveries G:M.arrdelegate)
	     	{
	     		String m=G.getDatedelivery();
	     		if(String.valueOf(m.charAt(0))!=null&&String.valueOf(m.charAt(1))!=null&&String.valueOf(m.charAt(2))!=null&&String.valueOf(m.charAt(3))!=null&&String.valueOf(m.charAt(4))!=null&&String.valueOf(m.charAt(5))!=null&&String.valueOf(m.charAt(6))!=null&&String.valueOf(m.charAt(7))!=null)
	     		{
	     		String d1=String.valueOf(String.valueOf(m.charAt(0))+String.valueOf((m.charAt(1))));
	     		String d2=String.valueOf(String.valueOf(m.charAt(2))+String.valueOf((m.charAt(3))));
	     		String d3=String.valueOf(String.valueOf(m.charAt(4))+String.valueOf((m.charAt(5)))+String.valueOf(String.valueOf(m.charAt(6))+String.valueOf((m.charAt(7)))));
	     		LocalDate today = LocalDate.now();
	     		LocalDate d10 = LocalDate.parse(d3+"-"+d2+"-"+d1, DateTimeFormatter.ISO_LOCAL_DATE);
	     		LocalDate d11 = LocalDate.parse(today.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
	     		Duration diff = Duration.between(d10.atStartOfDay(), d11.atStartOfDay());
	     		long diffDays = diff.toDays();
				daysdiff=(int)diffDays;
				if(daysdiff<31&&daysdiff>0)
				{
					AllCities =AllCities+"\n"+G.getDestinationcity();
				}
	     		}
	     	}
	     	jt2.setText(AllCities);
	     }
	     submenu3.add(jt2);
	     menu.add(submenu3);
		mb.add(menu);
		getContentPane().add(mb);
		
		JButton btnNewButton_2 = new JButton("Add Normal Delivery");
		btnNewButton_2.setBounds(10, 213, 209, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Delete Normal Delivery");
		btnNewButton_2_1.setBounds(461, 213, 181, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Mergre short delivery");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(10, 259, 209, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Merge member");
		btnNewButton_4.setBounds(461, 259, 181, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("merge area");
		btnNewButton_5.setBounds(461, 305, 181, 26);
		contentPane.add(btnNewButton_5);
		
		
		
		btnNewButton.addActionListener(this);
		btnAddmember.addActionListener(this);
		btnAddShortDelivery.addActionListener(this);
		btnLastDelivery.addActionListener(this);
		btnDeleteMember.addActionListener(this);
		btnDeleteShortDelivery.addActionListener(this);
		btnAddDelegateManager.addActionListener(this);
		btnNewButton_1 .addActionListener(this);
	     btnNewButton_2.addActionListener(this);
	     btnNewButton_2_1.addActionListener(this);
	     btnNewButton_3.addActionListener(this);
	     btnNewButton_4.addActionListener(this);
	     btnNewButton_5.addActionListener(this);

	}  
	public void actionPerformed(ActionEvent ev)
	{
		
	String arg = ev.getActionCommand();
	if(arg.equals("Add Manager"))
	{
		AddManager test1=new AddManager();
		this.setVisible(false);
		test1.setVisible(true);
		test1.AddManager();
	}
	if(arg.equals("AddMember"))
	{
		AddMember test1=new AddMember();
		this.setVisible(false);
		test1.setVisible(true);
		test1.AddMember();
	}
	if(arg.equals("Enter to delegate page"))
	{
		Entertodelegate test1=new Entertodelegate();
		this.setVisible(false);
		test1.setVisible(true);
		test1.Entertodelegate();
	}
	if(arg.equals("Last Delivery"))
	{
		LastDelivery test1=new LastDelivery();
		this.setVisible(false);
		test1.setVisible(true);
		test1.LastDelivery();
	}
	if(arg.equals("Delete Member"))
	{
		DeleteMember test1=new DeleteMember();
		this.setVisible(false);
		test1.setVisible(true);
		test1.DeleteMember();
	}
	if(arg.equals("Delete Short Delivery"))
	{
		DeleteShortDelivery test1=new DeleteShortDelivery ();
		this.setVisible(false);
		test1.setVisible(true);
		test1.DeleteShortDelivery();
	}
	if(arg.equals("Add Delegate Manager"))
	{
		AddDelegateManager test1=new AddDelegateManager();
		this.setVisible(false);
		test1.setVisible(true);
		test1.AddDelegateManager();
	}
	if(arg.equals("Return to enter page"))
	{
		Enterpage test1=new Enterpage();
		this.setVisible(false);
		test1.setVisible(true);
		test1.Enterpage();
	}
	if(arg.equals("Add Normal Delivery"))
	{
		AddnormalDelivery test1=new AddnormalDelivery();
		this.setVisible(false);
		test1.setVisible(true);
		test1.AddnormalDelivery();
	}
	if(arg.equals("Delete Normal Delivery"))
	{
		DeleteNormalDelivery test1=new DeleteNormalDelivery();
		this.setVisible(false);
		test1.setVisible(true);
		test1.DeleteNormalDelivery();
	}
	if(arg.equals("Mergre short delivery"))
	{
		Mergeshortdelivery test1=new Mergeshortdelivery();
		this.setVisible(false);
		test1.setVisible(true);
		test1.Mergeshortdelivery();
	}
	if(arg.equals("Merge member"))
	{
		MergeMember test1=new MergeMember();
		this.setVisible(false);
		test1.setVisible(true);
		test1.MergeMember();
	}
	if(arg.equals("merge area"))
	{
		MergeArea test1=new MergeArea();
		this.setVisible(false);
		test1.setVisible(true);
		test1.MergeArea();
	}
	
    } 
}

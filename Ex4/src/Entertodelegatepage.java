import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ChoiceFormat;
import java.util.Map;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Entertodelegatepage extends JFrame implements ActionListener {
	public Entertodelegatepage() {
	}
	
	
	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblId;
	private JTextField textField_1;
	private JLabel lblQuantity;
	private JLabel lblDeliveryprice;
	private JLabel lblRecipientname;
	private JLabel lblRecupientphone;
	private JLabel lblDatedelivery;
	private JLabel lblOriginarea;
	private JLabel lblDestinationcity;
	private JLabel lblDistance;
	private JLabel lblPricekm;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_1;
	protected Choice countries= new Choice();
	protected JTextField select= new JTextField();
	protected int idmanager=0;
	private JTextField textField_11;
	protected JFrame frame2= new JFrame();
	protected JDialog jd = new JDialog(frame2 , "The Add is not succeded", false);
	Choice choicein = new Choice();
	public String in="";
	 public int helpid;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void  AddShortDelivery() {
		jd.getContentPane().add( new JLabel ("There is not enough space to add or the member is not found or a wrong data is Enter - add  is not succeded...")); 
		jd.getContentPane().setLayout( new FlowLayout() ); 
		jd.setSize(300,300);
		choicein.setBounds(0, 350, 275, 14);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(296, 531, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("object name");
		lblNewLabel.setBounds(127, 91, 500, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(217, 88, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblId = new JLabel("id");
		lblId.setBounds(406, 91, 46, 14);
		contentPane.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(492, 88, 86, 20);
		contentPane.add(textField_1);
		
		lblQuantity = new JLabel("quantity");
		lblQuantity.setBounds(127, 131, 500, 14);
		contentPane.add(lblQuantity);
		
		lblDeliveryprice = new JLabel("deliveryprice");
		lblDeliveryprice.setBounds(406, 131, 500, 14);
		contentPane.add(lblDeliveryprice);
		
		lblRecipientname = new JLabel("recipient name");
		lblRecipientname.setBounds(127, 171, 500, 14);
		contentPane.add(lblRecipientname);
		
		lblRecupientphone = new JLabel("recupient phone");
		lblRecupientphone.setBounds(406, 171, 500, 14);
		contentPane.add(lblRecupientphone);
		
		lblDatedelivery = new JLabel("date delivery");
		lblDatedelivery.setBounds(127, 214, 500, 14);
		contentPane.add(lblDatedelivery);
		
		lblOriginarea = new JLabel("origin area");
		lblOriginarea.setBounds(406, 214, 500, 14);
		contentPane.add(lblOriginarea);
		
		lblDestinationcity = new JLabel("destination city");
		lblDestinationcity.setBounds(127, 259, 500, 14);
		contentPane.add(lblDestinationcity);
		
		lblDistance = new JLabel("distance");
		lblDistance.setBounds(406, 259, 500, 14);
		contentPane.add(lblDistance);
		
		lblPricekm = new JLabel("pricekm");
		lblPricekm.setBounds(257, 308, 500, 14);
		contentPane.add(lblPricekm);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 128, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(492, 128, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(217, 168, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(492, 168, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(217, 211, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(492, 211, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(217, 256, 86, 20);
		contentPane.add(textField_8);
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(492, 256, 86, 20);
		contentPane.add(textField_9);	
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(346, 305, 86, 20);
		contentPane.add(textField_10);
		
		lblNewLabel_1 = new JLabel("click to show members list:");
		lblNewLabel_1.setBounds(0, 333, 275, 14);
		contentPane.add(lblNewLabel_1);
		for(Members r:DataBase.managerarr.get(Enterpage.count-1).arrmember.values())
		{
			 
			choicein.add(r.getMembername()+"--"+r.getId());  
			
		}
		getContentPane().add(choicein);
		btnNewButton.addActionListener(this);
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
			 jd.setVisible(true);
				this.setVisible(false);
				Choosepage test2=new Choosepage();
				test2.setVisible(true);
				test2.Choosepage();
		}
	String arg = ev.getActionCommand();
	if(arg.equals("Finish"))
	{
		try 
		{
			int i=Integer.parseInt(textField_9.getText());
		}
		catch (NumberFormatException n) {
		     System.out.println("wrong input .Please enter a number.");
				this.setVisible(false);
				jd.setVisible(true);
				Entertodelegate test2=new Entertodelegate();
				test2.setVisible(true);
				test2.Entertodelegate();
		}
		int idmanager=Enterpage.count;
		 EvenException ex = new EvenException();
		 try{
		ex.isEven(Integer.parseInt(textField_9.getText()));
		
		 }
		
		 catch(Exception e){
		System.out.println(e.getMessage());
		System.out.println(" The distance automatically becomes 30.");
		String textField_11="30";
		textField_9.setText(textField_11);
		 }
		 try 
			{
				double i=Double.parseDouble(textField_1.getText());
			}
			catch (NumberFormatException n) {
			     System.out.println("wrong input .Please enter a number.");
					this.setVisible(false);
					jd.setVisible(true);
					Entertodelegate test2=new Entertodelegate();
					test2.setVisible(true);
					test2.Entertodelegate();
			}
		 try 
			{
				double i=Double.parseDouble(textField_3.getText());
			}
			catch (NumberFormatException n) {
			     System.out.println("wrong input .Please enter a number.");
					this.setVisible(false);
					jd.setVisible(true);
					Entertodelegate test2=new Entertodelegate();
					test2.setVisible(true);
					test2.Entertodelegate();
			}
		 try 
			{
				int i=Integer.parseInt(textField_9.getText());
			}
			catch (NumberFormatException n) {
			     System.out.println("wrong input .Please enter a number.");
					this.setVisible(false);
					jd.setVisible(true);
					Entertodelegate test2=new Entertodelegate();
					test2.setVisible(true);
					test2.Entertodelegate();
			}
		 try 
			{
				double i=Double.parseDouble(textField_10.getText());
			}
			catch (NumberFormatException n) {
			     System.out.println("wrong input .Please enter a number.");
					this.setVisible(false);
					jd.setVisible(true);
					Entertodelegate test2=new Entertodelegate();
					test2.setVisible(true);
					test2.Entertodelegate();
			}
		 if(DataBase.delegatemanagerarr.get(Entertodelegate.countdelegatemanager-1).arrdelegate.size()<DataBase.delegatemanagerarr.get(Entertodelegate.countdelegatemanager-1).getDeliverynum()&&DataBase.managerarr.get(Enterpage.count-1).arrmember.get(helpid)!=null&&textField.getText()!=""&&textField_2.getText()!=""&&textField_4.getText()!=""&&textField_5.getText()!=""&&textField_6.getText()!=""&&textField_7.getText()!=""&&textField_8.getText()!=""&&DataBase.delegatemanagerarr.get(Entertodelegate.countdelegatemanager-1).arrdelegate.size()<Double.parseDouble(textField_1.getText()))
		 {
		NormalDelivery newshortdelivery=new Shortdeliveries(textField.getText(),Double.parseDouble(textField_1.getText()),textField_2.getText(),Double.parseDouble(textField_3.getText()),textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText(),textField_8.getText(),Integer.parseInt(textField_9.getText()),Double.parseDouble(textField_10.getText()));
		((Shortdeliveries)newshortdelivery).shortmember=DataBase.managerarr.get(idmanager-1).arrmember.get(helpid);
		DataBase.managerarr.get(idmanager-1).arrmember.get(helpid).arr.add(newshortdelivery);
		DataBase.delegatemanagerarr.get(Entertodelegate.countdelegatemanager-1).arrdelegate.add((Shortdeliveries)newshortdelivery);
		DataBase.ourLastDeliveries.put(DataBase.managerarr.get(idmanager-1).arrmember.get(helpid),newshortdelivery);
try(FileWriter f=new FileWriter("src\\Manager.txt",true);
				
	            BufferedWriter b=new BufferedWriter(f);
				 PrintWriter pw=new PrintWriter(b);){
				 pw.println("5"+"--"+Integer.toString(Enterpage.count)+"--"+Integer.toString(Entertodelegate.countdelegatemanager)+"--"+helpid+"--"+Double.parseDouble(textField_1.getText())+"--"+"Manager delegate number="+Integer.toString(Entertodelegate.countdelegatemanager)+"--"+"Member id="+Integer.parseInt(textField_10.getText())+"--"+"object name="+textField.getText()+"--"+"id delivery="+Double.parseDouble(textField_1.getText())+"--"+"quantity="+textField_2.getText()+"--"+"delivery price="+Double.parseDouble(textField_3.getText())+"--"+"recipient name="+textField_4.getText()+"--"+"recipient phone="+textField_5.getText()+"--"+"date delivery="+textField_6.getText()+"--"+"origin area="+textField_7.getText()+"--"+"destination city="+textField_8.getText()+"--"+"distance="+Integer.parseInt(textField_9.getText())+"--"+"pricekm="+Double.parseDouble(textField_10.getText())+"--");
				}
				catch(Exception w) {
					 w.printStackTrace();	
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
	public class EvenException {
		void isEven(int distance) throws Exception{
		if(distance>30)
		{
		throw new Shortexcaption();
		}
		}
		}
}

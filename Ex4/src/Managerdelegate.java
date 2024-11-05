import java.util.ArrayList;

public class Managerdelegate {
	protected String managerarea;
	protected Integer password;
	protected String managername;
	protected Integer deliverynum;
	public ArrayList<Shortdeliveries> arrdelegate= new ArrayList<Shortdeliveries>();
	public Managerdelegate(String managerarea, Integer password, String managername, Integer deliverynum) {
		super();
		this.managerarea = managerarea;
		this.password = password;
		this.managername = managername;
		this.deliverynum = deliverynum;
	}
	public String getManagerarea() {
		return managerarea;
	}
	public void setManagerarea(String managerarea) {
		this.managerarea = managerarea;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public Integer getDeliverynum() {
		return deliverynum;
	}
	public void setDeliverynum(Integer deliverynum) {
		this.deliverynum = deliverynum;
	}
	@Override
	public String toString() {
		return "Managerdelegate [managerarea=" + managerarea + ", password=" + password + ", managername=" + managername
				+ ", deliverynum=" + deliverynum + ", arrdelegate=" + arrdelegate + "]";
	}
	
}

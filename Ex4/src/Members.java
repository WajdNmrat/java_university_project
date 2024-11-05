
import java.util.ArrayList;
public class Members implements Comparable<Members> {
	protected String membername;
	protected String memberfamily;
	protected String memberarea;
	protected int id;
	public ArrayList<NormalDelivery> arr= new ArrayList<NormalDelivery>();
	public Members(String membername, String memberfamily, String memberarea, int id) {
		super();
		this.membername = membername;
		this.memberfamily = memberfamily;
		this.memberarea = memberarea;
		this.id = id;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberfamily() {
		return memberfamily;
	}
	public void setMemberfamily(String memberfamily) {
		this.memberfamily = memberfamily;
	}
	public String getmemberarea() {
		return memberarea;
	}
	public void setmemberarea(String memberarea) {
		this.memberarea = memberarea;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Members [membername=" + membername + ", memberfamily=" + memberfamily + ", city=" + memberarea + ", id=" + id
				;
	}
	@Override
	public int compareTo(Members o) {
		// TODO Auto-generated method stub
		return (memberfamily.compareTo(o.getMemberfamily()));
		
	}
}

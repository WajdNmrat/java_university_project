import java.util.HashMap;


public class Manager {
protected String managerarea;
protected Integer password;
protected String managername;
public HashMap<Integer, Members> arrmember= new HashMap<Integer,Members>();


public Manager(String managerarea, Integer password, String managername) {
	super();
	this.managerarea = managerarea;
	this.password = password;
	this.managername = managername;
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
@Override
public String toString() {
	return "Manager [managerarea=" + managerarea + ", password=" + password + ", managername=" + managername + "]";
}

}

public class WorkDelivery extends NormalDelivery {
protected String worktype;
protected String objectsize;
protected double deliverySecrecy;/*1-3 1:simplesecret- 2:middlesecret 3:hightsecret*/
public WorkDelivery(String objectname, double id, double price, String quantity, String placeofmanufacture,
		double deliveryprice, String recipientname, String recipientaddress, String recupientphone, String worktype,
		String objectsize, double deliverySecrecy) {
	super(objectname, id, price, quantity, placeofmanufacture, deliveryprice, recipientname, recipientaddress,
			recupientphone);
	this.worktype = worktype;
	this.objectsize = objectsize;
	this.deliverySecrecy = deliverySecrecy;
}
public String getWorktype() {
	return worktype;
}
public void setWorktype(String worktype) {
	this.worktype = worktype;
}
public String getObjectsize() {
	return objectsize;
}
public void setObjectsize(String objectsize) {
	this.objectsize = objectsize;
}
public double getDeliverySecrecy() {
	return deliverySecrecy;
}
public void setDeliverySecrecy(double deliverySecrecy) {
	this.deliverySecrecy = deliverySecrecy;
}
@Override
public String toString() {
	return "WorkDelivery [worktype=" + worktype + ", objectsize=" + objectsize + ", deliverySecrecy=" + deliverySecrecy
			+ ", objectname=" + objectname + "\n, id=" + id + ", price=" + price + ", quantity=" + quantity
			+ ", placeofmanufacture=" + placeofmanufacture + ", Deliveryprice=" + Deliveryprice + ", recipientname="
			+ recipientname + ", recipientaddress=" + recipientaddress + ", recupientphone=" + recupientphone + "]";
}

}

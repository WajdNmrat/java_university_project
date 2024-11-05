
public class ExpressDelivery extends NormalDelivery  {
protected String transporttype;
protected double deliverytime;
protected double ratetransmation;/*1-3 1:excelent 2:good 3:bad*/
public ExpressDelivery(String objectname, double id, double price, String quantity, String placeofmanufacture,
		double deliveryprice, String recipientname, String recipientaddress, String recupientphone,
		String transporttype, double deliverytime, double ratetransmation) {
	super(objectname, id, price, quantity, placeofmanufacture, deliveryprice, recipientname, recipientaddress,
			recupientphone);
	this.transporttype = transporttype;
	this.deliverytime = deliverytime;
	this.ratetransmation = ratetransmation;
}
public String getTransporttype() {
	return transporttype;
}
public void setTransporttype(String transporttype) {
	this.transporttype = transporttype;
}
public double getDeliverytime() {
	return deliverytime;
}
public void setDeliverytime(double deliverytime) {
	this.deliverytime = deliverytime;
}
public double getRatetransmation() {
	return ratetransmation;
}
public void setRatetransmation(double ratetransmation) {
	this.ratetransmation = ratetransmation;
}
@Override
public String toString() {
	return "ExpressDelivery [transporttype=" + transporttype + ", deliverytime=" + deliverytime + ", ratetransmation="
			+ ratetransmation + ", objectname=" + objectname + "\n, id=" + id + ", price=" + price + ", quantity="
			+ quantity + ", placeofmanufacture=" + placeofmanufacture + "\n, Deliveryprice=" + Deliveryprice
			+ ", recipientname=" + recipientname + ", recipientaddress=" + recipientaddress + ", recupientphone="
			+ recupientphone + "]";
}

}

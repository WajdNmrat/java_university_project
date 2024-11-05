
public class Shortdeliveries extends NormalDelivery {
protected String datedelivery;
protected String originarea;
protected String destinationcity;
protected Integer distance;
protected Double pricekm;
public Members shortmember;
public Shortdeliveries(String objectname, double id, String quantity,
		double deliveryprice, String recipientname, String recupientphone, String datedelivery,
		String originarea, String destinationcity, Integer distance, Double pricekm) {
	super(objectname, id,deliveryprice,quantity, originarea, deliveryprice, recipientname, destinationcity,
			recupientphone);
	this.datedelivery = datedelivery;
	this.originarea = originarea;
	this.destinationcity = destinationcity;
	this.distance = distance;
	this.pricekm = pricekm;
}
public String getDatedelivery() {
	return datedelivery;
}
public void setDatedelivery(String datedelivery) {
	this.datedelivery = datedelivery;
}
public String getOriginarea() {
	return originarea;
}
public void setOriginarea(String originarea) {
	this.originarea = originarea;
}
public String getDestinationcity() {
	return destinationcity;
}
public void setDestinationcity(String destinationcity) {
	this.destinationcity = destinationcity;
}
public Integer getDistance() {
	return distance;
}
public void setDistance(Integer distance) {
	this.distance = distance;
}
public Double getPricekm() {
	return pricekm;
}
public void setPricekm(Double pricekm) {
	this.pricekm = pricekm;
}
public Members getShortmember() {
	return shortmember;
}
public void setShortmember(Members shortmember) {
	this.shortmember = shortmember;
}
@Override
public String toString() {
	return "Shortdeliveries [datedelivery=" + datedelivery + ", originarea=" + originarea + ", destinationcity="
			+ destinationcity + ", distance=" + distance + ", pricekm=" + pricekm
			+ "]";
}

}

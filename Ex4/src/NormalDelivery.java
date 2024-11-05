	public class NormalDelivery {
	protected String objectname;
	protected double id;
	protected double price;
	protected String quantity;
	protected String placeofmanufacture;
	protected double Deliveryprice;
    protected String recipientname;
    protected String recipientaddress;
    protected String recupientphone;
	public NormalDelivery(String objectname, double id, double price, String quantity, String placeofmanufacture,
			double deliveryprice, String recipientname, String recipientaddress, String recupientphone) {
		super();
		this.objectname = objectname;
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.placeofmanufacture = placeofmanufacture;
		Deliveryprice = deliveryprice;
		this.recipientname = recipientname;
		this.recipientaddress = recipientaddress;
		this.recupientphone = recupientphone;
	}
	public String getObjectname() {
		return objectname;
	}
	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPlaceofmanufacture() {
		return placeofmanufacture;
	}
	public void setPlaceofmanufacture(String placeofmanufacture) {
		this.placeofmanufacture = placeofmanufacture;
	}
	public double getDeliveryprice() {
		return Deliveryprice;
	}
	public void setDeliveryprice(double deliveryprice) {
		Deliveryprice = deliveryprice;
	}
	public String getRecipientname() {
		return recipientname;
	}
	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}
	public String getRecipientaddress() {
		return recipientaddress;
	}
	public void setRecipientaddress(String recipientaddress) {
		this.recipientaddress = recipientaddress;
	}
	public String getRecupientphone() {
		return recupientphone;
	}
	public void setRecupientphone(String recupientphone) {
		this.recupientphone = recupientphone;
	}
	@Override
	public String toString() {
		return "NormalDelivery [objectname=" + objectname + ", id=" + id + ", price=" + price + ", quantity=" + quantity
				+ ", placeofmanufacture=" + placeofmanufacture + " , Deliveryprice=" + Deliveryprice + ", recipientname="
				+ recipientname + ", recipientaddress=" + recipientaddress + ", recupientphone=" + recupientphone + "]";
	}
	
}

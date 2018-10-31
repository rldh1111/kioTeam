package payment.service;



public class PaymentRequest {

	private int userId;
	private String userName;
	private int productId;
	private String productName;
	private int count;
	private int price;
	private String address;
	private String phone;
	private String url;

	public PaymentRequest(int userId, String userName, int productId, String productName, int count, int price,
			String address, String phone, String url) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
		this.count = count;
		this.price = price;
		this.address = address;
		this.phone = phone;
		this.url = url;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getUrl() {
		return url;
	}

}
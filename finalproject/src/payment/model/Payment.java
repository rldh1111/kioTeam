package payment.model;

import java.time.LocalDateTime;

public class Payment {
	private int paymentId;
	private int userId;
	private String userName;
	private int productId;
	private String productName;
	private int count;
	private int price;
	private String address;
	private String phone;
	private LocalDateTime wdate;
	private String url;

	public Payment(int paymentId, int userId, String userName, int productId, String productName, int count, int price,
			String address, String phone, LocalDateTime wdate, String url) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
		this.count = count;
		this.price = price;
		this.address = address;
		this.phone = phone;
		this.wdate = wdate;
		this.url = url;
	}
	
	public Payment(int userId, String userName, int productId, String productName, int count, int price, String address,
			String phone, String url) {
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

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
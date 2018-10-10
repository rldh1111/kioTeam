package payment.model;

public class Payment {
	private int paymentId;
	private int productId;
	private String productName;
	private int numbers;
	private String loginId;
	private String userName;
	private String address;
	private String phone;

	public Payment(int paymentId, int productId, String productName, int numbers, String loginId, String userName,
			String address, String phone) {
		this.paymentId = paymentId;
		this.productId = productId;
		this.productName = productName;
		this.numbers = numbers;
		this.loginId = loginId;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}

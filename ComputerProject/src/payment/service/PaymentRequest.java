package payment.service;

import java.util.ArrayList;

import shopping.model.Shopping;

public class PaymentRequest {
	private int productId;
	private String productName;
	private int numbers;
	private int price;
	private int userId;
	private String loginId;
	private String userName;
	private String address;
	private String phone;



	public PaymentRequest(int productId, String productName, int numbers, int price, int userId, String loginId,
			String userName, String address, String phone) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.numbers = numbers;
		this.price = price;
		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getNumbers() {
		return numbers;
	}

	public int getPrice() {
		return price;
	}

	public int getUserId() {
		return userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getUserName() {
		return userName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}



}

package payment.service;

import java.util.ArrayList;

import shopping.model.Shopping;

public class PaymentRequest {
	private int paymentId;
	private int productId;
	private String productName;
	private int numbers;
	private String loginId;
	private String userName;
	private String address;
	private String phone;
	private ArrayList<Shopping> shoppings = new ArrayList<>();

	public PaymentRequest(int paymentId, int productId, String productName, int numbers, String loginId,
			String userName, String address, String phone, ArrayList<Shopping> shoppings) {
		super();
		this.paymentId = paymentId;
		this.productId = productId;
		this.productName = productName;
		this.numbers = numbers;
		this.loginId = loginId;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.shoppings = shoppings;
	}

	public int getPaymentId() {
		return paymentId;
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

	public ArrayList<Shopping> getShoppings() {
		return shoppings;
	}

}

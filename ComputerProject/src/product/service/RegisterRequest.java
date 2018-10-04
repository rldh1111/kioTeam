package product.service;

public class RegisterRequest {
	private String name;
	private String productType;
	private int price;
	private String explanation;

	public RegisterRequest(String name, String productType, int price, String explanation) {
		super();
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
	}

	public String getName() {
		return name;
	}

	public String getProductType() {
		return productType;
	}

	public int getPrice() {
		return price;
	}

	public String getExplanation() {
		return explanation;
	}

}

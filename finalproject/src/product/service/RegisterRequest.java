package product.service;

public class RegisterRequest {
	private String name;
	private String type;
	private String productType;
	private int price;
	private String explanation;
	private String url;

	public RegisterRequest(String name, String type, String productType, int price, String explanation, String url) {
		super();
		this.name = name;
		this.type = type;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
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

	public String getUrl() {
		return url;
	}

}

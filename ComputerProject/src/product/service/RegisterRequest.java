package product.service;

public class RegisterRequest {
	private String name;
	private String productType;
	private int price;
	private String explanation;
	private String url;

	public RegisterRequest(String name, String productType, int price, String explanation, String url) {
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

}

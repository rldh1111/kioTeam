package product.service;

public class ModifyRequest {
	private int productId;
	private String name;
	private String productType;
	private int price;
	private String explanation;

	public ModifyRequest(int productId, String name, String productType, int price, String explanation) {
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
	}

	public int getProductId() {
		return productId;
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

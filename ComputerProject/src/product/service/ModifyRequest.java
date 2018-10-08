package product.service;

public class ModifyRequest {
	private int productId;
	private String name;
	private String productType;
	private int price;
	private String explanation;
	private String url;

	public ModifyRequest(int productId, String name, String productType, int price, String explanation, String url) {
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

}

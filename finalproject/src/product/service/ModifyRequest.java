package product.service;

public class ModifyRequest {
	private int productId;
	private String type;
	private String productName;
	private String productType;
	private int price;
	private String explanation;
	private String url;

	public ModifyRequest(int productId, String type, String productName, String productType, int price,
			String explanation, String url) {
		super();
		this.productId = productId;
		this.type = type;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.explanation = explanation;
		this.url = url;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
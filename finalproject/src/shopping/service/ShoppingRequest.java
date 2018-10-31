package shopping.service;

public class ShoppingRequest {

	private int userId;
	private String userName;
	private int productId;
	private String productType;
	private String productName;
	private int price;
	private int count;
	private String explanation;
	private String url;

	public ShoppingRequest(int userId, String userName, int productId, String productType, String productName,
			int price, int count, String explanation, String url) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.price = price;
		this.count = count;
		this.explanation = explanation;
		this.url = url;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getUrl() {
		return url;
	}

}
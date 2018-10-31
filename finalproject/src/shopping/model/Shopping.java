package shopping.model;

import java.time.LocalDateTime;

public class Shopping {
	private int shoppingId;
	private int userId;
	private String userName;
	private int productId;
	private String productType;
	private String productName;
	private int price;
	private LocalDateTime wdate;
	private int count;
	private String explanation;
	private String url;

	public Shopping(int shoppingId, int userId, String userName, int productId, String productType, String productName,
			int price, LocalDateTime wdate, int count, String explanation, String url) {
		super();
		this.shoppingId = shoppingId;
		this.userId = userId;
		this.userName = userName;
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.price = price;
		this.wdate = wdate;
		this.count = count;
		this.explanation = explanation;
		this.url = url;
	}

	public Shopping(int userId, String userName, int productId, String productType, String productName, int price,
			int count, String explanation, String url) {
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

	public int getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(int shoppingId) {
		this.shoppingId = shoppingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
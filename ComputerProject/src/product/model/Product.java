package product.model;

import java.time.LocalDateTime;

public class Product {

	private int productId;
	private String name;
	private String productType;
	private int price;
	private LocalDateTime wdate;
	private LocalDateTime udate;
	private String explanation;
	private String url;

	public Product(int productId, String name, String productType, int price, LocalDateTime wdate, LocalDateTime udate,
			String explanation, String url) {
		super();
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.wdate = wdate;
		this.udate = udate;
		this.explanation = explanation;
		this.url = url;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public LocalDateTime getUdate() {
		return udate;
	}

	public void setUdate(LocalDateTime udate) {
		this.udate = udate;
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

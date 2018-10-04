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

	public Product(int productId, String name, String productType, int price, LocalDateTime wdate, LocalDateTime udate,
			String explanation) {
		super();
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.price = price;
		this.wdate = wdate;
		this.udate = udate;
		this.explanation = explanation;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public void setUdate(LocalDateTime udate) {
		this.udate = udate;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}

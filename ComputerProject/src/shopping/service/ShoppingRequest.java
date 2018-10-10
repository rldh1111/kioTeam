package shopping.service;

public class ShoppingRequest {
	private int productId;
	private String productType;
	private String loginId;
	private String productname;
	private int price;
	private int count;

	public ShoppingRequest(int productId,String productType, String loginId, String productname, int price, int count) {
		super();
		this.productId = productId;
		this.productType=productType;
		this.loginId = loginId;
		this.productname = productname;
		this.price = price;
		this.count = count;
	}

	public int getProductId() {
		return productId;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getProductname() {
		return productname;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public String getProductType() {
		return productType;
	}

}

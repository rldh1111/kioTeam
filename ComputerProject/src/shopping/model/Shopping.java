package shopping.model;

import java.time.LocalDateTime;

public class Shopping {
	private int productId;
	private String productType;
	private String loginId;
	private String productname;
	private int price;
	private LocalDateTime wdate;
	private int count;
	public Shopping(int productId,String productType, String loginId, String productname, int price, LocalDateTime wdate, int count) {
		this.productId = productId;
		this.productType=productType;
		this.loginId = loginId;
		this.productname = productname;
		this.price = price;
		this.wdate = wdate;
		this.count = count;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

	
	
	
	
	
	
}

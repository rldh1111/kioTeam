package shopping.service;

public class ModifyRequest {
	private int productId;
	private int count;
	public ModifyRequest(int productId, int count) {
		this.productId = productId;
		this.count = count;
	}
	public int getProductId() {
		return productId;
	}
	public int getCount() {
		return count;
	}
}

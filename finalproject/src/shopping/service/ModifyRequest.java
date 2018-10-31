package shopping.service;

public class ModifyRequest {
	private int userId;
	private int productId;
	private int count;

	public ModifyRequest(int userId, int productId, int count) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.count = count;
	}

	public int getUserId() {
		return userId;
	}

	public int getProductId() {
		return productId;
	}

	public int getCount() {
		return count;
	}

}

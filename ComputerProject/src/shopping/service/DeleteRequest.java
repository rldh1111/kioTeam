package shopping.service;

public class DeleteRequest {
	private int productId;

	public DeleteRequest(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

}

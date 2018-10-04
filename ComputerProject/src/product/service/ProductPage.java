package product.service;

public class ProductPage {
	private static ProductPage instance = new ProductPage();

	public static ProductPage getInstance() {
		return instance;
	}

	private ProductPage() {

	}
}

package product.service;
import java.util.List;
import product.model.Product;

public class ProductPage {
	private static ProductPage instance = new ProductPage();

	public static ProductPage getInstance() {
		return instance;
	}

	private ProductPage() {

	}

	private List<Product> products;
	private int currentPage;
	private int totalPages;
	private int total;//
	private int startPage;
	private int endPage;

	public ProductPage(List<Product> products, int currentPage, int total, int size, int blockSize) {
		this.products = products;
		this.currentPage = currentPage;
		this.total = total;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			startPage = currentPage / blockSize * blockSize + 1;
			if ((currentPage % blockSize == 0)) {
				startPage -= blockSize;
			}
			endPage = startPage + (blockSize - 1);
			if (endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	public boolean hasProducts() {
		return total > 0;
	}
	public List<Product> getProducts() {
		return products;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotal() {
		return total;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

}

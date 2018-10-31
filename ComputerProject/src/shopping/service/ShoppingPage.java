package shopping.service;

import java.util.List;

import shopping.model.Shopping;

public class ShoppingPage {
	private List<Shopping> shoppings;
	private int currentPage;
	private int totalPages;
	private int total;
	private int startPage;
	private int endPage;
	public ShoppingPage(List<Shopping> shoppings, int currentPage, int total, int size, int blockSize) {
		this.shoppings = shoppings;
		this.currentPage = currentPage;
		this.total=total;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
			
		}else {
			totalPages = total/size;
			if(total % size > 0) {
				totalPages++;
			}
			startPage = currentPage /blockSize * blockSize + 1;
			if((currentPage % blockSize)==0) {
				startPage -= blockSize;
			}
			
			endPage = startPage + (blockSize-1);
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			
		}
	}
	
	public boolean hasProduct() {
		return total > 0;
	}
	public List<Shopping> getShoppings() {
		return shoppings;
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

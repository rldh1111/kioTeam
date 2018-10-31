package payment.service;

import java.util.ArrayList;
import java.util.List;

import payment.model.Payment;
import product.model.Product;

public class PaymentPage {
	private static PaymentPage instance = new PaymentPage();

	public static PaymentPage getInstance() {
		return instance;
	}

	private PaymentPage() {

	}
	private ArrayList<Payment> payments;
	private int currentPage;
	private int totalPages;
	private int total;//
	private int startPage;
	private int endPage;

	public PaymentPage(ArrayList<Payment> payments, int currentPage, int total, int size, int blockSize) {
		this.payments = payments;
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

	public List<Payment> getPayments() {
		return payments;
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

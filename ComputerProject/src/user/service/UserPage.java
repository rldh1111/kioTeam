package user.service;

import java.util.ArrayList;
import java.util.List;

import user.model.User;

public class UserPage {
	private static UserPage instance = new UserPage();

	public static UserPage getInstance() {
		return instance;
	}

	private UserPage() {
	System.out.println();
	}

	private List<User> users;
	private int currentPage;
	private int totalPages;
	private int total;//
	private int startPage;
	private int endPage;

	public UserPage(List<User> users, int currentPage, int total, int size, int blockSize) {
		this.users = users;
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

	public boolean hasUsers() {
		return total > 0;
	}

	public List<User> getUsers() {
		return users;
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

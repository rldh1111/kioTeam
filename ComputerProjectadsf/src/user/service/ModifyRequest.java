package user.service;

public class ModifyRequest {
	private int userId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phone;

	public ModifyRequest(int userId, String name, String password, String address, String email, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getUserId() {
		return userId;
	}

}

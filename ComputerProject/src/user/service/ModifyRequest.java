package user.service;

public class ModifyRequest {
	private int userId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String question;
	private String answer;

	public ModifyRequest(int userId, String name, String password, String address, String email, String phone,
			String question, String answer) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;

	}

	public int getUserId() {
		return userId;
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

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

}
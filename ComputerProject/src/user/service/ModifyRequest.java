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
		super();
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

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
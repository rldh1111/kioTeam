package user.service;

public class JoinRequest {
	private String userType;
	private String loginId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String question;
	private String answer;

	public JoinRequest(String userType, String loginId, String name, String password, String address, String email,
			String phone, String question, String answer) {
		super();
		this.userType = userType;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;

	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

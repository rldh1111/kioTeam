package user.model;

import java.time.LocalDateTime;

public class User {
	private int userId;
	private String userType;
	private String name;
	private String loginId;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String question;
	private String answer;
	private LocalDateTime wdate;

	public User(int userId, String userType, String name, String loginId, String password, String address, String email,
			String phone, String question, String answer, LocalDateTime wdate) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.wdate = wdate;
	}

	public User(String userType, String name, String loginId, String password, String address, String email,
			String phone, String question, String answer) {
		super();
		this.userType = userType;
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
	}
	public User(String loginId) {
		this.loginId = loginId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
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

	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

}

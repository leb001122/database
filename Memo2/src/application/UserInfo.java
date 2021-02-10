package application;

public class UserInfo {
	private String name;
	private String id;
	private String password;
	
	public UserInfo (String name, String id, String password){
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPW(String pw) {
		this.password = pw;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPW() {
		return password;
	}
}

package application;

public class UserInfo {
	private String name;
	private String id;
	private String password;
	private static UserInfo userInfo;         
	
	public static UserInfo getInstance()
	{
		if(userInfo == null)
		{
			userInfo = new UserInfo();
		}
		return userInfo;
		
	}
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
	public String getPassWord()
	{
		return password; 
	}
	public void setName(String name) 
	{
		this.name = name; 
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public void setPassWord(String pw) 
	{
		password = pw;
	}

}

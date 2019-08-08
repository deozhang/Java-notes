package entity;

public class Admin {
	private int id;
	private String username;
	private String password;
	private String realname;
	public int getId() {
		return id;
	}
	public Admin() {
		super();
	}
	public Admin(String username, String password, String realname) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	public Admin(int id, String username, String password, String realname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
}

package at.co.rre.kanban.hibernate;

public class SimpleEntity {
	
	private Long id;
	
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}

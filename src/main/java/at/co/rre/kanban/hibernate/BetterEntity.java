package at.co.rre.kanban.hibernate;

public class BetterEntity {
	
	private Long id;
	
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}

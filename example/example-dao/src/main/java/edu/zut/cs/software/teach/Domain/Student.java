package edu.zut.cs.software.teach.Domain;

public class Student {
	
	/**
	 * code of student
	 */
	private String code;
	
	/**
	 * id of student
	 */
	private String id;

	/**
	 * name of student
	 */
	private String name;

	/**
	 * adress of student
	 */
	private String adress;

	/**
	 * gender of student
	 */
	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

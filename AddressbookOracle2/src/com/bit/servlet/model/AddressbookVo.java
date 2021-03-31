package com.bit.servlet.model;



public class AddressbookVo  {
    


	private Long no;
	private String name;
	private String tel;
	private String hp;
	
	public AddressbookVo() {
	}

	public AddressbookVo(Long no, String name,  String tel,  String hp) {
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.hp = hp ;
		
	}
	public AddressbookVo( String name,  String tel,  String hp) {
		
		this.name = name;
		this.tel = tel;
		this.hp = hp ;
		
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel =tel;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", tel=" + tel + ", hp=" + hp +" ]";
	}




}

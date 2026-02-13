package chap13.hashmap;

/*
 * 	연락처 정보
 * 		- 필드: 이름, 그룹, 전화번호
 */
public class Contact {
	
	private String name;
	private String phone;
	private String group;
	
	public Contact(String name, String phone, String group) {
		//super();
		this.name = name;
		this.phone = phone;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getGroup() {
		return group;
	}

	
	public void setPhone(String phone) {	// 전화번호 변경
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("%-6s | %13s | %s", name, phone, group);
	}	
}

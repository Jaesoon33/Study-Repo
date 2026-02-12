package chap11.object;

/*
 * 	hashCode() 재정의를 하지 않은 Member 클래스
 */

public class Member {
	private String id;
	private String name;
	private int age;
	public Member(String id, String name, int age) {
		//.super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		MemberFixed other = (MemberFixed)obj;
		return this.id != null && this.id.equals((other.);	//
	}
	
	// eq0uals()만 재정의
	
	
}

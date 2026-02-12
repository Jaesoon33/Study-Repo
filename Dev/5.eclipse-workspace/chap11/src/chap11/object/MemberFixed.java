package chap11.object;

/*
 * 	hashCode()를 올바르게 재정의한 Member 클래스
 * 		- equals()를 재정의 (id 기반 비교)
 * 		- hashCod()도 같은 필드로 재정의
 */


import java.util.Objects;

/*
	 * 	hashCode() 재정의를 하지 않은 Member 클래스
	 */

	public class MemberFixed {
		private String id;
		private String name;
		private int age;
		public MemberFixed(String id, String name, int age) {
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
			return this.id != null && this.id.equals((id);
		}

		
		
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public String toString() {
			return String.format("Member{id= '%s', name = '%s', age='%s'}", id, name, age);
		}
		
		
		
			}


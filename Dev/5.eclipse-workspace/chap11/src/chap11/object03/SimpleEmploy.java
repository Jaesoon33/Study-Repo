package chap11.object03;

import java.util.Objects;

public class SimpleEmploy {
	private final String empId;
	private String name;
	
	public SimpleEmploy(String empId, String name) {
		//super();
		this.empId = empId;
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(empId);		// empId 값을 기준으로 hash값 생성, 만약 empId값이 동일하면 동일한 hash값을 가짐
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;	// 같은 객체면 true를 바로 출력 (굳이 필드를 비교할 필요 X)
		if(obj == null || getClass() != obj.getClass()) return false;		// null이거나 다른 타입이면 false
		SimpleEmploy other = (SimpleEmploy)obj;	// 다운캐스팅
		return Objects.equals(empId, other.empId);		// 사번끼리 비교
	}

	@Override
	public String toString() {
		return "SimpleEmployee{empId = '"+ empId +"', nmae = '"+ name +"' "; 
	}
	
	
	
}

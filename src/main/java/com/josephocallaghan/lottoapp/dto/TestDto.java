package com.josephocallaghan.lottoapp.dto;

public class TestDto {
	
	private String test1;
	private Integer test2;
	
	public TestDto(String test1, Integer test2) {
		super();
		this.test1 = test1;
		this.test2 = test2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestDto [test1=").append(test1).append(", test2=").append(test2).append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((test1 == null) ? 0 : test1.hashCode());
		result = prime * result + ((test2 == null) ? 0 : test2.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDto other = (TestDto) obj;
		if (test1 == null) {
			if (other.test1 != null)
				return false;
		} else if (!test1.equals(other.test1))
			return false;
		if (test2 == null) {
			if (other.test2 != null)
				return false;
		} else if (!test2.equals(other.test2))
			return false;
		return true;
	}
	
	public String getTest1() {
		return test1;
	}
	
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	
	public Integer getTest2() {
		return test2;
	}
	
	public void setTest2(Integer test2) {
		this.test2 = test2;
	}

}

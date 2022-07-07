package com.springboot.batch.model;

public class Employee {

	
		private Integer EMPLOYEE_ID;
		private String FIRST_NAME;
		private String LAST_NAME;
		private String EMAIL;
		private String PHONE_NUMBER;
		private String HIRE_DATE;
		private String JOB_ID;
		private String SALARY;
		private String COMMISSION_PCT;
		private Integer MANAGER_ID;
		private Integer DEPARTMENT_ID;
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getEMPLOYEE_ID() {
			return EMPLOYEE_ID;
		}
		public void setEMPLOYEE_ID(Integer eMPLOYEE_ID) {
			EMPLOYEE_ID = eMPLOYEE_ID;
		}
		public String getFIRST_NAME() {
			return FIRST_NAME;
		}
		public void setFIRST_NAME(String fIRST_NAME) {
			FIRST_NAME = fIRST_NAME;
		}
		
		public String getLAST_NAME() {
			return LAST_NAME;
		}
		public void setLAST_NAME(String lAST_NAME) {
			LAST_NAME = lAST_NAME;
		}
		public String getEMAIL() {
			return EMAIL;
		}
		public void setEMAIL(String eMAIL) {
			EMAIL = eMAIL;
		}
		public String getPHONE_NUMBER() {
			return PHONE_NUMBER;
		}
		public void setPHONE_NUMBER(String pHONE_NUMBER) {
			PHONE_NUMBER = pHONE_NUMBER;
		}
		public String getHIRE_DATE() {
			return HIRE_DATE;
		}
		public void setHIRE_DATE(String hIRE_DATE) {
			HIRE_DATE = hIRE_DATE;
		}
		public String getJOB_ID() {
			return JOB_ID;
		}
		public void setJOB_ID(String jOB_ID) {
			JOB_ID = jOB_ID;
		}
		public String getSALARY() {
			return SALARY;
		}
		public void setSALARY(String sALARY) {
			SALARY = sALARY;
		}
		public String getCOMMISSION_PCT() {
			return COMMISSION_PCT;
		}
		public void setCOMMISSION_PCT(String cOMMISSION_PCT) {
			COMMISSION_PCT = cOMMISSION_PCT;
		}
		public Integer getMANAGER_ID() {
			return MANAGER_ID;
		}
		public void setMANAGER_ID(Integer mANAGER_ID) {
			MANAGER_ID = mANAGER_ID;
		}
		public Integer getDEPARTMENT_ID() {
			return DEPARTMENT_ID;
		}
		public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
			DEPARTMENT_ID = dEPARTMENT_ID;
		}
		public Employee(Integer eMPLOYEE_ID, String fIRST_NAME, String lAST_NAME, String eMAIL, String pHONE_NUMBER,
				String hIRE_DATE, String jOB_ID, String sALARY, String cOMMISSION_PCT, Integer mANAGER_ID,
				Integer dEPARTMENT_ID) {
			super();
			EMPLOYEE_ID = eMPLOYEE_ID;
			FIRST_NAME = fIRST_NAME;
			LAST_NAME = lAST_NAME;
			EMAIL = eMAIL;
			PHONE_NUMBER = pHONE_NUMBER;
			HIRE_DATE = hIRE_DATE;
			JOB_ID = jOB_ID;
			SALARY = sALARY;
			COMMISSION_PCT = cOMMISSION_PCT;
			MANAGER_ID = mANAGER_ID;
			DEPARTMENT_ID = dEPARTMENT_ID;
		}
		@Override
		public String toString() {
			return "Employee [EMPLOYEE_ID=" + EMPLOYEE_ID + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
					+ ", EMAIL=" + EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + ", HIRE_DATE=" + HIRE_DATE + ", JOB_ID="
					+ JOB_ID + ", SALARY=" + SALARY + ", COMMISSION_PCT=" + COMMISSION_PCT + ", MANAGER_ID="
					+ MANAGER_ID + ", DEPARTMENT_ID=" + DEPARTMENT_ID + "]";
		}
}

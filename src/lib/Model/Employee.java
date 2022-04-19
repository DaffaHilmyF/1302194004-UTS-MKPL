package lib.Model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import lib.TaxFunction;

public class Employee {

	private User employeeDetail;
	private String employeeId;
	private String idNumber;
	private boolean isForeigner;
	private LocalDate dateJoined;
	private int monthWorkingInYear;
	private Spouse employeeSpouse;
	private List<Child> childList;

	public Employee(String employeeId, String idNumber, Spouse emplSpouse, User emplDetail) {
		this.employeeDetail = emplDetail;
		this.employeeId = employeeId;
		this.idNumber = idNumber;
		this.employeeSpouse = emplSpouse;
		this.childList = new LinkedList<Child>();
	}

	

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - date.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				employeeSpouse.getId().equals(""), childList.size());
	}
}

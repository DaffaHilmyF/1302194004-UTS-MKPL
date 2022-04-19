package lib.Model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

import lib.TaxFunction;

public class Employee {

	private String employeeId;
	private User employeeDetail;
	private Spouse employeeSpouse;
	private List<Child> employeeChild;
	private LocalDate employeeDateJoined;
	private int monthWorkingInYear;

	public Employee(User employeeDetail, Spouse employeeSouse, List<Child> employeeChild) {
		this.employeeId = UUID.randomUUID().toString();
		this.employeeDetail = employeeDetail;
		this.employeeSpouse = employeeSouse;
		this.employeeChild = employeeChild;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public User getEmployeeDetail() {
		return this.employeeDetail;
	}

	public Spouse getEmployeeSpouse() {
		return this.employeeSpouse;
	}

	public List<Child> getEmployeeChild() {
		return this.employeeChild;
	}

	public LocalDate getEmployeDateJoined() {
		return this.employeeDateJoined;
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == employeeDateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - date.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}
		return 0;
		// return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome,
		// monthWorkingInYear, annualDeductible,
		// employeeSpouse.getId().equals(""), childList.size());
	}
}

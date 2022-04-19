package lib.Model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import lib.TaxFunction;

public class Employee {

	private User employeeDetail;
	private Spouse employeeSpouse;
	private List<Child> employeeChild;

	private String employeeId;
	private boolean isForeigner;
	private LocalDate dateJoined;
	private int monthWorkingInYear;

	public Employee(User employeeDetail, Spouse employeeSouse, List<Child> employeeChild) {
		this.employeeId = UUID.randomUUID().toString();
		this.employeeDetail = employeeDetail;
		this.employeeSpouse = employeeSouse;
		this.employeeChild = employeeChild;
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

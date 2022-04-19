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

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		} else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		} else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
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

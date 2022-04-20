package lib;

import lib.Model.Employee;
import lib.Model.Salary;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah
	 * sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya
	 * ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

	static private int getNumberOfChildren(Employee employee) {
		int numberOfChildren = employee.getEmployeeChild().size();
		return (numberOfChildren > 3) ? 3 : numberOfChildren;
	}

	static private int getTaxFromMarriedEmployee(Employee employee, Salary salary) {
		int numberOfChildren = getNumberOfChildren(employee);

		return (int) Math.round(0.05
				* (((salary.getMonthlyIncome() + salary.getOtherMonthlyIncome()) * employee.getMonthWorkingInYear())
						- salary.getAnnualDeductible()
						- (54000000 + 4500000 + (numberOfChildren * 1500000))));
	}

	static private int getTaxFromUnmarriedEmployee(Employee employee, Salary salary) {

		return (int) Math.round(
				0.05 * (((salary.getMonthlyIncome() + salary.getOtherMonthlyIncome())
						* employee.getMonthWorkingInYear()) - salary.getAnnualDeductible() - 54000000));
	}

	public static int calculateTax(Employee employee, Salary salary) {

		int tax = 0;
		boolean isMarried = employee.getEmployeeSpouse().getId().equals("");

		if (employee.getMonthWorkingInYear() > 12) {
			System.err.println("More than 12 month working per year");
		}

		tax = (isMarried) ? getTaxFromMarriedEmployee(employee, salary) : getTaxFromUnmarriedEmployee(employee, salary);

		if (tax < 0)
			return 0;

		return tax;

	}

}

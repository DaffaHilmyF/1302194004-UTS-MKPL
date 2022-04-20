package lib;

import lib.Model.Employee;
import lib.Model.Salary;

public class TaxFunction {

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

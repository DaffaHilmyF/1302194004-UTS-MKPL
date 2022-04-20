package lib.Model;

public class Salary {
    public enum SalaryGrade {
        GRADE_ONE,
        GRADE_TWO,
        GRADE_THREE,
    }

    private int[] salaryRange = { 3000000, 5000000, 7000000 };

    private int monthlyIncome;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Salary(int otherMontlyIncome, int annualDeductible) {
        this.annualDeductible = annualDeductible;
        this.setOtherMonthlyIncome(otherMontlyIncome);
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.setOtherMonthlyIncome(income);
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
     * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
     * 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    private void setMonthlyIncomeForForigner() {
        int montlyIncome = getMonthlyIncome();
        setMonthlyIncome((int) (montlyIncome * 1.5));
    }

    public void setMonthlySalary(SalaryGrade grade, boolean isForeigner) {
        int getIncomeFromGrade = salaryRange[(int) grade.ordinal()];
        setMonthlyIncome(getIncomeFromGrade);

        if(isForeigner){
            setMonthlyIncomeForForigner();
        }
    }
}

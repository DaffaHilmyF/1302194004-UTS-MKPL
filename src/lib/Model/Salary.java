package lib.Model;

public class Salary {
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

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
     * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
     * 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    public void setMonthlySalary(int grade, boolean isForeigner) {
        if (grade == 1) {
            setMonthlyIncome(3000000);
            if (isForeigner) {
                setMonthlyIncome((int) (3000000 * 1.5));
            }
        } else if (grade == 2) {
            setMonthlyIncome(5000000);
            if (isForeigner) {
                setMonthlyIncome((int) (3000000 * 1.5));
            }
        } else if (grade == 3) {
            setMonthlyIncome(7000000);
            if (isForeigner) {
                setMonthlyIncome((int) (3000000 * 1.5));
            }
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.setOtherMonthlyIncome(income);
    }

}

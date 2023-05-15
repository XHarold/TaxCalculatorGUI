public class TaxCalculator {
    private double tax;

    public void calculateTax(double income) {

        // 用简单的if-else语句判断区间，计算税收并将结果保存在tax变量中
        if (income >= 0 && income <3000){
            tax = income * 0.03;
        } else if (income > 3000 && income <= 12000) {
            tax = 210 + (income-3000) * 0.1;
        } else if (income > 12000 && income <= 25000) {
            tax = 1620 + (income-12000) * 0.2;
        } else if (income > 25000 && income <= 35000) {
            tax = 4280 + (income-25000) * 0.25;
        } else if (income > 35000 && income <= 55000) {
            tax = 8690 + (income-35000) * 0.3;
        } else if (income > 55000 && income <= 80000) {
            tax = 15850 + (income-55000) * 0.35;
        } else if (income > 80000) {
            tax = 31010 + (income-80000) * 0.45;
        }
    }

    public double getTax() {
        return tax;
    }
}

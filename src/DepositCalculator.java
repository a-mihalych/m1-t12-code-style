import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double amountEndPeriod = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundingWithGivenPrecision(amountEndPeriod, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundingWithGivenPrecision(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundingWithGivenPrecision(double value, int accuracy) {
        double scale = Math.pow(10, accuracy);
        return Math.round(value * scale) / scale;
    }

    void calculateSavingsOnDeposit() {
        int period;
        int typeDeposit;
        int amount;
        double out = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeDeposit = scanner.nextInt();
        if (typeDeposit == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (typeDeposit == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateSavingsOnDeposit();
    }
}

import java.util.BitSet;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbersGenerator {

    public static BitSet getPrimaryNumbers(int upperBound) { //алгоритм эрастосфена не может дать требуемой скорости(возможно кроме сегментированного)
        // но алгоритм Аткина работает намного быстрей, поэтому реализуем его
        BitSet primaryNumbers = new BitSet(); //создаем битовый массив для хранения факта того, что число является простым
        double upperBoundSqrt = sqrt(upperBound);
        for (int x = 1; x <= upperBoundSqrt; x++) {
            for (int y = 1, n; y <= upperBoundSqrt; y++) {
                /* Существует теорема. Пусть n — натуральное число, которое не делится ни на какой полный квадрат. Тогда
                если n представимо в виде 4k+1, то оно просто тогда и только тогда, когда число натуральных решений уравнения 4x2+y2 = n нечетно.
                если n представимо в виде 6k+1, то оно просто тогда и только тогда, когда число натуральных решений уравнения 3x2+y2 = n нечетно.
                если n представимо в виде 12k-1, то оно просто тогда и только тогда, когда число натуральных решений уравнения 3x2−y2 = n,
                для которых x > y, нечетно.
                ссылка на доказательство http://www.ams.org/journals/mcom/2004-73-246/S0025-5718-03-01501-1/S0025-5718-03-01501-1.pdf
                Я, кончено, старался, но так до конца его и не понял

                Подбираем такие числа x и y, что результат решения уравнений по модулю 12 имеет нужный нам остаток:
                4x^2 + y^2  - остаток 1 или 5
                3x^2 + y^2 - остаток 7
                3x^2 - y^2 - остаток 11;
                если такие числа подобраны, то результат решения помечается, как простое;
                если резутат решения уже помечен(как простое число), то оно помечается, как составное(не простое) */
                n = 4*x*x + y*y;
                if (((n % 12 == 1) || (n % 12 == 5)) && (n <= upperBound)) primaryNumbers.flip(n);
                n -= x*x;
                if ((n % 12 == 7) && (n <= upperBound)) primaryNumbers.flip(n);
                if (x > y) {
                    n -= 2*y*y;
                    if ((n % 12 == 11) && (n <= upperBound)) primaryNumbers.flip(n);
                }
            }
        }
        /* Предварительное просеиваение, к сожалению, пропускает числа, кратные квадрату простого числа, поэтому
        мы должны отдельно пометить их, как не простые*/
        int   squareOfNumber;
        for (int number = 5; number <= upperBoundSqrt; number++) {
            if (primaryNumbers.get(number)) {
                squareOfNumber = number * number;
                for (int i = squareOfNumber; i <= upperBound; i += squareOfNumber) primaryNumbers.set(i, false);
            }
        }
        /* Так как мы находим остаток от деления на 12(удвоенное призведение простых чисел 2 и 3), то
         нам нужно пометить их, как заведомо простые числа
        допустим, если бы мы брали остатки деления на 60 ( 2*(2*3*5) ), то мы должны были бы учитывать и 5 */
        if (upperBound >= 2) primaryNumbers.set(2, true);
        if (upperBound >= 3) primaryNumbers.set(3, true);
        return primaryNumbers;
    }

    public static void main(String[] args) {
        String usageString = "Usage: java PrimeNumbersGenerator <number from the range 0..100000000>";
        if (args.length != 1) {
            System.out.println(usageString);
            System.exit(1);
        }
        int upperBound = 0;
        try {
            upperBound = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(usageString);
            System.exit(1);
        }
        if (upperBound > 100000000 || upperBound < 0) {
            System.out.println(usageString);
            System.exit(1);
        }
        BitSet primaryNumbers = getPrimaryNumbers(Integer.valueOf(args[0]));
        primaryNumbers.stream().forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        System.exit(0);
    }
}
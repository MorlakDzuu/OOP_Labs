package task2;

public class Dec2bin {

    public static String dec2Bin(long number) {
        String binaryRepresentation = "";
        long tempNumber;
        if (number == 0) {
            binaryRepresentation = "0";
        } else {
            while (number != 0) {
                tempNumber = number % 2;
                binaryRepresentation = tempNumber + binaryRepresentation;
                number = number / 2;
            }
        }
        return  binaryRepresentation;
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Dec2bin <decimal number>");
            System.exit(1);
            return;
        }
        long number;
        try {
            number = Long.parseLong(args[0]);
            if (number < 0) {
                System.out.println("Your number is negative");
                System.exit(1);
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
            System.exit(1);
            return;
        }
        System.out.println(dec2Bin(number));
        System.exit(2);
    }
}
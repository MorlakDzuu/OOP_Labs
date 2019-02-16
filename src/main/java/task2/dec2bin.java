public class dec2bin {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Input error");
            return;
        }
        long number;
        try {
            number = Long.parseLong(args[0]);
            if (number < 0) {
                System.out.println("Your number is negative");
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }
        String tempString = "";
        long tempNumber;
        while(number !=0){
            tempNumber = number % 2;
            tempString = tempNumber + tempString;
            number = number / 2;
        }
        System.out.println(tempString);
    }
}
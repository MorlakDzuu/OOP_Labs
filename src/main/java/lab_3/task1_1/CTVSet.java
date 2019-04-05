import java.util.Scanner;

public class CTVSet {
    static String turnOfError = "Телевизор выключен";

    public static void selectChannel(TV tv, String inputString) {
        if (!tv.getStatus()) {
            System.out.println(turnOfError);
            return;
        }
        if (inputString.equals("")) {
            System.out.println("Номер канала не задан");
            return;
        }
        try {
            int channel = Integer.parseInt(inputString);
            if (!tv.setChannel(channel)) System.out.println("Неправильно задан номер канала");
            else System.out.println("Выбран канал с номером " + channel);
        } catch (NumberFormatException e) {
            if (!tv.setChannelByName(inputString)) System.out.println("Канала с таким именем не существует");
        }
    }

    public static void setChannelName(TV tv, String inputString) {
        if (!tv.getStatus()) {
            System.out.println(turnOfError);
            return;
        }
        try {
            Integer channel = Integer.parseInt(inputString.split(" ")[0]);
            inputString = inputString.replace(channel.toString(), "");
            if (tv.setChannelName(channel, inputString)) {
                System.out.println("Канал номер " + channel + " теперь называется как \"" + inputString + "\"");
            } else  {
                System.out.println("Не удалось установить название \"" + inputString + "\" каналу с номером " + channel);
            }
        } catch (NumberFormatException e) {
            System.out.println("Номер канала задан неправильно");
        }
    }

    public static void deleteChannelName(TV tv, String inputString) {
        if (!tv.getStatus()) {
            System.out.println(turnOfError);
            return;
        }
        if (!tv.deleteChannelName(inputString)) System.out.println("Канала с таким именем не существует");
        else System.out.println("Имя канала \"" + inputString + "\" было удалено");
    }

    public static void getChannelName(TV tv, String inputString) {
        if (!tv.getStatus()) {
            System.out.println(turnOfError);
            return;
        }
        String name;
        try {
            name = tv.getChannelName(Integer.parseInt(inputString));
        } catch (NumberFormatException e) {
            System.out.println("Неправильно указан номер канала");
            return;
        }
        if (name == null) name = "Имя канала не задано";
        System.out.println(name);
    }

    public static void CTVSet() {
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        TV tv = new TV();
        while (!inputString.equals("...")) {
            String command = inputString.split(" ")[0];
            inputString = inputString.replace(command, "").trim();

            if (command.equals("TurnOn")) {
                tv.turnOn();
                System.out.println("Телевизор включен");
            }

            if (command.equals("TurnOf")) {
                tv.turnOf();
                System.out.println(turnOfError);
            }

            if (command.equals("info")) System.out.println(tv.getInfo());

            if (command.equals("SelectPreviousChannel")) tv.selectPreviousChannel();

            if (command.equals("SelectChannel")) {
                selectChannel(tv, inputString);
            }

            if (command.equals("SetChannelName")) {
                setChannelName(tv, inputString);
            }

            if (command.equals("DeleteChannelName")) {
                deleteChannelName(tv, inputString);
            }

            if (command.equals("GetChannelName")) {
                getChannelName(tv, inputString);
            }

            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        CTVSet();
        System.exit(0);
    }
}
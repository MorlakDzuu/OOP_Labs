import java.util.Scanner;

public class TVSet {
    final static String TURN_OF_ERROR = "Телевизор выключен";
    final static String WRONG_CHANNEL_NUMBER = "Неправильно задан номер канала";
    final static String MISSING_CHANNEL_NUMBER = "Номер канала не задан";

    public TV tv = new TV();

    public void selectChannel(String inputString) {
        if (!tv.getTurnedOn()) {
            System.out.println(TURN_OF_ERROR);
            return;
        }
        if (inputString.equals("")) {
            System.out.println(MISSING_CHANNEL_NUMBER);
            return;
        }
        inputString = inputString.trim();
        try {
            int channel = Integer.parseInt(inputString);
            if (!tv.setChannel(channel)) System.out.println(WRONG_CHANNEL_NUMBER);
            else System.out.println("Выбран канал с номером " + channel);
        } catch (NumberFormatException e) {
            if (!tv.setChannelByName(inputString)) System.out.println("Канала с таким именем не существует");
            else System.out.println("Выбран канал \"" + inputString + "\" под номером " + tv.getChannelByName(inputString));
        }
    }

    public void setChannelName(String inputString) {
        if (!tv.getTurnedOn()) {
            System.out.println(TURN_OF_ERROR);
            return;
        }
        try {
            Integer channel = Integer.parseInt(inputString.split(" ")[0]);
            inputString = inputString.substring(inputString.split(" ")[0].length()).trim();
            if (tv.setChannelName(channel, inputString)) {
                System.out.println("Канал с номером " + channel + " теперь называется как \"" + inputString + "\"");
            } else  {
                System.out.println("Не удалось установить название \"" + inputString + "\" каналу с номером " + channel);
            }
        } catch (NumberFormatException e) {
            System.out.println(WRONG_CHANNEL_NUMBER);
        }
    }

    public void deleteChannelName(String inputString) {
        if (!tv.getTurnedOn()) {
            System.out.println(TURN_OF_ERROR);
            return;
        }
        if (!tv.deleteChannelName(inputString)) System.out.println("Канал с таким именем не существует");
        else System.out.println("Имя канала \"" + inputString + "\" было удалено");
    }

    public void getChannelName(String inputString) {
        if (!tv.getTurnedOn()) {
            System.out.println(TURN_OF_ERROR);
            return;
        }
        String name;
        try {
            name = tv.getChannelName(Integer.parseInt(inputString));
        } catch (NumberFormatException e) {
            System.out.println(WRONG_CHANNEL_NUMBER);
            return;
        }
        if (name == null) name = WRONG_CHANNEL_NUMBER;
        System.out.println(name);
    }

    public void selectPreviousChannel() {
        if (!tv.getTurnedOn()) {
            System.out.println(TURN_OF_ERROR);
            return;
        }
        if (tv.selectPreviousChannel()) System.out.println("Выбран предыдущий канал с номером " + tv.getChannel());
        else System.out.println("В памяти не был обнаружен номер предыдущего канала");
    }

    public void turnOn() {
        tv.turnOn();
        System.out.println("Телевизор включен");
    }

    public void turnOf() {
        tv.turnOf();
        System.out.println(TURN_OF_ERROR);
    }

    public void remoteControl() {
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        TV tv = new TV();
        while (!inputString.equals("...")) {
            String command = inputString.split(" ")[0];
            inputString = inputString.replace(command, "").trim();

            if (command.equals("TurnOn"))
                turnOn();
            else if (command.equals("TurnOff"))
                turnOf();
            else if (command.equals("Info"))
                System.out.println(tv.getInfo());
            else if (command.equals("SelectPreviousChannel"))
                selectPreviousChannel();
            else if (command.equals("SelectChannel"))
                selectChannel(inputString);
            else if (command.equals("SetChannelName"))
              setChannelName(inputString);
            else if (command.equals("DeleteChannelName"))
              deleteChannelName(inputString);
            else if (command.equals("GetChannelName"))
                getChannelName(inputString);
            else System.out.println("Команда не распознана");

            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        TVSet tvSet = new TVSet();
        tvSet.remoteControl();
        System.exit(0);
    }
}
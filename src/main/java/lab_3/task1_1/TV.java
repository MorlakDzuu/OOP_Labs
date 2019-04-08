import java.util.Map;
import java.util.TreeMap;

public class TV {
    private boolean isTurnedOn;
    private byte channel = 1;
    private byte previousChannel = 0;
    private Map<Byte, String> channelsNames = new TreeMap<>();

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOf() {
        isTurnedOn = false;
    }

    public byte getChannel() {
        if (isTurnedOn) return channel;
        return 0;
    }

    public boolean setChannel(int channel) {
        if (isTurnedOn && (channel >= 1) && (channel <= 99)) {
            previousChannel = this.channel;
            this.channel = (byte) channel;
            return true;
        }
        return false;
    }

    public boolean getTurnedOn() {
        return isTurnedOn;
    }

    public boolean setChannelByName(String name) {
        return setChannel(getChannelByName(name));
    }

    public String getInfo() {
        String previousChannelString = "";
        if (previousChannel != 0) previousChannelString = "\nПредыдущий канал: " + previousChannel;
        String names = "";
        for (Map.Entry<Byte, String> entry : channelsNames.entrySet()) {
            names = names + "\n" + entry.getKey() + " - " + entry.getValue();
        }
        if (isTurnedOn) return "Телевизор включен\nНомер канала: " + channel + previousChannelString + names;
        return "Телевизор выключен\nКанал при включении: " + channel + previousChannelString + names;
    }

    public boolean selectPreviousChannel() {
        if (isTurnedOn && previousChannel != 0) {
            setChannel(previousChannel);
            return true;
        }
        return false;
    }

    public byte getPreviousChannel() {
        if (isTurnedOn)
            return previousChannel;
        return 0;
    }

    public boolean setChannelName(int channelNumber, String channelName) {
        if (!isTurnedOn) return false;
        if (channelNumber > 99 || channelNumber < 1) return false;
        if (channelName.equals("")) return false;
        if (channelName.replace(" ", "").equals("")) return false;
        channelName = removeExtraBlanks(channelName);
        deleteChannelName(channelName);
        channelsNames.put((byte) channelNumber, channelName);
        return true;
    }

    public String getChannelName(int channelNumber) {
        if (!isTurnedOn) return null;
        return channelsNames.get((byte) channelNumber);
    }

    private static String removeExtraBlanks(String name) {
        String[] splitString = name.split("\\s");
        name = "";
        for (String str: splitString) {
            if (!str.equals("")) name = name + str + " ";
        }
        return name.trim();
    }

    public byte getChannelByName(String name) {
        name = removeExtraBlanks(name);
        for (Map.Entry<Byte, String> entry: channelsNames.entrySet()) {
            if (entry.getValue().equals(name)) return entry.getKey();
        }
        return -1;
    }

    public boolean deleteChannelName(String name) {
        if (isTurnedOn) {
            if (channelsNames.remove(getChannelByName(name)) != null) return true;
        }
        return false;
    }
}
import java.util.Map;
import java.util.TreeMap;

public class TV {
    private boolean status;
    private byte channel = 1;
    private byte previousChannel = 0;
    private Map<Byte, String> channelsNames = null;

    public void turnOn() {
        status = true;
    }

    public void turnOf() {
        status = false;
    }

    public byte getChannel() {
        if (status) return channel;
        return 0;
    }

    public boolean setChannel(int channel) {
        if (status && channel >= 1 && channel <= 99) {
            previousChannel = this.channel;
            this.channel = (byte) channel;
            return true;
        }
        return false;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean setChannelByName(String name) {
        return setChannel(getChannelByName(name));
    }

    public String getInfo() {
        String previousChannelString = "";
        if (previousChannel != 0) previousChannelString = "\nПредыдущий канал: " + previousChannel;
        String names = "";
        if (channelsNames != null) {
            for (Map.Entry<Byte, String> entry : channelsNames.entrySet()) {
                names = names + "\n" + entry.getKey() + " - " + entry.getValue();
            }
        }
        if (status) return "Телевизор включен\nНомер канала: " + channel + previousChannelString + names;
        return "Телевизор выключен\nКанал при включении: " + channel + previousChannelString + names;
    }

    public void selectPreviousChannel() {
        if (status && previousChannel != 0) setChannel(previousChannel);
    }

    public boolean setChannelName(int channelNumber, String channelName) {
        if (!status) return false;
        if (channelNumber > 99 || channelNumber < 1) return false;
        if (channelName.equals("")) return false;
        if (channelName.replace(" ", "").equals("")) return false;
        channelName = removeExtraBlanks(channelName);
        if (channelsNames == null) channelsNames = new TreeMap<>();
        if (!channelsNames.containsValue(channelName)) {
            channelsNames.put((byte) channelNumber, channelName);
            return true;
        }
        return false;
    }

    public String getChannelName(int channelNumber) {
        if (!status) return null;
        if (channelsNames != null) {
            return channelsNames.get((byte) channelNumber);
        }
        return null;
    }

    private String removeExtraBlanks(String name) {
        String[] splitString = name.split("\\s");
        name = "";
        for (String str: splitString) {
            if (!str.equals("")) name = name + str + " ";
        }
        return name.trim();
    }

    public byte getChannelByName(String name) {
        if (channelsNames == null) return -1;
        name = removeExtraBlanks(name);
        for (Map.Entry<Byte, String> entry: channelsNames.entrySet()) {
            if (entry.getValue().equals(name)) return entry.getKey();
        }
        return -1;
    }

    public boolean deleteChannelName(String name) {
        if (status) channelsNames.remove(getChannelByName(name));
        return false;
    }
}
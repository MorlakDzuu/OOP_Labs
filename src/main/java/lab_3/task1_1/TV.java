public class TV {
    private boolean status;
    private byte chanel = 1;

    public boolean getStatus() {
        return status;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOf() {
        status = false;
    }

    public byte getChanel() {
        if (status) return chanel;
        return 0;
    }

    public void setChanel(int chanel) {
        if (status && chanel >= 1 && chanel <= 99) this.chanel = (byte) chanel;
    }

    public String getState() {
        String str = "Номер канала: " + chanel;
        if (status) return "Телевизор включен\n" + str;
        return "Телевизор выключен\n" + str;
    }
}

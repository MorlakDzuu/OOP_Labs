import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TVSetTest {

    TVSet tvSet;

    @Before
    public void init() {
        tvSet = new TVSet();
        tvSet.turnOn();
    }

    @Test
    public void selectChannel() {
        tvSet.selectChannel("20");
        assertEquals(20, tvSet.tv.getChannel());
        tvSet.selectChannel("   27   ");
        assertEquals(27, tvSet.tv.getChannel());
    }

    @Test
    public void setChannelName() {
        tvSet.setChannelName("2 Russia 24");
        assertEquals(2, tvSet.tv.getChannelByName("Russia 24"));
        tvSet.setChannelName("24    Russia    24");
        assertEquals(24, tvSet.tv.getChannelByName("Russia 24"));
        tvSet.setChannelName("6 8");
        tvSet.selectChannel("8");
        assertEquals(8, tvSet.tv.getChannel());
    }

    @Test
    public void deleteChannelName() {
        tvSet.setChannelName("2 Russia 24");
        tvSet.deleteChannelName("Russia 24");
        assertEquals(null, tvSet.tv.getChannelName(2));
        tvSet.setChannelName("2 Russia 24");
        tvSet.deleteChannelName("Russia        24");
        assertEquals(null, tvSet.tv.getChannelName(2));
        tvSet.setChannelName("2 Russia 24");
        tvSet.deleteChannelName("     Russia        24");
        assertEquals(null, tvSet.tv.getChannelName(2));
        tvSet.setChannelName("2 Russia 24");
        tvSet.deleteChannelName("     Russia        24    ");
        assertEquals(null, tvSet.tv.getChannelName(2));
    }
}
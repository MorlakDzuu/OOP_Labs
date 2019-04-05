import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TVTest {

    TV tv;

    @Before
    public void init() {
        tv = new TV();
    }

    @Test
    public void getChanel() {
        assertEquals(0, tv.getChannel());
        tv.setChannel(20);
        assertEquals(0, tv.getChannel());
        tv.turnOn();
        assertEquals(1, tv.getChannel());
        tv.setChannel(20);
        assertEquals(20, tv.getChannel());
        tv.turnOf();
        assertEquals(0, tv.getChannel());
        tv.turnOn();
        assertEquals(20, tv.getChannel());
        tv.setChannel(100);
        assertEquals(20, tv.getChannel());
        tv.setChannel(99);
        assertEquals(99, tv.getChannel());
        tv.setChannel(0);
        assertEquals(99, tv.getChannel());
        tv.setChannel(1);
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void getChannelName() {
        tv.turnOn();
        tv.setChannelName(10, " СТС ");
        assertEquals("СТС", tv.getChannelName(10));
        assertEquals(null, tv.getChannelName(1000));

        tv.setChannelName(1000, "NONE");
        assertEquals(null, tv.getChannelName(1000));

        tv.setChannelName(1, "none     none");
        assertEquals("none none", tv.getChannelName(1));

        tv.setChannelName(1,"  N  O  N  E  ");
        assertEquals("N O N E", tv.getChannelName(1));

        tv.setChannelName(1, "    The    best   channel in   the world!!      ");
        assertEquals("The best channel in the world!!", tv.getChannelName(1));

        tv.setChannelName(2, "Hello");
        tv.setChannelName(3, "Hello");
        assertEquals("Hello", tv.getChannelName(2));
        assertEquals(null, tv.getChannelName(3));
    }

    @Test
    public void getChannelByNumber() {
        tv.turnOn();
        tv.setChannelName(3, "LOL");
        assertEquals(3, tv.getChannelByName("LOL"));
        assertEquals(-1, tv.getChannelByName("FIRST"));
    }

    @Test
    public void deleteChannelName() {
        tv.setChannelName(2, "car");
        assertEquals(-1, tv.getChannelByName("car"));
        tv.turnOn();
        tv.setChannelName(1, "NAME");
        tv.turnOf();
        tv.deleteChannelName("NAME");
        tv.turnOn();
        assertEquals(1, tv.getChannelByName("NAME"));
        tv.deleteChannelName("NAME");
        assertEquals(-1, tv.getChannelByName("NAME"));
    }

    @Test
    public void info() {
        assertEquals("Телевизор выключен\nКанал при включении: 1", tv.getInfo());
        tv.turnOn();
        assertEquals("Телевизор включен\nНомер канала: 1", tv.getInfo());
        tv.turnOf();
        assertEquals("Телевизор выключен\nКанал при включении: 1", tv.getInfo());
        tv.turnOn();
        tv.setChannel(20);
        assertEquals("Телевизор включен\nНомер канала: 20\nПредыдущий канал: 1", tv.getInfo());
        tv.turnOf();
        assertEquals("Телевизор выключен\nКанал при включении: 20\nПредыдущий канал: 1", tv.getInfo());
        tv.turnOn();
        tv.setChannelName(1, "OPT");
        tv.setChannelName(17, "Discovery");
        tv.setChannelName(35, "Русский экстрим");
        assertEquals("Телевизор включен\nНомер канала: 20\nПредыдущий канал: 1\n1 - OPT\n17 - Discovery\n35 - Русский экстрим", tv.getInfo());
        tv.deleteChannelName("Русский экстрим");
        assertEquals("Телевизор включен\nНомер канала: 20\nПредыдущий канал: 1\n1 - OPT\n17 - Discovery", tv.getInfo());
    }
}
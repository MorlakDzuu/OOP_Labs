import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class TVTest {

    TV tv;

    private void assertFailure(Runnable runnable, int expected) {
        runnable.run();
        assertEquals(expected, tv.getChannel());
    }

    private void assertSuccess(Runnable runnable, int expected) {
        runnable.run();
        assertEquals(expected, tv.getChannel());
    }

    @Before
    public void init() {
        tv = new TV();
    }

    @Test
    public void getChanel() {
        assertEquals(0, tv.getChannel());
        assertFailure(() -> tv.setChannel(20), 0);
        tv.turnOn();
        assertEquals(1, tv.getChannel());
        assertSuccess(() -> tv.setChannel(20), 20);
        tv.turnOf();
        assertEquals(0, tv.getChannel());
        tv.turnOn();
        assertEquals(20, tv.getChannel());
        assertFailure(() -> tv.setChannel(100), 20);
        assertSuccess(() -> tv.setChannel(99), 99);
        assertFailure(() -> tv.setChannel(0), 99);
        assertSuccess(() -> tv.setChannel(1), 1);
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
        assertEquals("Hello", tv.getChannelName(3));
        assertEquals(null, tv.getChannelName(2));
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
    public void previousChannel() {
        assertEquals(false, tv.selectPreviousChannel());
        assertEquals(0, tv.getPreviousChannel());
        tv.turnOn();
        assertEquals(0, tv.getPreviousChannel());
        assertEquals(false, tv.selectPreviousChannel());
        tv.setChannel(20);
        assertEquals(1, tv.getPreviousChannel());
        tv.setChannel(30);
        assertEquals(20, tv.getPreviousChannel());
        tv.setChannel(100);
        assertEquals(20, tv.getPreviousChannel());
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
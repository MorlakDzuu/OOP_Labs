import org.junit.Test;

import static org.junit.Assert.*;

public class TVTest {

    @Test
    public void getChanel() {
        TV tv = new TV();
        assertEquals(0, tv.getChanel());
        tv.setChanel(20);
        assertEquals(0, tv.getChanel());
        tv.turnOn();
        assertEquals(1, tv.getChanel());
        tv.setChanel(20);
        assertEquals(20, tv.getChanel());
        tv.turnOf();
        assertEquals(0, tv.getChanel());
        tv.turnOn();
        assertEquals(20, tv.getChanel());
        tv.setChanel(100);
        assertEquals(20, tv.getChanel());
        tv.setChanel(99);
        assertEquals(99, tv.getChanel());
        tv.setChanel(0);
        assertEquals(99, tv.getChanel());
        tv.setChanel(1);
        assertEquals(1, tv.getChanel());
        assertEquals("Телевизор включен\nНомер канала: 1", tv.getState());
        tv.turnOf();
        assertEquals("Телевизор выключен\nПоследний включенный канал: 1", tv.getState());
    }
}
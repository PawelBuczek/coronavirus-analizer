package pl.sdacademy.coronavirus;

import org.junit.jupiter.api.Test;
import pl.sdacademy.coronavirus.exporting.SessionFactoryProvider;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionFactoryProviderTest {
    private static final SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();

    @Test
    public void shouldOpenSessionFactory() {
        boolean opened;
        try {
            sessionFactoryProvider.openSession();
            opened = true;

        } catch (Exception e) {
            opened = false;
        }
        assertTrue(opened);

    }

    @Test
    public void shouldCloseSessionFactory() {
        boolean closed;
        try {
            sessionFactoryProvider.openSession();
            sessionFactoryProvider.closeSession();
            closed = true;

        } catch (Exception e) {
            closed = false;
        }
        assertTrue(closed);

    }
}

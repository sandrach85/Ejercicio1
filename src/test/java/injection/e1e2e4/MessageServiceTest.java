package injection.e1e2e4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageServiceTest {

    private MessageService messageService;
    
    @Before
    public void before(){
        this.messageService= new MessageService();
    }

    @Test
    public void testAddMessage() {
        messageService.add("1", "uno");
        assertEquals("uno", messageService.message("1"));
    }

    @Test
    public void testKey() {
        messageService.add("2", "dos");
        messageService.add("3", "tres");
        assertEquals("2", messageService.key("dos"));
        assertEquals("3", messageService.key("tres"));
    }

}

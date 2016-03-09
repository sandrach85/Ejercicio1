package config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestsMailConfig;
import restApi.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsMailConfig.class})
public class MailServiceIntegrationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {
        mailService.sendMail("upmspring@gmail.com", "upmspring@gmail.com", "Saludos", "Mail Service test");
    }
}

package shin.com.show_voucher;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shin.com.show_voucher.biz.service.ParsingService;

@SpringBootTest
public class ParsingServiceTests {

    @Autowired
    ParsingService parsingService;

    @Test
    public void parsingUrlTest() {

        try {
            parsingService.parsingUrl("https://xn--299aa03ct82dtjik1sz2c.com/");
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

}

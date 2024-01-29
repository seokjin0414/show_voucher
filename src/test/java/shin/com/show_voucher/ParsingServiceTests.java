package shin.com.show_voucher;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shin.com.show_voucher.biz.service.ParsingService;

@SpringBootTest
public class ParsingServiceTests {

    @Autowired
    ParsingService parsingService;

    private final String u1 = "https://xn--299aa03ct82dtjik1sz2c.com/";

    @Test
    public void parsingUrlTest() {
        long total = 0;
        int cnt = 1;
        try {
            for (int i = 0; i < cnt; i++) {
                long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                Elements elem = Jsoup
                        .connect(u1)
                        .get()
                        .body()
                        .getElementsByClass("userEL14741173");


                System.gc();
                long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                total += (before - after);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("평균" + (total / 1024 / 1024 / cnt));
    }

}

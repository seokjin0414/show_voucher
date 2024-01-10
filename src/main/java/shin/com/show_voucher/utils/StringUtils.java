package shin.com.show_voucher.utils;

import com.fasterxml.uuid.Generators;
import com.nhncorp.lucy.security.xss.XssPreventer;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class StringUtils extends org.springframework.util.StringUtils {
    public static String getRandomStr(int size) {
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            String randomStr = String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
            sb.append(randomStr);
        }
        return sb.toString();
    }

    public static String getRandomNum(int size) {
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            String randomStr = String.valueOf((char) ((int) (rnd.nextInt(10)) + 48));
            sb.append(randomStr);
        }
        return sb.toString();
    }

    public static String numFormatter(int size, int value) {
        String suffix = String.format("%0"+size+"d", value);
        return suffix;
    }

    public static String UUID() {
        UUID uuid2 = Generators.randomBasedGenerator().generate();
        return uuid2.toString();
    }

    public static String numFormatter(int size, String value) {
        return numFormatter(size,Integer.parseInt(value));
    }

    public static String now(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String substring(String src,int start,int end) {
        try {
            return src.substring(start, end);
        } catch (Exception e) {
            return src;
        }
    }
    
    //xss 방어
    public static String cleanXSS(String value) {
		return XssPreventer.escape(value);
    }



}

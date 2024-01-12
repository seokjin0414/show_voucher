package shin.com.show_voucher.biz.controller.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shin.com.show_voucher.biz.vo.Authorization;
import shin.com.show_voucher.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainViewController {

    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }

    @GetMapping(value = {"/main_test"})
    public String main_test() {
        return "main_test";
    }
}
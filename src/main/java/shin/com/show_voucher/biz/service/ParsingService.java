package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;
import shin.com.show_voucher.biz.vo.model.voucher.GetVoucherForParsing;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParsingService {

    private final CompanyService companyService;
    private final VoucherService voucherService;

    private final String stateCode = StateCode.Y.name();

    String u1 = "https://xn--299aa03ct82dtjik1sz2c.com/";

    public int parsingUrl(String url) throws IOException {
// /html/body/div[2]/div[4]/div/div/div/div/div[1]/table/tbody/tr[2]/td[2]/span/span[1]
// *[@id="no-fouc"]/body/div[2]/div[4]/div/div/div/div/div[1]/table/tbody/tr[2]/td[2]/span/span[1]

// body > div.dsgn-body.mode-render > div.userEL14741173.el_2.element.aos-init.aos-animate > div > div > div > div > div.fr-table-responsive > table > tbody > tr:nth-child(2) > td:nth-child(2) > span > span:nth-child(1)
// body > div.dsgn-body.mode-render > div.userEL14741173.el_2.element.aos-init.aos-animate > div > div > div > div > div.fr-table-responsive > table > tbody > tr:nth-child(2) > td:nth-child(2) > span > span:nth-child(1)

        Element elem = Jsoup.connect(url).get().body();

        Elements element = elem.getElementsByClass("userEL14741173");
        if (element != null) {
            log.info(element.text());
        }



        return 1;
    }

    public int parsingVoucher() {
        List<GetCompanyForParsing> companyList = companyService.getCompanyListForParsing(stateCode);
        List<GetVoucherForParsing> voucherList = voucherService.getVoucherListForParsing(stateCode);



        return 1;
    }

}

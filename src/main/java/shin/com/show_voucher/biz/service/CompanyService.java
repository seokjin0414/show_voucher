package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.CompanyDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyDao companyDao;

    public List<GetCompanyForParsing> selectCompanyList() {
        String using = StateCode.Y.toString();
        return companyDao.selectCompanyList(using);
    };

}

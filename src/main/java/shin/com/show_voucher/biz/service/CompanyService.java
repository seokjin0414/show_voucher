package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.CompanyDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.company.CreateCompany;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyDao companyDao;

    /**
     * 파싱할 회사 리스트
     *
     * @return List<GetCompanyForParsing>
     */
    public List<GetCompanyForParsing> getCompanyListForParsing() {
        String using = StateCode.Y.toString();
        return companyDao.selectCompanyListForParsing(using);
    };

    /**
     * 회사 저장
     *
     * @param createCompany
     * @return int
     */
    public int saveCompany(CreateCompany createCompany) {
        return companyDao.insertCompany(createCompany);
    };

}

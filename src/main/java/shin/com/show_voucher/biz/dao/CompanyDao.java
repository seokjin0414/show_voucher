package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.company.CreateCompany;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;

import java.util.List;

@Mapper
@Repository
public interface CompanyDao {

    /**
     * 파싱할 회사 리스트
     *
     * @param company_state
     * @return List
     */
    List<GetCompanyForParsing> selectCompanyListForParsing(String company_state);

    /**
     * 회사 저장
     *
     * @param createCompany
     * @return int
     */
    int insertCompany(CreateCompany createCompany);

}

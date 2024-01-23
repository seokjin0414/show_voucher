package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;

import java.util.List;

@Mapper
@Repository
public interface CompanyDao {
    /**
     *
     * @param company_state
     * @return List
     */
    List<GetCompanyForParsing> SelectCompanyList(String company_state);
}

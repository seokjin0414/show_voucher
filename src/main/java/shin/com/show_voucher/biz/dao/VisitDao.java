package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.company.GetCompanyForParsing;
import shin.com.show_voucher.biz.vo.model.visit.CreateVisit;

import java.util.List;

@Mapper
@Repository
public interface VisitDao {
    /**
     * 방문자 저장
     *
     * @param createVisit
     */
    void insertVisit(CreateVisit createVisit);
}

package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.company.CreateCompany;
import shin.com.show_voucher.biz.vo.model.price.CreatePrice;

@Mapper
@Repository
public interface PriceDao {

    /**
     * 가격 저장
     *
     * @param createPrice
     * @return int
     */
    int insertPrice(CreatePrice createPrice);
}

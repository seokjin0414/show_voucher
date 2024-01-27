package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.voucherPrice.CreateVoucherPrice;

@Mapper
@Repository
public interface VoucherPriceDao {

    /**
     * 상품권 가격 저장
     *
     * @param createVoucherPrice
     * @return int
     */
    int insertVoucherPrice(CreateVoucherPrice createVoucherPrice);
}

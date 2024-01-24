package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.voucher.CreateVoucher;
import shin.com.show_voucher.biz.vo.model.voucher.GetVoucherForParsing;

import java.util.List;

@Mapper
@Repository
public interface VoucherDao {

    /**
     * 파싱할 상품권 리스트
     *
     * @param voucher_state
     * @return List<GetVoucherForParsing>
     */
    List<GetVoucherForParsing> selectVoucherListForParsing(String voucher_state);

    /**
     * 상품권 저장
     *
     * @param createVoucher
     * @return int
     */
    int insertVoucher(CreateVoucher createVoucher);
}

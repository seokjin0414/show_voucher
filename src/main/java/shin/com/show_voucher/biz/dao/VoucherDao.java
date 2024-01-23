package shin.com.show_voucher.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shin.com.show_voucher.biz.vo.model.voucher.GetVoucherForParsing;

import java.util.List;

@Mapper
@Repository
public interface VoucherDao {
    /**
     *
     * @param voucher_state
     * @return List
     */
    List<GetVoucherForParsing> SelectVoucherList(String voucher_state);
}

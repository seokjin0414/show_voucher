package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.VoucherDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.voucher.GetVoucherForParsing;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoucherService {

    private final VoucherDao voucherDao;

    public List<GetVoucherForParsing> selectVoucherList() {
        String using = StateCode.Y.toString();
        return voucherDao.selectVoucherList(using);
    };

}

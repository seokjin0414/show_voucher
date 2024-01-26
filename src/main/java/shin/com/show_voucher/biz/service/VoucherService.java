package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.VoucherDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.voucher.CreateVoucher;
import shin.com.show_voucher.biz.vo.model.voucher.GetVoucherForParsing;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoucherService {

    private final VoucherDao voucherDao;

    /**
     * 파싱할 회사 리스트
     *
     * @return
     */
    public List<GetVoucherForParsing> getVoucherListForParsing(String stateCode) {
        return voucherDao.selectVoucherListForParsing(stateCode);
    };

    /**
     * 상품권 저장s
     *
     * @param createVoucher
     * @return int
     */
    public int saveVoucher(CreateVoucher createVoucher) {
        return voucherDao.insertVoucher(createVoucher);
    }
}

package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.VoucherPriceDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.voucherPrice.CreateVoucherPrice;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoucherPriceService {

    private final VoucherPriceDao voucherPriceDao;

    /**
     * 상품권 가격 저장
     *
     * @param createVoucherPrice
     * @return int
     */
    public int saveCompany(CreateVoucherPrice createVoucherPrice) {
        createVoucherPrice.setPrice_state(StateCode.Y.name());
        return voucherPriceDao.insertVoucherPrice(createVoucherPrice);
    };

}

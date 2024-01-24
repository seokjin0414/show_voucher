package shin.com.show_voucher.biz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.PriceDao;
import shin.com.show_voucher.biz.vo.code.StateCode;
import shin.com.show_voucher.biz.vo.model.company.CreateCompany;
import shin.com.show_voucher.biz.vo.model.price.CreatePrice;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceService {

    private final PriceDao priceDao;

    /**
     * 회사 저장
     *
     * @param createPrice
     * @return int
     */
    public int saveCompany(CreatePrice createPrice) {
        createPrice.setPrice_state(StateCode.Y.name());

        return priceDao.insertPrice(createPrice);
    };

}

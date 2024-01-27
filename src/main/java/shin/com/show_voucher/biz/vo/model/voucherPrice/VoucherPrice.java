package shin.com.show_voucher.biz.vo.model.voucherPrice;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("VoucherPrice")
public class VoucherPrice {
    private String price_idx;
    private String price_info_idx;
    private double buy_ratio;
    private double buy_price;
    private double sell_ratio;
    private double sell_price;
    private String price_state;
    private String price_reg_dtm;
    private String price_mod_dtm;
}

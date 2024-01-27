package shin.com.show_voucher.biz.vo.model.voucherPrice;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CreateVoucherPrice")
public class CreateVoucherPrice {
    private String price_info_idx;
    private double buy_ratio;
    private double buy_price;
    private double sell_ratio;
    private double sell_price;
    private String price_state;
}

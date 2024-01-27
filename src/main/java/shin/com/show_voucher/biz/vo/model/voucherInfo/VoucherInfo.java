package shin.com.show_voucher.biz.vo.model.voucherInfo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("VoucherInfo")
public class VoucherInfo {
    private String info_idx;
    private String info_company_idx;
    private String info_voucher_idx;
    private String info_name;
    private String info_state;
    private String info_reg_dtm;
    private String info_mod_dtm;
}

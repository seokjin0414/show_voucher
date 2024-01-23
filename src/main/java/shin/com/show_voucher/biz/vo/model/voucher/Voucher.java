package shin.com.show_voucher.biz.vo.model.voucher;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Voucher")
public class Voucher {
    private String voucher_idx;
    private String voucher_name;
    private String voucher_face_value;
    private String voucher_type;
    private String voucher_state;
    private String voucher_reg_dtm;
    private String voucher_mod_dtm;
}

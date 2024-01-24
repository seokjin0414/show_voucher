package shin.com.show_voucher.biz.vo.model.voucher;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CreateVoucher")
public class CreateVoucher {
    private String voucher_name;
    private String voucher_face_value;
    private String voucher_type;
    private String voucher_state;
}

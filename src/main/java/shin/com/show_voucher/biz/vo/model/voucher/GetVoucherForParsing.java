package shin.com.show_voucher.biz.vo.model.voucher;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("GetVoucherForParsing")
public class GetVoucherForParsing {
    private String voucher_idx;
    private String voucher_name;
    private String voucher_face_value;
}

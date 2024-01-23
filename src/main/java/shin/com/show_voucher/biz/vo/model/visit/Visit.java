package shin.com.show_voucher.biz.vo.model.visit;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Visit")
public class Visit {
    private String visit_idx;
    private String visit_type;
    private String visit_agent;
    private String visit_ip;
    private String visit_reg_dtm;
    private String visit_mod_dtm;
}

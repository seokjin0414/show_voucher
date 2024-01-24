package shin.com.show_voucher.biz.vo.model.visit;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CreateVisit")
public class CreateVisit {
    private String visit_type;
    private String visit_agent;
    private String visit_ip;
}

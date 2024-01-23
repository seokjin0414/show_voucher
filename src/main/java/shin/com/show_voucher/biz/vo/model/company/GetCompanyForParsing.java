package shin.com.show_voucher.biz.vo.model.company;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("GetCompanyUrlForParsing")
public class GetCompanyForParsing {
    private String company_idx;
    private String company_name;
    private String company_url;
}

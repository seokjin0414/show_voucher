package shin.com.show_voucher.biz.vo.model.company;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CreateCompany")
public class CreateCompany {
    private String company_name;
    private String company_url;
    private String company_phone;
    private String company_addr;
    private String company_map;
    private String company_state;
    private String company_etc;
}

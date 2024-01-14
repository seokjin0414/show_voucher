package shin.com.show_voucher.biz.vo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Company")
public class Company {
    private String company_idx;
    private String company_name;
    private String company_url;
    private String company_phone;
    private String company_addr;
    private String company_map;
    private String company_state;
    private String company_etc;
    private String company_reg_dtm;
    private String company_mod_dtm;
}

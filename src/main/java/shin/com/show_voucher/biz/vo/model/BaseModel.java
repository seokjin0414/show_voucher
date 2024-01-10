package shin.com.show_voucher.biz.vo.model;

import lombok.Data;

@Data
public class BaseModel {
    private String regId;
    private String modId;
    private String regDtm;
    private String modDtm;
    private String csrfKey;
}

package shin.com.show_voucher.biz.vo;

import lombok.Data;

@Data
public class ResultVo {
    private String code;
    private String message;
    private String datetime;
    private int offset;
    private String size;
    private Object data;
    private long total;
}

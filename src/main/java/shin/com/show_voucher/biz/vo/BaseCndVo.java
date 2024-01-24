package shin.com.show_voucher.biz.vo;

import lombok.Data;

@Data
public class BaseCndVo {
    private int pageIndex;
    private int pageSize;
    private String startDate;
    private String endDate;
    private String searchField;
    private String searchVal;
    private String sortField;
    private String sortOrder;
    private String excelYn;
    private String regId;
    private String modId;
    private String regDtm;
    private String modDtm;

    public int getPageIndex() {
        if (pageIndex == 0) {
            return 1;
        }
        return (pageIndex - 1) * pageSize;
    }

    public int getPageSize() {
        if (pageSize == 0) {
            pageSize = 20;
        }
        return pageSize;
    }
}

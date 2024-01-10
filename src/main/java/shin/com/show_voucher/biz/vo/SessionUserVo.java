package shin.com.show_voucher.biz.vo;

import shin.com.show_voucher.biz.vo.model.TbUserModel;
import shin.com.show_voucher.utils.DateUtils;
import shin.com.show_voucher.utils.SessionUtil;
import lombok.Data;

import jakarta.servlet.http.HttpServletRequest;

@Data
public class SessionUserVo {
    private String usrIdx;
    private String usrId;
    private String usrNick;
    private String refCd;
    private String upRefCd;
    private String walletAddress;
    private String lastConnDtm;
    private String admin="N";
    private String defiGrd;
    private String masterUse;
    private String investYn;
    private String gradeNm;

    public boolean isAnonymous(){
        if ("0".equals(this.usrIdx)) {
            return true;
        }
        return false;
    }

    public SessionUserVo() {
        
    }
    
    public SessionUserVo(TbUserModel tbUserModel ) {
        build(tbUserModel);
    }

    public void build(TbUserModel tbUserModel ) {
        this.usrIdx = tbUserModel.getUsrIdx();
        this.usrId = tbUserModel.getUsrId();
        this.usrNick = tbUserModel.getUsrNick();
        this.refCd = tbUserModel.getRefCd();
        this.upRefCd = tbUserModel.getUpRefCd();
        this.investYn = "Y";
        this.walletAddress = tbUserModel.getWalletAddress();
        this.lastConnDtm = DateUtils.getNowDateString("yyyy-MM-dd HH:mm:ss");
        this.admin = "N";
    }

    public SessionUserVo buildAnonymous(HttpServletRequest request) {
        this.usrIdx = "0";
        this.usrId = "anonymous";
        this.usrNick = "";
        this.refCd = "";
        this.investYn = "N";
        this.upRefCd = SessionUtil.getRefCd(request);
        this.walletAddress = SessionUtil.getAddressFromHead(request);
        this.lastConnDtm = DateUtils.getNowDateString("yyyy-MM-dd HH:mm:ss");
        this.admin = "N";
        return this;
    }
}

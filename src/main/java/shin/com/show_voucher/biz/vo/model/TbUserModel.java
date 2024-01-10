package shin.com.show_voucher.biz.vo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

@Data
@Alias("TbUserModel")
public class TbUserModel extends BaseModel {
    private String usrIdx;
    private String usrGrd;
    private String usrId;
    private String usrPw;
    private String usrPw1;
    private String usrPw2;
    private String email;
    private String usrNick;
    private String usrNick1;
    private int sponsorNum;
    private String smplPw;
    private String smplPw1;
    private String smplError;
    private String hpCntryCd;
    private String hpNum;
    private String cntryCd;
    private int refCnt;
    private String refCd;
    private String name;
    private String upRefCd;
    private String usrIp;
    private String regId;
    private String modId;
    private String regDtm;
    private String modDtm;
    private String centerYn;
    private String withdrawYn;
    private String agnt;
    private String corpIdx;
    private String agreeYn;
    private String stkVlme;
    private String walletAddress;
    private String closeYn;
    private String returnBnbAddr;

    private String usrStusCd;

    private int orderNum;
    private String lastConnDtm; //마지막 접속 시간
    private String usrConfirm;

    private String certCode;
    private String useYn;
    private String exprdDt;
    private String athTkn;
    private String node;
    private String dnUsrIdx;
    private String defiGrd;
    private String orgType;
    private String modeType;
    private String minDeposit;
    private String captcha;
    private String txId;
    private String amount;
    private String state;
    private String gradeNm;

    private String cnctIp;    //사용자 아이피

    private String lotteryTicket;
    private String refUsrIdx;

    private String twitterIdx;

    private String bioPoint;
    private String specialBalance;
    private String gameKey;
    private String gameKeyRegDtm;
    private String changeYn;
    private String autoLoginYn;

    private String decimalSpecialBalance;

    private int timeCheck;
    private int useCheck;

    public String getDecimalSpecialBalance() {
        if (specialBalance == null) {
            return "0";
        }
        return new BigDecimal(specialBalance).setScale(6, BigDecimal.ROUND_DOWN).toPlainString();
    }

}

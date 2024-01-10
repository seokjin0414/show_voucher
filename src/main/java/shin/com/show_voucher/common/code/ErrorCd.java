package shin.com.show_voucher.common.code;

public enum ErrorCd {
    E_401_0001("wallet address invalid"),  //지갑주소가 섹션하고 맞지 않을 경우
    E_403_0001("need login")                //로그인이 필요할 경우
    ;
    
    private String title;

    ErrorCd(String title) {
        this.title = title;
    }


}

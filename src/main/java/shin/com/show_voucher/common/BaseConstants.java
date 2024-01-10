package shin.com.show_voucher.common;

public final class BaseConstants {
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String USER_AGENT = "User-Agent";
	public static final String ANONYMOUS_USER = "Anonymous";
	public static final String OS_HEADER = "Os";
	public static final String LANGUAGE_HEADER = "LangCd";
	public static final String ENTRY_DELIMITER = ",";
	public static final String JOINING_URI = "/users/joining";
	public static final String AD_ID_HEADER = "Adid";



	private BaseConstants() {
		throw new IllegalStateException("Cannot create instance of static util class");
	}
}

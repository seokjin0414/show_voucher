package shin.com.show_voucher.exception.http;


/**
 * @since 05/03/2020
 */
public class ApiExecutionException extends RuntimeException{

    private static final long serialVersionUID = 8325124565527419666L;

    public ApiExecutionException(String message, Throwable cause) {
        super(message, cause);
    }


    public ApiExecutionException(String message) {
        super(message);
    }

}

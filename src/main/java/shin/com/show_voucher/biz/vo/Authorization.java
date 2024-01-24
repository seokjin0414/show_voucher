package shin.com.show_voucher.biz.vo;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorization {
    enum Role { LOGIN, ANONY }

    public Role role() default Role.ANONY;
}

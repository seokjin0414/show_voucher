package shin.com.show_voucher.biz.controller.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shin.com.show_voucher.biz.controller.BaseRestController;
import shin.com.show_voucher.biz.service.VisitService;
import shin.com.show_voucher.biz.vo.Authorization;

@RestController
@RequestMapping(value = "/api/v1/show_voucher/main", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class MainRestController extends BaseRestController {

    private final VisitService visitService;


    /**
     * 방문시 정보 저장
     *
     * @param request
     * @return ResponseEntity<?>
     */
    @PostMapping(value = "saveVisit")
    @Authorization(role = Authorization.Role.ANONY)
    public ResponseEntity<?> saveVisit(HttpServletRequest request) {
        visitService.saveVisit(request);
        return success("OK");
    }

}

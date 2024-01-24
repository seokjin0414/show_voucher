package shin.com.show_voucher.biz.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shin.com.show_voucher.biz.dao.VisitDao;
import shin.com.show_voucher.biz.vo.code.VisitTypeCode;
import shin.com.show_voucher.biz.vo.model.visit.CreateVisit;
import shin.com.show_voucher.utils.SessionUtil;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitService {

    private final VisitDao visitDao;

    /**
     * 방문자 Agent 가지고 오기
     *
     * @param httpServletRequest
     * @return {@return }
     */
    public String getAgent(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("User-Agent");
    }

    /**
     * 방문자 IP 가지고 오기
     *
     * @param httpServletRequest
     * @return {@return }
     */
    public String getUserIp(HttpServletRequest httpServletRequest) {
        return SessionUtil.getRemoteIP(httpServletRequest);
    }

    /**
     * 방문자 정보 저장
     *
     * @param httpServletRequest
     * @return {@return }
     */
    public int insertVisit(HttpServletRequest httpServletRequest) {

        try {
            CreateVisit createVisit = new CreateVisit();
            createVisit.setVisit_type(VisitTypeCode.G.name());
            createVisit.setVisit_agent(getAgent(httpServletRequest));
            createVisit.setVisit_ip(getUserIp(httpServletRequest));
            visitDao.insertVisit(createVisit);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return -1;
        }

        return 1;
    }

}

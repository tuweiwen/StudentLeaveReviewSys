package studentLeaveReview.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----AdminInterceptor.preHandle-----");
        HttpSession session = request.getSession();

        Object typeObject = session.getAttribute("type");
        short type = (typeObject != null) ? (short) typeObject : 0;

        if (type == 2 || type == 3) {
            response.sendRedirect("/StudentLeaveReviewSys_war_exploded/home");
        }

        return true;
    }
}

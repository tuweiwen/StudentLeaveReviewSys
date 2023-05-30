package studentLeaveReview.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----StudentInterceptor.preHandle-----");
        HttpSession session = request.getSession();

        Object typeObject = session.getAttribute("type");
        short type = (typeObject != null) ? (short) typeObject : 0;

        if (type == 2 || type == 1) {
            response.sendRedirect("/StudentLeaveReviewSys_war_exploded/home");
        }

        return true;
    }
}

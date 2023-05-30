package studentLeaveReview.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
        String requestUri = request.getRequestURI();

        System.out.println("-----LoginInterceptor.preHandle-----");
        /*System.out.println("contextPath -> " + contextPath);
        System.out.println("requestUri -> " + requestUri);*/

        Object isLoginObject = session.getAttribute("isLogin");
        boolean isLogin = isLoginObject != null && (boolean) isLoginObject;
        System.out.println("isLogin -> " + isLogin);

        // not login
        if (!requestUri.endsWith("StudentLeaveReviewSys_war_exploded/") && !requestUri.endsWith("/loginServlet") && !isLogin) {
            session.setAttribute("loginError", "please login!");
            response.sendRedirect("/StudentLeaveReviewSys_war_exploded/");
        }

        // login
        if (requestUri.endsWith("StudentLeaveReviewSys_war_exploded/") && isLogin) {
            response.sendRedirect("/StudentLeaveReviewSys_war_exploded/home");
        }

        return true;
    }
}

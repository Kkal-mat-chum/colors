//package com.ssafy.colors.interceptor;
//
//import com.ssafy.colors.util.JWTUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class JWTInterceptor implements HandlerInterceptor {
//
//    private static final String HEADER_AUTH = "auth-token";
//
//    @Autowired
//    private JWTUtil jwtUtil;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        final String token = request.getHeader(HEADER_AUTH);
//
//        if(token != null){
//            try {
//                jwtUtil.validToken(token);
//            }catch(Exception e){
//                // refresh 토큰 가져오기
//                // refresh 토큰 유효성 검사
//                // 유효하면 access 토큰 생성
//                // 생성한 토큰 전달
//
//                // refresh 토큰 유효하지 않으면 에외 발생생
//            }
//           return true;
//        }
//
//        throw new Exception();
//
//    }
//}

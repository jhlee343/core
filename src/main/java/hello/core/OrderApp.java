package hello.core;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberSerivce memberSerivce = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberSerivce memberService = applicationContext.getBean("memberService",MemberSerivce.class);
        OrderService orderService =  applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+order);
        System.out.println("order.calcultate = " + order.calculatePrice());

    }
}

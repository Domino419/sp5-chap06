import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println( "(g1 == g2) = "+ ( g1 == g2)) ;
        ctx.close();
    }


}

/*
 별도 설정 하지 않는 경우 스프링은 한 개의 스프링 빈 객체만을 생성하며, 이때 빈 객체는 싱글톤 범위를 갖는다.
 싱글톤은 단일 객체( single object)를 의미하는 단어로서 스프링은 기본적으로 한 개의 @Bean 애노테이션에 대해 한 개의 빈 객체를 생성한다.
 따라서 다름과 같은 설정을 사용하면 "greeter"에 해당하는 객체 한 개와 "greeter1"에 해당하는 객체 한개, 이렇게 두개의 객체가 생긴다.

    @Bean
    public Greeter greeter() {
        Greeter g = new Greeter() ;
        g.setFormat("%s, 안녕하세요!" ) ;
        return g ;
    }

    @Bean
    public Greeter greeter1() {
        Greeter g = new Greeter() ;
        g.setFormat("안녕하세요!, %s님!" ) ;
        return g ;
    }

 */


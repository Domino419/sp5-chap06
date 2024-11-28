import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //1.컨테이너 초기화
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);

        //2.컨테이너에서 빈 객체를 구해서 사용
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("스프링") ;
        System.out.println(msg) ;

        //3.컨테이너 종료
        ctx.close();
    }

}


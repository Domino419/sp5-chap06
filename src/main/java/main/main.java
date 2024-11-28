package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Client;

import java.io.IOException;

public class main {

        public static void main(String[] args) throws IOException {
                //1.컨테이너 초기화
                AnnotationConfigApplicationContext ctx =
                        new AnnotationConfigApplicationContext(AppCtx.class);

                //2.컨테이너에서 객체 가져오기 및 메서드 실행
                Client client = ctx.getBean(Client.class) ;
                client.send();

                //3.컨테이너 종료
                ctx.close();
        }
}

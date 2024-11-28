package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {

    /**
     * method        : client
     * date          : 24-11-28
     * param         : 없음
     * return        : Client - 초기화된 Client 객체
     * description   : Client 객체를 생성하고 호스트를 설정한 후 반환.
     */
    @Bean
    public Client client() {
        Client client = new Client() ;
        client.setHost("host");
        return client ;
    }

    /**
     * method        : client2
     * date          : 24-11-28
     * param         : 없음
     * return        : Client2 - 초기화된 Client2 객체
     * description   : Client2 객체를 생성하고 호스트를 설정한 후 반환.
     *                 생성 시 초기화 메소드(connect)와 종료 메소드(close)를 설정.
     */
    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2() {
        Client2 client = new Client2() ;
        client.setHost("host");
        return client ;
    }

}


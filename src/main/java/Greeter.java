public class Greeter {

    private String format ;

    public String greet(String guest ) {
        return String.format(format,guest) ;
    }

    public void setFormat(String format ) {
        this.format = format ;
    }

}


// Greeter.greet = new Greeter () ;
// greet.setFormat = ("%x, 안녕하세요!!") ;
// String msg = Greeter.greet("스프링") ;

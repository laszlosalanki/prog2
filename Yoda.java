public class Yoda {

    public static void test_method() {

        String hello = "hello";

        if (hello.equals("hello")) {
            System.out.println(hello);
        }
    }

    public static void test_method_2() {

        String helloNull = null;

        if (helloNull.equals("hello")) {
            System.out.println(helloNull);
        }
    }

    public static void stable_method() {

        String helloNull = null;

        if ("hello".equals(helloNull)) {
            System.out.println(helloNull);
        }
    }

    public static void main(String[] args) {

        test_method();
        //test_method_2();
        stable_method();

    }
}
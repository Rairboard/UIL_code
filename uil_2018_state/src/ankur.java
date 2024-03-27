public class ankur {

    public void run() throws Exception {

        System.out.printf("%.2f\n", (Math.PI*1000));
        System.out.printf("%.6f\n", (Math.PI*1000));
        System.out.printf("%.6e\n", (Math.PI*1000));
        System.out.printf("%.3f\n", (Math.E*100));
        System.out.printf("%.6f\n", (Math.E*100));
        System.out.printf("%.6e\n", (Math.E*100));

    }

    public static void main(String[] args) throws Exception{
        ankur test = new ankur();
        test.run();
    }
}

public class Main {
    public static void main(String[] args) {
        test_build_levels();

        System.out.println("\nHello world!");
    }

    public static void test_build_levels() {
        String folder_levels = "./Levels";

        Parser parser = new Parser(folder_levels);
        parser.build_levels();
    }
}
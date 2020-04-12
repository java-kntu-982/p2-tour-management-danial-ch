package ir.ac.kntu;

public class ClearScreen {
    public static void cls() {
        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}

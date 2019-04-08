import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hash h = new Hash();
        h.read();
        h.words();
        h.hashwords();
        h.printhash();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        h.hash(string);
        h.search();
    }
}

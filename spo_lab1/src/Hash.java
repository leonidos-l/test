import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Hash {
    private String st;
    private StringBuilder stb;
    private int i_str;

    LinkedList<String> linstb = new LinkedList<>();
    LinkedList<Integer> hash = new LinkedList<>();

    void read() {
        try (FileReader fr = new FileReader("text.txt")) {
            Scanner sc = new Scanner(fr);
            st = sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void words() {
        int i;
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        stb = new StringBuilder(st);
        while (stb.indexOf(" ") != -1) {
            i = stb.indexOf(" ");
            for (int q = 0, w = 1; w < i; q++, w++) {
                if (abc.indexOf(stb.substring(q, w)) == -1) {
                    break;
                }
                if (w == (i - 1)) {
                    linstb.add(stb.substring(0, i));
                }
            }
            stb.delete(0, i + 1);
        }
    }

    void printhash() {
        Iterator<Integer> iterator = hash.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + " ");
        }
        System.out.println();
    }

    void hashwords() {
        Iterator<String> iterator = linstb.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.print(str + " ");
            hash.add((int) str.charAt(0) + (int) str.charAt(str.length() - 1));
        }
        System.out.println();
        Collections.sort(hash);
    }

    void hash(String str) {
        i_str = (int) str.charAt(0) + (int) str.charAt(str.length() - 1);
    }

    void search() {
        Integer array[] = new Integer[hash.size()];
        array = hash.toArray(array);
        int length = array.length;
        int iter = 0, begin = 0, repeat = 0;
        while (true) {
            iter++;
            if (array[length / 2 + 1] == i_str) {
                System.out.println("Number of compares: " + iter);
                break;
            } else if (array[length / 2 + 1] < i_str) {
                begin = length / 2 + 2;
            } else if (array[length / 2 + 1] > i_str) {
                length = length / 2;
            }

        }
        for (int i = 0; i < length; i++) {
            if (i_str == array[i]) {
                repeat++;
            }
        }
        System.out.println("Number of collisions: " + repeat);
    }
}


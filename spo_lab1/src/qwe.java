import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

public class qwe {
    int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    void search(int i_str) {
        int length = array.length;
        int iter = 0, begin = 0;
        boolean flag = true;
        while (flag) {
            iter++;
            if (array[length / 2 + 1] == i_str) {
                System.out.println("Fuck Tramp");
                System.out.println("Введенный элемент равен: " + array[length / 2 + 1] );
                break;
            } else if (array[length / 2 + 1] < i_str) {
                begin = length / 2 + 2;
            } else if (array[length / 2 + 1] > i_str) {
                length = length / 2;
            }
        }
        System.out.println("Iterator: " + iter);
    }
}

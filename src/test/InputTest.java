package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Vu Anh Vinh on 8/10/2016.
 */
public class InputTest {
    public static void main(String[] args){
        File f = new File("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\test\\input.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scan.hasNextLine()){
            String input = scan.next();
            System.out.println(input);
        }
    }
}

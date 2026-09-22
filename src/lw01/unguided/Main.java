package lw01.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int arrSize = inp.nextInt();

        WashService[] washList = new WashService[arrSize];

        for (int i = 0; i < arrSize; i++) {
            String type = inp.next();
            String id = inp.next();
            int days = inp.nextInt();
            int units = inp.nextInt();
            

            if (days <= 0 || units <=0) {
                throw new IllegalArgumentException("Days or units are invalid");
            }

            if (type.equals("MOTORCYCLE")) {
                washList[i] = new MotorcycleWash(id,days,units);
            } else if (type.equals("CAR")) {
                washList[i] = new CarWash(id,days,units);
            }

            System.out.println(washList[i].summary());
        }
        inp.close();
    }
}

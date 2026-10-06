package lw03.unguided;
import java.util.*;;
public class Main {
    public static void main(String[] args) {
        Scanner inpReg = new Scanner(Main.class.getResourceAsStream("registration.txt")); //hashset
        Scanner inpCheck = new Scanner(Main.class.getResourceAsStream("checkins.txt"));   //linkedhasset
    
        Set<String> idReg = new HashSet<>();
        Set<String> idCheck = new LinkedHashSet<>();

        int rejectedCount = 0;

        while (inpReg.hasNext()) {
            idReg.add(inpReg.next());
        }

        int absentCount = idReg.size();

        System.out.println("\n===== Event Check-In Results =====");
        while (inpCheck.hasNext()) {
            String id = inpCheck.next();
            if (idReg.contains(id) && idCheck.contains(id)) {
                rejectedCount++;
                System.out.println(id + " Rejected (already checked in)");
            } 
            else if (idReg.contains(id)) {
                idCheck.add(id);
                absentCount--;
                System.out.println(id + " Checked in");
            }
            else {
                rejectedCount++;
                System.out.println(id + " Rejected (not registered)");
            }
        }

        inpCheck.close();
        inpReg.close();

        System.out.println("\n===== Final Event Summary =====");
        System.out.println(
            "Registered students: " + idReg.size() +
            "\nSuccessful check-ins: " + idCheck.size() +
            "\nAbsent students: " + absentCount +
            "\nRejected attempts: " + rejectedCount
        );
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class Reorder_Data_in_Log_Files {
    //937
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comp = (s1, s2) -> {
            String[] temp1 = s1.split(" ", 2);
            String[] temp2 = s2.split(" ", 2);

            boolean isdigit1 = Character.isDigit(temp1[1].charAt(0));
            boolean isdigit2 = Character.isDigit(temp2[1].charAt(0));

            if(!isdigit1 && !isdigit2){
                int res = temp1[1].compareTo(temp2[1]);
                if(res != 0)
                    return res;
                return temp1[0].compareTo(temp2[0]);
            }else if(isdigit1 && !isdigit2){
                return 1;
            }else if(!isdigit1 && isdigit2){
                return -1;
            }else{
                return 0;
            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }
}

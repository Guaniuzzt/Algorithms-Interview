

public class RemoveCertainCharacter {


    public static void main(String[] args) {

        String a = "aaabbccddee";
        String b = "ab";
        System.out.println(method(a,b));

    }

    public static String method(String s, String target){

        if(s == null || s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(target.indexOf(array[i]) < 0){
                sb.append(array[i]);
            }
        }

        return new String(sb);

    }
}

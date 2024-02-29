public class FirstRec {
    
    public static char firstRec(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) return s.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        System.out.println(firstRec("ABC"));
    }
}

package beginner._2021_12_17.live_session;

public class StringBuilderPattern {
    public static void main(String[] args) {
        System.out.println(buildPattern());
    }
    static String buildPattern(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append((char)(i + 'A'));
            System.out.println(sb);
        }
        return sb.toString();
    }
}


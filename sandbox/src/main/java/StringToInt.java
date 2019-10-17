public class StringToInt {
    public static int stringToInt(String s) throws SpecialCharException {
        int done = 0;
        int length = 1;
        int flag = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            flag = -1;
            start += 1;
            length += 1;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '0' ||
                    s.charAt(i) == '1' ||
                    s.charAt(i) == '2' ||
                    s.charAt(i) == '3' ||
                    s.charAt(i) == '4' ||
                    s.charAt(i) == '5' ||
                    s.charAt(i) == '6' ||
                    s.charAt(i) == '7' ||
                    s.charAt(i) == '8' ||
                    s.charAt(i) == '9') {
                char j = s.charAt(i);
                done += ((int) j - 48) * Math.pow(10, (s.length() - length));
                length += 1;
//                System.out.println(j + " " + (int) j);
            } else {
                throw new SpecialCharException("Стока содержит символ " + "'" + s.charAt(i) + "'" + " на позиции " + (i + 1));
            }
        }
        done *= flag;
        System.out.println(s + " " + ((Object) s).getClass().getSimpleName());
        System.out.println(done + " " + ((Object) done).getClass().getSimpleName() + "\n");
        return done;

    }

}
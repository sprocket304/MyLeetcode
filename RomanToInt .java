class RomanToInt {
    public int romanToInt(String s) {
        int output = 0;
        if (s.length() == 1) {
            return romanChar(s.charAt(0));
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char d = s.charAt(i + 1);
            if (prevCombo(c, d)) {
                output -= romanChar(c);
            } else {
                output += romanChar(c);
            }
        }
        output += romanChar(s.charAt(s.length() - 1));
        return output;
    }

    public int romanChar(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public boolean prevCombo(char c, char d) {
        if ((c == 'I') && ((d == 'V') || (d == 'X'))) {
            return true;
        }
        if ((c == 'X') && ((d == 'L') || (d == 'C'))) {
            return true;
        }
        if ((c == 'C') && ((d == 'D') || (d == 'M'))) {
            return true;
        }
        return false;
    }
}
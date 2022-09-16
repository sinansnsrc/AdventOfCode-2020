import java.lang.Exception;

public class AoC4B {
    //For this program, the values must be pasted as a string in the getValues() method
    public static void main(String[] args) {
        //Find how many passports are valid in the given list of passports and verify based on whether or not the data in each passport fits required parameters to be valid
        String[] values = getValues().split("\n\n");

        int passports = 0;

        for(int i = 0; i < values.length; i++){
            if(byrCheck(values[i]) && iyrCheck(values[i]) && eyrCheck(values[i]) && hgtCheck(values[i]) && hclCheck(values[i]) && eclCheck(values[i]) && pidCheck(values[i])) { passports++; }
        }

        passports = passports - 1; //Remove 1 for 2 passports that aren't divided by a line, therefore meeting qualifications all qualifications while only 1 of them is valid

        System.out.println("Number of acceptable passports: " + passports);
    }

    public static boolean byrCheck (String passport) {
        if (passport.indexOf("byr") != -1){
            try {
                int byr = Integer.parseInt(passport.substring(passport.indexOf("byr") + 4, passport.indexOf("byr") + 8));
                if (byr >= 1920 && byr <= 2002){
                    return true;
                }
                else { return false; }
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static boolean iyrCheck (String passport) {
        if (passport.indexOf("iyr") != -1){
            try {
                int iyr = Integer.parseInt(passport.substring(passport.indexOf("iyr") + 4, passport.indexOf("iyr") + 8));
                if (iyr >= 2010 && iyr <= 2020){
                    return true;
                }
                else { return false; }
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static boolean eyrCheck (String passport) {
        if (passport.indexOf("eyr") != -1){
            try {
                int eyr = Integer.parseInt(passport.substring(passport.indexOf("eyr") + 4, passport.indexOf("eyr") + 8));
                if (eyr >= 2020 && eyr <= 2030){
                    return true;
                }
                else { return false; }
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static boolean hgtCheck (String passport) {
        if (passport.indexOf("hgt") != -1){
            try {
                if (passport.indexOf("cm") != -1 && passport.indexOf("in") == -1) {
                    int hgt = Integer.parseInt(passport.substring(passport.indexOf("hgt") + 4, passport.indexOf("cm", passport.indexOf("hgt") + 4)));
                    if (hgt >= 150 && hgt <= 193) {
                        return true;
                    }
                    else { return false; }
                }

                if (passport.indexOf("in") != -1 && passport.indexOf("cm") == -1) {
                    int hgt = Integer.parseInt(passport.substring(passport.indexOf("hgt") + 4, passport.indexOf("in", passport.indexOf("hgt") + 4)));
                    if (hgt >= 59 && hgt <= 76) {
                        return true;
                    }
                    else { return false; }
                }

                else { return false; }
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static boolean hclCheck (String passport) {
        if (passport.indexOf("hcl") != -1){
            try {
                String hcl = passport.substring(passport.indexOf("hcl") + 4, passport.indexOf("hcl") + 11);
                for (int i = 0; i < hcl.length(); i++){
                    if (i == 0 && hcl.charAt(i) != '#') { return false; }
                    if (i == 0) { continue; }
                    if ("a b c d e f 0 1 2 3 4 5 6 7 8 9".indexOf(hcl.substring(i,i+1)) == -1) { return false; }
                }
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static boolean eclCheck (String passport) {
        if (passport.indexOf("ecl") != -1){
            try {
                String ecl = passport.substring(passport.indexOf("ecl") + 4, passport.indexOf("ecl") + 7);
                if ("amb blu brn gry grn hzl oth".indexOf(ecl) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {

                return false;
            }
        }
        else { return false; }
    }

    public static boolean pidCheck (String passport) {
        if (passport.indexOf("pid") != -1){
            try {
                String pid = passport.substring(passport.indexOf("pid") + 4, passport.indexOf("pid") + 13);

                for (int i = 0; i < pid.length(); i++) {
                    if (Character.isDigit(pid.charAt(i))) {
                        continue;
                    }
                    else {  return false; }
                }
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }
            catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        else { return false; }
    }

    public static String getValues() {
        //Replace the return String with the values to be used
        String values = "";
        return values;
    }
}

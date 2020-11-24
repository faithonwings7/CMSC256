package cmsc256;

/**
 * Name: Anne Szarek
 * Date: 2/3/2020
 * Course Number & Section: CMSC 256, Section 902
 */

public class RamString implements WackyStringInterface {
    private String s;

    /**
     * No argument constructor
     */
    public RamString() {
        /**
         * String s cannot be null. Try catch to handle this
         */
        s = "Rodney, the Ram";
    }

    /**
     * Single string argument constructor
     */
    public RamString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        else {
            this.s = string;
        }
    }

    /**
     * setter method
     */
    @Override
    public void setWackyString(String string) {
        if (string == null){
            throw new IllegalArgumentException("Value can not be null");
        }
        else {
            this.s = string;
        }
    }

    /**
     * Getter method
     */
    @Override
    public String getWackyString() {
        return s;
    }

    /**
     * returns every third character in string
     */
    @Override
    public String getEveryThirdCharacter() {
        String result = "";
        /**
         * If statement checking length of string.
         */
        if (s.length() < 3) {
            return result;
        } else {
            /**
             * for loop to walk through string
             */
            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) % 3 == 0) {
                    result += s.charAt(i);
                }
            }

        }
        return result;
    }

    @Override
    public String getEvenOrOddCharacters(String evenOrOdd) throws IllegalArgumentException {
        String result = "";
            /**
             * Odd characters
             */
            if (evenOrOdd.equalsIgnoreCase("odd")) {
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 == 0) {
                        result += s.charAt(i);
                    }
                }
                return result;
            }
            /**
             * Even characters
             */
            else if (evenOrOdd.equalsIgnoreCase("even")) {
                for (int i = 1; i < s.length(); i++) {
                    if (i % 2 != 0) {
                        result += s.charAt(i);
                    }
                }
                return result;
            }
            else {
                throw new IllegalArgumentException("Value must be even or odd");
            }
    }

    public int countDoubleDigits() {
        int result = 0;
        boolean charB4NotDigit = false;
        boolean firstChar = false;
        boolean secondChar = false;
        boolean thirdDigit = false;
        /**
         * for loop to walk through string.
         */
        for (int i = 0; i < s.length() - 1; i++) {
            /**
             * length cannot be less thank 2
             */
            if (s.length() <2){
                result = 0;
                break;
            }
            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))
                    && i + 3 <= s.length() - 1 && Character.isDigit(s.charAt(i + 3))
                    && i + 4 <= s.length() - 1 && Character.isDigit(s.charAt(i + 4))
                    && i + 5 <= s.length() - 1 && Character.isDigit(s.charAt(i + 5))
                    && i + 6 <= s.length() - 1 && Character.isDigit(s.charAt(i + 6))
                    && i + 7 <= s.length() - 1 && Character.isDigit(s.charAt(i + 6))) {
                if(i + 7 < s.length() - 1){
                    i+=7;
                }
            }
            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))
                    && i + 3 <= s.length() - 1 && Character.isDigit(s.charAt(i + 3))
                    && i + 4 <= s.length() - 1 && Character.isDigit(s.charAt(i + 4))
                    && i + 5 <= s.length() - 1 && Character.isDigit(s.charAt(i + 5))
                    && i + 6 <= s.length() - 1 && Character.isDigit(s.charAt(i + 6))) {
                if(i + 5 < s.length() - 1){
                    i+=5;
                }
            }

            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))
                    && i + 3 <= s.length() - 1 && Character.isDigit(s.charAt(i + 3))
                    && i + 4 <= s.length() - 1 && Character.isDigit(s.charAt(i + 4))
                    && i + 5 <= s.length() - 1 && Character.isDigit(s.charAt(i + 5))) {
                if(i + 5 < s.length() - 1){
                    i+=5;
                }
            }

            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))
                    && i + 3 <= s.length() - 1 && Character.isDigit(s.charAt(i + 3))
                    && i + 4 <= s.length() - 1 && Character.isDigit(s.charAt(i + 4))) {
                if(i + 4 < s.length() - 1){
                    i+=4;
                }
                }
            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))
                    && i + 3 <= s.length() - 1 && Character.isDigit(s.charAt(i + 3))) {
                    if(i + 3 < s.length() - 1){
                        i+=3;
                    }
                }
            else if (Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))
                    && i + 2 <= s.length() - 1 && Character.isDigit(s.charAt(i + 2))) {
                    if(i + 2 < s.length()){
                        i+=2;
                    }
                }
                else if(Character.isDigit(s.charAt(i))
                    && i + 1 <= s.length()-1 && Character.isDigit(s.charAt(i + 1))){
                    result++;
                    if(i + 1 < s.length()){
                        i++;
                    }
                }
        }
        return result;
    }

    /**
     *  is Valid VCU email method
     */
    @Override
    public boolean isValidVCUEmail() {
        /**
         * boolean vars to test cases
         */
        boolean validEmail = false;
        boolean isCharacterOrDigit = false;
        boolean isAtSymbol = false;
        boolean isVCUEmail = false;
        /**
         * for loop to test if first character in string is an @ symbol
         */
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(0) == '@'){
                return validEmail;
            }
            /**
             * puttng pieces together
             */
            if (Character.isLetterOrDigit(s.charAt(i))) {
                isCharacterOrDigit = true;
                if (s.substring(1, s.length() - 1).contains("@")) {
                    isAtSymbol = true;
                    break;
                }
            }
        }

        if (s.contains("@vcu.edu")) {
            isVCUEmail = true;
        } else if (s.contains("@VCU.EDU")) {
            isVCUEmail = true;
        } else if (s.contains("@mymail.vcu.edu")) {
            isVCUEmail = true;
        } else if (s.contains("@MYMAIL.VCU.EDU")) {
            isVCUEmail = true;
        }

        if (isCharacterOrDigit == true
                && isAtSymbol == true
                && isVCUEmail == true) {
            validEmail = true;
        }
        return validEmail;
    }

    @Override
    public void ramifyString() {
       if(s.length() > 0){
           for (int i = 0; i < s.length(); i++){
               char first = s.charAt(i);
               char second = ' ';
               char third = ' ';
               if(i + 1 < s.length()){
                   second = s.charAt(i + 1);
               }
               if (i + 2 < s.length()){
                   third = s.charAt(i + 2);
               }
               if (first == '0' && second != '0'){
                   s = s.substring(0 , i) + "GoRams" + s.substring(i + 1);
                   i = i + 1;
               }
               if (first == '0' && second == '0' && third != '0'){
                   s = s.substring(0,i) + "CS@VCU" + s.substring(i + 2);
                   i = i + 2;
                   second = ' ';
                   third = ' ';
               }
               if (first == '0' && second == '0' && third == '0'){
                   i = i + 2;
               }
           }
       }
    }



    @Override
    public void convertDigitsToRomanNumeralsInSubstring
            (int startPosition, int endPosition)
            throws MyIndexOutOfBoundsException, IllegalArgumentException {
/**
 * array with roman numeral values
 */
        String[] romanNumerals = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int arrayCounter;

        /**
         * Throw error if conditions met
         */
        if (startPosition < 1 || endPosition < 1 || startPosition > s.length() || endPosition > s.length()) {
            throw new MyIndexOutOfBoundsException("Start of end position is out of bounds");
        }
        else if (startPosition > endPosition) {
            throw new IllegalArgumentException("Start position is greater than end position");
        }

        String a = s.substring(0, startPosition - 1);
        String b = s.substring(endPosition);

        for (int i = startPosition - 1; i < endPosition; i++) {
            char charAt = s.charAt(i);
            if (Character.isDigit(charAt)) {
                arrayCounter = Character.getNumericValue(charAt);
                a += romanNumerals[arrayCounter];
            } else {
                a += charAt;
            }
        }
        a += b;
        this.s = a;
    }
}

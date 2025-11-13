import java.util.*;
public class EncrypterDecrypter {

    static Scanner in = new Scanner(System.in);
    //Using Base62 to encrypt/decrypt the message.
    private static final String TokenEncrypterString = "q3vWjZ5e1bBUYI9fAHxN2p0sokcGMVFrTwJ4hK6d7LQlRnOzSXEuyti8gD";

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------
        //Taking input of the message by the user.
        System.out.println("");
        System.out.print("Enter the text to be Encrypted: ");
        String ogtext = in.nextLine();
//----------------------------------------------------------------------------------------------------------
        //Generating a random number to encrypt.
        int ascii = (int) (Math.random() * 51);

        //If ascii = 0 or 32, replace with random number (41 here).
        while (ascii == 0 || ascii == 32) {
            ascii = (int) (Math.random() * 51);
        }
//----------------------------------------------------------------------------------------------------------
        //Encrypting the message
        StringBuilder encryptext = new StringBuilder();
        for (int i = 0; i < ogtext.length(); i++) {
            char temp = ogtext.charAt(i);
            char newChar = (char) (temp + ascii);
            encryptext.append(newChar);
        }
//----------------------------------------------------------------------------------------------------------
        //Scrambling the ASCII so its more secure and generates 5 digit code.
        int scrambled = (ascii * 15000000);
        int convertscrambled = scrambled;

        //Generating the Safety Token from the ASCII code.
        int remainder;
        StringBuilder Token = new StringBuilder();
        int totalchar = TokenEncrypterString.length();
        while (convertscrambled > 0) {
            remainder = convertscrambled % totalchar;
            Token.append(TokenEncrypterString.charAt(remainder));
            convertscrambled = convertscrambled / totalchar;
        }
//----------------------------------------------------------------------------------------------------------
        //Printing the required informations.
        System.out.println("-------------------------------------------------------------");
        System.out.println("Original Text: " + ogtext);
        System.out.println("Encrypted Text: " + encryptext);
        System.out.println("Your Decrypting Token: " + Token);
        System.out.println("-------------------------------------------------------------");
//----------------------------------------------------------------------------------------------------------
        //Decrypting the message
        StringBuilder decryptext = new StringBuilder();
        for (int i = 0; i < encryptext.length(); i++) {
            char temp2 = encryptext.charAt(i);
            char newChar2 = (char) (temp2 - ascii);
            decryptext.append(newChar2);
        }
//----------------------------------------------------------------------------------------------------------
        //Taking input of the token from the user to decrypt.
        System.out.print("Enter the Token to Decrypt: ");
        String checkToken = in.nextLine();
        System.out.println("-------------------------------------------------------------");
//----------------------------------------------------------------------------------------------------------
        //Decrypting the token to check if it matches with the ascii value.
        StringBuilder temp4 = new StringBuilder();
        int index;
        for (int i = checkToken.length() - 1; i >= 0; i--) {
            temp4.append(checkToken.charAt(i));
        }
        String reversedToken = temp4.toString();

        // Converting from Token back to ASCII.
        int checkAscii = 0;
        for (int i = 0; i < reversedToken.length(); i++) {
            index = TokenEncrypterString.indexOf(reversedToken.charAt(i));
            checkAscii = checkAscii * totalchar + index;
        }

        //Unscrambling the scrambled code.
        int unscrambled;
        unscrambled = (checkAscii / 15000000);
//----------------------------------------------------------------------------------------------------------
        //Printing the accurate statement depending on the token inputted
        if (ascii == unscrambled) {
            System.out.println("Decrypted Text: " + decryptext);
            System.out.println("ASCII Changed by: " + ascii);
        } else {
            System.out.println("magi onnor message dekhar eto ki icche bara pod meredebo tor.");
        }
        System.out.println("-------------------------------------------------------------");
//----------------------------------------------------------------------------------------------------------
    }
}
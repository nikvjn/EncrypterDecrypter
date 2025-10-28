import java.util.*;
public class Encrypter {

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
        if (ascii == 0 || ascii == 32) {
            ascii = 41;
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
    }
}
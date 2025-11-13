import java.util.*;
public class Decrypter {

    static Scanner in = new Scanner(System.in);
    //Using Base62 to encrypt/decrypt the message.
    private static final String TokenEncrypterString = "q3vWjZ5e1bBUYI9fAHxN2p0sokcGMVFrTwJ4hK6d7LQlRnOzSXEuyti8gD";

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------
        // Taking input of the text to be Decrypted
        System.out.println("-------------------------------------------------------------");
        System.out.print("Enter the Text to be Decrypted: ");
        String input = in.nextLine();
        StringBuilder encryptext = new StringBuilder(input);

        // Taking input of the Token to be used while Decrypting.
        System.out.print("Enter the Token: ");
        String checkToken = in.nextLine();
        System.out.println("-------------------------------------------------------------");
//----------------------------------------------------------------------------------------------------------
        // Reversing the Inputted Token.
        StringBuilder temp4 = new StringBuilder(checkToken);
        temp4.reverse();
        String reversedToken = temp4.toString();

        // Converting from Token back to ASCII.
        int checkAscii = 0;
        int totalchar = TokenEncrypterString.length();
        for (int i = 0; i < reversedToken.length(); i++) {
            int index = TokenEncrypterString.indexOf(reversedToken.charAt(i));
            checkAscii = checkAscii * totalchar + index;
        }

        //Unscrambling the scrambled code.
        int unscrambledascii = (checkAscii / 15000000);
//----------------------------------------------------------------------------------------------------------
        //Decrypting the message
        StringBuilder decryptext = new StringBuilder();
        for (int i = 0; i < encryptext.length(); i++) {
            char temp2 = encryptext.charAt(i);
            char newChar2 = (char) (temp2 - unscrambledascii);
            decryptext.append(newChar2);
        }
//----------------------------------------------------------------------------------------------------------
        System.out.println("Decrypted Text: " + decryptext);
        System.out.println("ASCII (Based on Inputted Token): " + unscrambledascii);
        System.out.println("Output seems wrong? Re-check your Token.");
        System.out.println("-------------------------------------------------------------");
//----------------------------------------------------------------------------------------------------------
    }
}

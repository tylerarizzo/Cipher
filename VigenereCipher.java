//package com.sanfoundry.setandstring;
import java.util.Scanner;
public class VigenereCipher
{
    public static void main(String[] args)
    {
        Scanner kb =new Scanner(System.in);
        
        String strText;
        String strKey;
        String strEncryptText;
        String strEncrypted;
        String strDecrypted;
        
        System.out.print("\nEnter Text to encrypt: ");
        strEncryptText = kb.nextLine();
        System.out.print("\nEnter Key: ");
        strKey = kb.nextLine();
        strEncrypted = encrypt(strEncryptText,strKey);
        System.out.print("\n" + strEncrypted);
        
        System.out.print("\nEnter Text to decrypt: ");
        strText = kb.nextLine();
        System.out.print("\nEnter Key: ");
        strKey = kb.nextLine();
        strDecrypted = decrypt(strText,strKey);
        System.out.print("\n" + strDecrypted);
        
    }//end main(String[])
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
}
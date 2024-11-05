package org.famcs.JavaLaba4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class Encryptor 
{
    private static final String ALGORITHM = "AES";
    private SecretKey key;

    public Encryptor ()
    {
        key = generateKey();
    }
    public Encryptor (SecretKey secretKey)
    {
        key = secretKey;
    }

    private SecretKey generateKey()
    {
        try
        {
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
            keygen.init(128);
            return keygen.generateKey();
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println ("Error generatinig encryption key " + e.getMessage());
            return null;
        }
        
    }

    public void encrypt (String filePath, String encrFilePath)
    {
        try
        {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
            FileInputStream fileInput = new FileInputStream(filePath);
            FileOutputStream encrFileOutput = new FileOutputStream(encrFilePath);
            CipherOutputStream encrStream = new CipherOutputStream(encrFileOutput, cipher);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fileInput.read(buffer)) >= 0)
            {
                encrStream.write(buffer, 0, length);
            }
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println ("Error supporting encryption algorythm " + e.getMessage());
        }
        catch (NoSuchPaddingException e)
        {
            System.out.println ("Error padding cipher " + e.getMessage());
        }
        catch (InvalidKeyException e)
        {
            System.out.println ("Invalid key error " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println ("Error encrypting file " + e.getMessage());
        }
        
    }
    public void decrypt (String encrFilePath, String decrFilePath)
    {
        try
        {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
            FileInputStream fileInput = new FileInputStream(encrFilePath);
            FileOutputStream decrFileOutput = new FileOutputStream(decrFilePath);
            CipherInputStream decrStream = new CipherInputStream(fileInput, cipher);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = decrStream.read(buffer)) >= 0)
            {
                decrFileOutput.write(buffer, 0, length);
            }
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println ("Error supporting decryption algorythm " + e.getMessage());
        }
        catch (NoSuchPaddingException e)
        {
            System.out.println ("Error padding cipher " + e.getMessage());
        }
        catch (InvalidKeyException e)
        {
            System.out.println ("Invalid key error " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println ("Error decrypting file " + e.getMessage());
        }
        
    }
}

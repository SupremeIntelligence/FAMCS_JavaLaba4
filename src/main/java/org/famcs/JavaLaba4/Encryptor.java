package org.famcs.JavaLaba4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class Encryptor 
{
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private final SecretKey key;

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
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
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
        byte[] iv = new byte [16];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            try (FileOutputStream encrFileOutput = new FileOutputStream(encrFilePath);
                FileInputStream fileInput = new FileInputStream(filePath); 
                CipherOutputStream encrStream = new CipherOutputStream(encrFileOutput, cipher)
                ) 
            {
                encrFileOutput.write(iv);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = fileInput.read(buffer)) >= 0)
                {
                        encrStream.write(buffer, 0, length);
                }
            }
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println ("Error supporting encryption algorithm " + e.getMessage());
        }
        catch (NoSuchPaddingException e)
        {
            System.out.println ("Error padding cipher " + e.getMessage());
        }
        catch (InvalidKeyException e)
        {
            System.out.println ("Invalid key error " + e.getMessage());
        }
        catch (InvalidAlgorithmParameterException e)
        {
            System.out.println ("Invalid or inappropriate algorithm parameters");
        }
        catch(IOException e)
        {
            System.out.println ("Error encrypting file " + e.getMessage());
        }
        
    }
    public void decrypt (String encrFilePath, String decrFilePath)
    {
            try (FileOutputStream decrFileOutput = new FileOutputStream(decrFilePath);
                 FileInputStream fileInput = new FileInputStream(encrFilePath);) 
            {
                byte[] iv = new byte[16];
                if (fileInput.read(iv) != iv.length) 
                {
                throw new IOException("Error reading IV");
                }
                IvParameterSpec ivSpec = new IvParameterSpec(iv);

                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

                try (CipherInputStream decrStream = new CipherInputStream(fileInput, cipher);)
                {
                    byte[] buffer = new byte[1024];
                int length;
                while ((length = decrStream.read(buffer)) >= 0)
                {
                    decrFileOutput.write(buffer, 0, length);
                }
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
        catch (InvalidAlgorithmParameterException e)
        {
            System.out.println ("Invalid or inappropriate algorithm parameters");
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

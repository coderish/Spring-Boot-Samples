package com.coderish.tutorial.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;

public class AESCryptoUtil {

    private static String storetype = "JCEKS";
    private static String aesKeyPath = "C:\\Users\\Acuver\\idea-portal-AES.key";
    private static String pwd = "password";
    private static String alias = "aicAlias";

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance(storetype);
            FileInputStream stream = new FileInputStream(aesKeyPath);
            keyStore.load(stream, pwd.toCharArray());
            Key key = keyStore.getKey(alias, pwd.toCharArray());

            String data = "ACV9999";

            //Encrypt Data
            String encryptedData = encryptWithAESKey(data, key.getEncoded());
            System.out.println("Encrypted Data : " + encryptedData);

            //Decrypt Data
            System.out.println("Decrypted Data : " + decryptWithAESKey(encryptedData, key.getEncoded()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String encryptWithAESKey(String data, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        SecretKey secKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] newData = cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(newData);
    }

    public static String decryptWithAESKey(String inputData, byte[] key) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] newData = cipher.doFinal(Base64.decodeBase64(inputData.getBytes()));
        return new String(newData);
    }
}
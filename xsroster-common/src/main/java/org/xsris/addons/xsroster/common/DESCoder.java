package org.xsris.addons.xsroster.common;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * DES symmetric encryption algorithm
 *
 * @author axfnk
 */
public class DESCoder {
	/**
	 * key algorithm
	 */
	public static final String KEY_ALGORITHM = "DES";

	/**
	 * encryption-decryption/working mode/padding mode
	 */
	public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

	public static byte[] decodeBase64String(String strData) {
		if (strData == null) {
			return null;
		}
		return Base64.decodeBase64(strData.getBytes(StandardCharsets.UTF_8));
	}

	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = DESCoder.toKey(key);
		Cipher cipher = Cipher.getInstance(DESCoder.CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 *
	 * @param encryptedChars
	 * @param keyChars
	 * @return
	 * @throws Exception
	 */
	public static String decryptString(String encryptedChars, String keyChars) throws Exception {
		if ((encryptedChars == null) || (keyChars == null)) {
			return null;
		}

		byte[] key = DESCoder.decodeBase64String(keyChars);
		byte[] data = DESCoder.decodeBase64String(encryptedChars);
		data = DESCoder.decrypt(data, key);

		return new String(data, StandardCharsets.UTF_8);
	}

	public static String encodeBase64String(byte[] binaryData) {
		if (binaryData == null) {
			return null;
		}
		return new String(Base64.encodeBase64(binaryData, false), StandardCharsets.UTF_8);
	}

	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = DESCoder.toKey(key);
		Cipher cipher = Cipher.getInstance(DESCoder.CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 *
	 * @param sourceChars
	 * @param keyChars
	 * @return
	 * @throws Exception
	 */
	public static String encryptString(String sourceChars, String keyChars) throws Exception {
		if ((sourceChars == null) || (keyChars == null)) {
			return null;
		}

		byte[] key = DESCoder.decodeBase64String(keyChars);
		byte[] data = DESCoder.encrypt(sourceChars.getBytes(StandardCharsets.UTF_8), key);

		return DESCoder.encodeBase64String(data);
	}

	/**
	 * initialize key
	 *
	 * @return byte[] key in binary stream
	 */
	public static byte[] initkey() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance(DESCoder.KEY_ALGORITHM);
		kg.init(56);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String str = "agfa123";
		System.out.println("Original: " + str);
		// step 1 - initialize key
		byte[] key = DESCoder.initkey();
		System.out.println("Key: " + DESCoder.encodeBase64String(key));
		// step 2 - encrypt data
		byte[] data = DESCoder.encrypt(str.getBytes(), key);
		String temp = DESCoder.encodeBase64String(data);
		System.out.println("Encrypted: " + temp);
		// step 3 - decrypt data
		byte[] data2 = DESCoder.decodeBase64String(temp);
		data = DESCoder.decrypt(data2, key);
		// data = DESCoder.decrypt(data, key);
		System.out.println("Decrypted: " + new String(data));

		String keyChars = "E/d2eUX73ws=";
		String sourceChars = "agfa123";
		String encryptedChars = "";

		System.out.println("Original: " + sourceChars);
		encryptedChars = DESCoder.encryptString(sourceChars, keyChars);
		System.out.println("Encrypted: " + encryptedChars);
		String decryptedChars = DESCoder.decryptString(encryptedChars, keyChars);
		System.out.println("Decrypted: " + decryptedChars);
	}

	/**
	 * transform binary stream to key object
	 *
	 * @param key binary stream
	 * @return Key key object
	 */
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DESCoder.KEY_ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}
}

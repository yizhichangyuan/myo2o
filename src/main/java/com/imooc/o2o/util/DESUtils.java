package com.imooc.o2o.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES加密、解密，对数据库连接关键信息进行加解密
 * DES是一种对称加密算法，所谓对称加密算法就是加密、解密采用相同密匙的算法
 */
public class DESUtils {

    private static Key key;
    private static String KEY_STR = "o2o"; // 加密、解密密匙
    private static String CHARSETNAME = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            // 生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            // 运行SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            // 上传密匙种子
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密后的信息
     *
     * @param str
     * @return
     */
    public static String getEncryptString(String str) {
        // 加密、解密都是通过byte实现
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] bytes = str.getBytes(CHARSETNAME);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key); // 初始化为加密操作
            byte[] doFinal = cipher.doFinal(bytes);
            return base64Encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将加密字符串进行解密
     *
     * @param str
     * @return
     */
    public static String getDecryptString(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] bytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key); // 初始化为解密操作
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, CHARSETNAME);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        System.out.println(getEncryptString("root")); //输出：B9AlO0AeWHk=
        System.out.println(getEncryptString("make1234")); // 输出：uO8i96kcyxN4Ttw6PQZiZg==
    }
}

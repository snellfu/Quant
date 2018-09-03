import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class AEStest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String str = "user=admin&pwd=admin";
        String key = "12345678";
        String encrytStr;
        byte[] encrytByte;

        byte[] byteRe = enCrypt(str, key);

        //加密过的二进制数组转化成16进制的字符串
        encrytStr = parseByte2HexStr(byteRe);
        System.out.println("加密后：" + encrytStr);

        //加密过的16进制的字符串转化成二进制数组
        encrytByte = parseHexStr2Byte(encrytStr);
        System.out.println("解密后：" + deCrypt(encrytByte, key));


    }

    /**
     * 加密函数
     *
     * @param content 加密的内容
     * @param strKey  密钥
     * @return 返回二进制字符数组
     * @throws Exception
     */
    public static byte[] enCrypt(String content, String strKey) throws Exception {
        KeyGenerator keygen;
        SecretKey desKey;
        Cipher c;
        byte[] cByte;
        String str = content;

        keygen = KeyGenerator.getInstance("AES");
        keygen.init(128, new SecureRandom(strKey.getBytes()));

        desKey = keygen.generateKey();
        c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, desKey);

        cByte = c.doFinal(str.getBytes("UTF-8"));

        return cByte;
    }

    /**
     * 解密函数
     *
     * @param src    加密过的二进制字符数组
     * @param strKey 密钥
     * @return
     * @throws Exception
     */
    public static String deCrypt(byte[] src, String strKey) throws Exception {
        KeyGenerator keygen;
        SecretKey desKey;
        Cipher c;
        byte[] cByte;

        keygen = KeyGenerator.getInstance("AES");
        keygen.init(128, new SecureRandom(strKey.getBytes()));

        desKey = keygen.generateKey();
        c = Cipher.getInstance("AES");

        c.init(Cipher.DECRYPT_MODE, desKey);


        cByte = c.doFinal(src);

        return new String(cByte, "UTF-8");
    }


    /**
     * 2进制转化成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}

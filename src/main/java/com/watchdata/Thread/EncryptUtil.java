package com.watchdata.Thread;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/08/02
 *     desc  : utils about encrypt
 * </pre>
 */
public final class EncryptUtil {

    private EncryptUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] HEX2Bytes(String hexstr) {
        if (hexstr != null && hexstr.length() % 2 == 0) {
            byte[] bytes = new byte[hexstr.length() / 2];

            for (int i = 0; i < hexstr.length() / 2; ++i) {
                String bytestr = hexstr.substring(2 * i, 2 * i + 2);
                bytes[i] = (byte) Integer.parseInt(bytestr, 16);
            }

            return bytes;
        } else {
            throw new IllegalArgumentException("data is null or is not mutiple by 2");
        }
    }

    public static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};



    public static String bytes2HEX(byte[] bytes) {
        return bytes2HEX(bytes, 0, bytes == null ? 0 : bytes.length);
    }

    public static String bytes2HEX(byte[] bytes, int start, int offset) {
        if (bytes == null) {
            throw new IllegalArgumentException("data is null");
        } else {
            StringBuffer sb = new StringBuffer();

            for(int i = start; i < start + offset; ++i) {
                sb.append(HEX[bytes[i] >> 4 & 15]);
                sb.append(HEX[bytes[i] & 15]);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String phone = "0130000100012020";
        String key = "5F26729F19CAF901A855C0420882CC85";
        String transformation = "DESede/ECB/NoPadding";
        String algorithm = "DESede";


        String s = key + key.substring(0,16);
        byte[] temp = HEX2Bytes(s);
        try {
            SecretKeySpec keySpec = new SecretKeySpec(temp, algorithm);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            byte[] result = cipher.doFinal(HEX2Bytes(phone));
           System.out.println("result:" + bytes2HEX(result));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

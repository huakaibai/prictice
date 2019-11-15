package com.watchdata.ecc;

import com.watchdata.util.HexSupport;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

/**
 * @author zhibin.wang
 * @create 2019-11-15 9:34
 * @desc 椭圆曲线算法
 **/
public class EccTest {

    public static void main(String[] args) {

      //  String curveName = "secp256k1";
        String curveName = "brainpoolP256r1";


        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("EC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // curveName这里取值：secp256k1
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec(curveName);
        try {
           // keyPairGenerator.initialize(ecGenParameterSpec, new SecureRandom());
            keyPairGenerator.initialize(ecGenParameterSpec,Se);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }/* catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥

        System.out.println(HexSupport.toHexFromBytes(keyPair.getPublic().getEncoded()));
        // 获取私钥
        keyPair.getPrivate();

        System.out.println(HexSupport.toHexFromBytes(keyPair.getPrivate().getEncoded()));
    }
}

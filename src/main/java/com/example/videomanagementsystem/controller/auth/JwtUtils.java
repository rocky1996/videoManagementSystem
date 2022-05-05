package com.example.videomanagementsystem.controller.auth;

import com.example.videomanagementsystem.util.JacksonUtil;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtils {

    //todo 暂时不实现token超时
//    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 创建秘钥
     */
    private static final byte[] SECRET = "videoManagementSystem".getBytes();

    /**
     * 生成HS256对称加密token
     */
    public static String getHS256Token(UserInfo userInfo) {
        try {
            //创建一个32-byte的密匙
            MACSigner macSigner = new MACSigner(SECRET);
            //建立payload载体
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("userInfo", userInfo)
                    .build();
            //建立签名
            SignedJWT signedJwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJwt.sign(macSigner);
            //生成token
            return signedJwt.serialize();
        } catch (Exception e) {
            log.error("生成token失败", e);
        }
        return null;
    }

    /**
     * 检验HS256对称加密token
     */
    public static UserInfo checkHS256Token(String token) throws Exception {
        SignedJWT jwt = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier(SECRET);
        //校验是否有效
        return checkParam(jwt, jwt.verify(verifier));
    }

    private static RSAKey rsaKey;

    private static RSAKey publicRsaKey;

    private static final int SIZE = 2048;

    static {
       //生成公钥，公钥是提供出去，让使用者校验token的签名
        try {
            rsaKey = new RSAKeyGenerator(SIZE).generate();
            publicRsaKey = rsaKey.toPublicJWK();
        } catch (Exception e) {
            log.error("初始化公钥失败", e);
        }
    }

    /**
     * 生成RS256非对称加密token
     */
    public static String getRS256Token(UserInfo userInfo) {
        try {
            //生成秘钥,秘钥是token的签名方持有，不可对外泄漏
            RSASSASigner rsassaSigner = new RSASSASigner(rsaKey);
            //建立payload 载体
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("userInfo", userInfo)
                    .build();
            //建立签名
            SignedJWT signedJwt = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
            signedJwt.sign(rsassaSigner);
            //生成token
            return signedJwt.serialize();
        } catch (Exception e) {
            log.error("生成token失败", e);
        }
        return null;
    }

    /**
     * 检验RS256非对称加密token
     */
    public static UserInfo checkRS256Token(String token) throws Exception{
        SignedJWT jwt = SignedJWT.parse(token);
        //添加私密钥匙 进行解密
        RSASSAVerifier rsassaVerifier = new RSASSAVerifier(publicRsaKey);
        return checkParam(jwt, jwt.verify(rsassaVerifier));
    }

    /**
     * token检验
     */
    private static UserInfo checkParam(SignedJWT jwt, boolean verify) throws Exception {
        //校验是否有效
        if (!verify) {
            throw new Exception("token无效");
        }
//        //校验超时
//        Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
//        if (null != expirationTime && new Date().after(expirationTime)) {
//            throw new Exception("token已过期");
//        }
        //获取载体中的数据
        Object userInfo = jwt.getJWTClaimsSet().getClaim("userInfo");
        //是否有userInfo
        if (userInfo == null) {
            throw new Exception("用户信息为空");
        }
        return JacksonUtil.strToBean(JacksonUtil.beanToStr(userInfo), UserInfo.class);
    }
}

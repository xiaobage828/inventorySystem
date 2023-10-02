package cn.xiaobage.config.util;

import cn.xiaobage.config.exception.TokenAuthException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaobage
 * @package cn.xiaobage.config.util
 * @createTime 2022/11/29 - 22:07
 * @description
 */
public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "xiaobage";

    /**
     * 过期时间, 单位为秒
     *
     **/
    private static final Long EXPIRATION = 2 * 24 * 60 * 60L;

    /**
     * 生成用户token,设置token超时时间
     * 添加用户信息，那么可以放入map中
     */
    public static String createToken(Map<String, Object> params) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);

        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // 添加头部
        JWTCreator.Builder builder = JWT.create()
                .withHeader(header);
        // 信息体
        params.forEach((k, v) -> builder.withClaim(k, v.toString()));
        // 生成token
        return builder
                //超时设置,设置过期的日期
                .withExpiresAt(expireDate)
                //签发时间
                .withIssuedAt(new Date())
                //SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static Map<String, Object> verifyToken(String token) {
        DecodedJWT jwt = null;
        Map<String, Object> result = new HashMap<>();
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);

            jwt.getClaims().forEach((k, v) -> result.put(k, v.asString()));
        } catch (Exception e) {
            //错误处理
            System.out.println("verifyToken_error" + e);
            throw new TokenAuthException(e.getMessage());
        }
        return result;
    }


    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "j3");

        String token = createToken(params);

        System.out.println(token);

        Map<String, Object> stringObjectMap = verifyToken(token + 1);

        System.out.println(stringObjectMap);
    }
}

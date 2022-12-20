package tp.security;
import tp.model.Admins;
import tp.model.TokenUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;

public class SafeNavigation {

    public static final long TOKEN_VALIDITY = 5 * 60 * 60;
    public static TokenUtils encryptThisString(Admins admin) {
        Date dateNow = new Date(System.currentTimeMillis());
        Date dateExp = new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
        Timestamp expiration = new java.sql.Timestamp(dateExp.getTime());

        String input = admin.getEmail()+new java.sql.Timestamp(dateNow.getTime())+admin.getPassword();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return new TokenUtils(hashtext, expiration, admin);
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

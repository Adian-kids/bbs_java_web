package bbs.utils;
import bbs.utils.md5;

import java.security.NoSuchAlgorithmException;

public class testmd5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "admin";
        String md5str = new md5().md5Encrypt(str);
        System.out.println(md5str);

    }
}

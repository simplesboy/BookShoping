package com.neu.shop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.apache.commons.codec.binary.Base64;

public class Utils {
	/**
     * 转换图片流为byte类型
     *
     * @param inputStream 图片输入流
     * @return 图片byte[]
     * @throws IOException io异常
     * @author liuyanbo
     * @date 2018/10/16
     */
    public static byte[] imgToByte(InputStream inputStream) throws IOException {
        byte[] data = new byte[inputStream.available()];
        int read = inputStream.read(data);
        if (read < 5) {
            return null;
        }
        inputStream.close();
        StringBuilder head = new StringBuilder("data:image/png;base64,");
        String str = new String(Objects.requireNonNull(Base64.encodeBase64(data)),"UTF-8");
        head.append(str);
        return head.toString().getBytes("UTF-8");
    }
}

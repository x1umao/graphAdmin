package com.ntu.graphadmin.util;

import java.util.Random;

public class RandomUtil {
    public static String getRandom(long seed){
        Random random = new Random(seed);
        return String.valueOf(random.nextInt());
    }
}

package util;

import java.util.Random;

public class RandomSimplePassword {

    public String randomStringPassword(Integer passwordLength) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = passwordLength;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public String randomSaltedPassword(Integer passwordLength) {

        Random r = new Random();

        char[] choices = ("abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "01234567890" +
                "$#_").toCharArray();

        StringBuilder salt = new StringBuilder(passwordLength);
        for (int i = 0; i<passwordLength; ++i)
            salt.append(choices[r.nextInt(choices.length)]);

        System.out.println(salt.toString());
        return salt.toString();


    }
}

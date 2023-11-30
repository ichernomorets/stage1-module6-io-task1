package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        ProfileProperties profileProperties = new ProfileProperties();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitKeyValue = line.split(":");
                if (splitKeyValue.length != 2) {
                    continue; // skipping rows that don't have key and value
                }

                profileProperties.put(splitKeyValue[0].trim(), splitKeyValue[1].trim());
            }

            return new Profile(profileProperties.getString("Name"),
                    profileProperties.getInteger("Age"),
                    profileProperties.getString("Email"),
                    profileProperties.getLong("Phone"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

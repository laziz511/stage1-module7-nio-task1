package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        
        Profile profile = null;
        StringBuilder st = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String temp;
            while((temp = reader.readLine()) != null) {
                st.append(temp).append("\n");
            } 
        } catch( IOException e) {
            e.printStackTrace();
        }
        
        String[] lines = st.toString().split("\n");
        
        String name = lines[0].split(" ")[1];
        Integer age = Integer.parseInt(lines[1].split(" ")[1]);
        String email = lines[2].split(" ")[1];
        Long phone = Long.parseLong(lines[3].split(" ")[1]);
        
        profile = new Profile(name, age, email, phone);
        
        return profile;                             
    }
}

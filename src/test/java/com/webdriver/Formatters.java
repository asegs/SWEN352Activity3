package com.webdriver;

import java.util.ArrayList;

public class Formatters {
    public String formatTigerCenter(String classInfo){
        String[] tokens = classInfo.split("\n");
        StringBuilder sb = new StringBuilder();
        boolean locationHasTwo = false;
        boolean daysTimesHasTwo = false;
        if (tokens.length%2==0){
            locationHasTwo = true;
        }
        if (locationHasTwo && tokens.length == 12){
            daysTimesHasTwo = true;
        }else if (!locationHasTwo && tokens.length == 11){
            daysTimesHasTwo = true;
        }
        if (locationHasTwo && daysTimesHasTwo){
            sb.append("Days/Times: ").append(tokens[7]).append(", ").append(tokens[8]).append('\n');
            sb.append("Location: ").append(tokens[9]).append(", ").append(tokens[10]).append('\n');
            sb.append("Instructor: ").append(tokens[11]).append('\n');
        }else if (locationHasTwo){
            sb.append("Days/Times: ").append(tokens[7]).append(", ").append(tokens[8]).append(", ").append(tokens[9]).append(", ").append(tokens[10]).append('\n');
            sb.append("Location: ").append(tokens[11]).append(", ").append(tokens[12]).append('\n');
            sb.append("Instructor: ").append(tokens[13]).append('\n');
        }else if(daysTimesHasTwo){
            sb.append("Days/Times: ").append(tokens[7]).append(", ").append(tokens[8]).append('\n');
            sb.append("Location: ").append(tokens[9]).append('\n');
            sb.append("Instructor: ").append(tokens[10]).append('\n');
        }else{
            sb.append("Days/Times: ").append(tokens[7]).append(", ").append(tokens[8]).append(", ").append(tokens[9]).append(", ").append(tokens[10]).append('\n');
            sb.append("Location: ").append(tokens[11]).append('\n');
            sb.append("Instructor: ").append(tokens[12]).append('\n');
        }
        return sb.toString();
    }

    public String foundFormatter(String input){
        return input.length()==0 ? "Contact information not found" : input;
    }

    public String formatSWENSite(ArrayList<ArrayList<String>> staff,String address){
        ArrayList<String> chairInfo = new ArrayList<String>();
        for (ArrayList<String> a:staff){
            if (a.get(1).equals("Department Chair")){
                chairInfo = a;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Software Engineering Chair Information:").append('\n');
        sb.append("Name: ").append(foundFormatter(chairInfo.get(0))).append('\n');
        sb.append("Email: ").append(foundFormatter(chairInfo.get(4))).append('\n');
        sb.append("Title: ").append(foundFormatter(chairInfo.get(1))).append('\n');
        sb.append("Department: ").append(foundFormatter(chairInfo.get(2))).append('\n');
        sb.append("College: ").append(foundFormatter(chairInfo.get(3))).append('\n');
        sb.append("\n\nAddress: ").append(address);
        System.out.println(sb.toString());
        return sb.toString();
    }
}

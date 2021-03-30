package com.webdriver;

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
}

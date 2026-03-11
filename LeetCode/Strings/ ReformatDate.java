// https://leetcode.com/problems/reformat-date/description/


class Solution {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        String dayStr = split[0];
        String monthStr = split[1];
        String year = split[2];
    
    
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String month = "";
        for (int i = 0; i < 12; i++) {
            if (months[i].equals(monthStr)) {
                month = String.format("%02d", i + 1);
                break;
            }
        }
        
        StringBuilder dayBuilder = new StringBuilder();
        for (char c : dayStr.toCharArray()) {
            if (Character.isDigit(c)) {
                dayBuilder.append(c);
            }
        }
        String day = dayBuilder.toString();
        if (day.length() == 1) {
            day = "0" + day; 
        }
    
        
        return year + "-" + month + "-" + day;
    
    }
}
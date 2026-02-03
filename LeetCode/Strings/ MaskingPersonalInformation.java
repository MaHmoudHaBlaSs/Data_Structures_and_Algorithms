// https://leetcode.com/problems/masking-personal-information/description/


class Solution {
    public String maskPII(String s) {
    if(s.matches(".*\\d.*")){
        return handlePhoneNumber(s);
    }else{
        return handleEmail(s);
    }
}

public String handlePhoneNumber(String phoneNumber) {
    char[] chars = phoneNumber.toCharArray();
    StringBuilder word = new StringBuilder();
    
    StringBuilder lastFourDigits = new StringBuilder();
    int count = 0;
    int digitsCount = 0;
    for(int i = chars.length - 1; i >= 0; i--) {
        if(chars[i] >= '0' && chars[i] <= '9'){
            if(count < 4){
                lastFourDigits.append(chars[i]);
                count++;
            }
            digitsCount++;
        }
    }
    lastFourDigits.reverse();
    
    
    switch (digitsCount) {
        case 10:
            word.append("***-***-");
            break;
        case 11:
            word.append("+*-***-***-");
            break;
        case 12:
            word.append("+**-***-***-");
            break;
        case 13:
            word.append("+***-***-***-");
            break;
    }
    
    word.append(lastFourDigits);
    return word.toString();

}
public String handleEmail(String email) {
    int emailIndex = email.indexOf("@");
    String lowerCase = email.toLowerCase();
    StringBuilder sb = new StringBuilder();
    sb.append(lowerCase.charAt(0));
    sb.append("*****");
    sb.append(lowerCase.substring(emailIndex - 1));
    return sb.toString();
}
}
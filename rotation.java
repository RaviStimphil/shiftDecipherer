/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deciphering;

/**
 *
 * @author Ravi
 */
public class rotation {
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
    'q','r','s','t','u','v','w','x','y','z'};
    static String[] lookout = {"ch","or","re","er","il","me","co","to","st","th","no","is","in",
    "ne","bl","hi","ea","ry","do","la","ar","at","al","it"};
    
    
    public static void allChoice (String victim){
        String[] fillIn = new String[26];
        int best = 0;
        int tracker = 0;
        for(int i = 0; i < 26; i++){
            //System.out.println(convert(victim,i) + " " + checkingStage3(convert(victim,i).toCharArray()));
            fillIn[i] = convert(victim,i);
            if(best < checkingStage3(convert(victim,i).toCharArray())){
                best = checkingStage3(convert(victim,i).toCharArray());
                tracker = i;
            }
        }
        System.out.println(fillIn[tracker]);
        
    }
    public static int checkingStage3(char[] victim){
        int i = 0;
        int score = 0;
        while(i < victim.length-1){
           score = score + checkingStage2(victim[i],victim[i+1]);
           i++;
        }
        
        return score;
    }
    public static int checkingStage2(char start, char other){
        int i = 0;
        int score = 0;
        while(i < lookout.length){
            score = score + checkingStage1(start,other,lookout[i].toCharArray(),1);
            i++;
        }
        
        return score;
    }
    public static int checkingStage1(char start, char other, char[] target, int rank){
        int score = 0;
        if(start == target[0] && other == target[1]){
            score = score + rank;
        }
        
        return score;
    }
    public static String convert(String victim, int target){
        char temp[] = victim.toCharArray();
        
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == ' '){
                
            }else{
                temp[i] = solve(temp[i], target);
            }
        }
        
        
        String backToString = new String(temp);
        victim = backToString;
        
        return victim;
    }
    
    public static char solve(char victim, int target){
        
        int i = 0;
        while(victim != alphabet[i]){
            i++;
        }
        char temp = ' ';
        for(int j = 0; j < target; j++){
            if(i > 0){
                i--;
            }
            else{
                i = 25;
            }
        }
        victim = alphabet[i];
        
        return victim;
    }
    //I have no idea what to do.
    //I need to get a bank of common words or pairings of letters
    //Then compare that to the string given.
    //I need a big bank.
    //But I'm going to have to have a lot of strings, 26 of them.
    //HOWWWWw
}

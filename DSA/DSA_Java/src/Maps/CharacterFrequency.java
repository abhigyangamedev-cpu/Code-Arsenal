package Maps;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args){
        char[] numbers = {'a','c','c','a','d','b'};
        Map<Character,Integer> freq = new HashMap<>();

        for(char ele : numbers){
            if(freq.containsKey(ele)){
                freq.put(ele,freq.get(ele)+1);
            }else{
                freq.put(ele,1);
            }
        }

        System.out.print(freq);
    }
}

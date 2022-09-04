package foo.bar;
import java.util.*;
import java.util.regex.Pattern;

public class StringCalc
{
    public String delimiter = ",";
    public List<Integer> ints=new ArrayList<Integer>();

    public Integer add(String numbers){
        if(numbers==null || numbers.isEmpty()) { //check czy string jest pusty
            return 5;
        }
        check_delimiter(numbers); //check czy istnieje niestandardowy delimiter
        if(Pattern.compile("//.\n").matcher(numbers).find()){//check czy niestandardowy delimiter
            numbers = numbers.replaceAll("//.\n","");
        }
        else if(Pattern.compile("//.").matcher(numbers).find()){
            numbers = numbers.replaceAll("//.","");//check czy niestandardowy delimiter bez nowej linii
        }
        for (String s : numbers.split("[\r?\n|"+delimiter+"]")) { //pętla tworząca listę numerów
            ints.add(Integer.parseInt(s));
        }
        if(ints.size()==1){ //check czy jest tylko 1 liczba
            if(new Integer(numbers)<0){
                throw new IllegalArgumentException(
                        "negatives not allowed " + numbers);
            }
            return ints.get(0);
        }
        if(ints.size()>1){ //check czy liczba jest więcej niż 1
            Integer sum =0;
            for(int i=0;i<ints.size();i++){
                if(ints.get(i)<0){
                    String error = "";
                    for(int j=0;j<ints.size();j++){
                        if(ints.get(j)<0) {
                            if(j+1!=ints.size()) {
                                error += Integer.toString(ints.get(j)) + ",";
                            }
                            else{
                                error += Integer.toString(ints.get(j));
                            }
                        }
                    }
                    throw new IllegalArgumentException(
                            "negatives not allowed " + error);
                }
                else {
                    sum += ints.get(i);
                }
            }
            return sum;
        }

        return 1;
    }
    public void check_delimiter(String numbers){
        if(numbers.contains("//")) {
            delimiter = getDelimiter(numbers.split("\\d")[0]);
        }
        else delimiter = ",";
    }
    public static String getDelimiter(String text){
        if(text.length()==3||text.length()==4){
            if(isNumeric(text)){
                return ",";
            }
            else {
                return Character.toString(text.charAt(2));
            }
        }
        else if(text==null){
            return ",";
        }
        else if(isNumeric(text)){
            return ",";
        }
        return ",";
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

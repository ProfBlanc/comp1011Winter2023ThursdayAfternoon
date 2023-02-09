package ca.georgiancollege.comp1011winter2023thursdayafternoon;

public class StringAndStringBuilderModel {

    private String content, method, arguments, result;
    private static final String COMMA = ",", ERROR_MSG = "ERROR", SW = "startswith", EW = "endswith";

    public StringAndStringBuilderModel(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    private boolean hasMultipleArguments(){
        return arguments.contains(COMMA);
    }
    private String[] splitArguments(){
        return arguments.split(COMMA);
    }
    public void request(String content, String method, String arguments){

        setArguments(arguments);
        setContent(content);
        setMethod(method);

        "hello".startsWith("he", 1);

        Object valueReturned = switch (method.toLowerCase()){
            case "length" : {yield content.length();}
            case "substring":
            {
                if(hasMultipleArguments()){
                    String[] args = splitArguments();
                    try{
                        int first = Integer.parseInt(args[0]);
                        int second = Integer.parseInt(args[1]);
                        yield content.substring(first, second);
                    }
                    catch (Exception e){
                        yield ERROR_MSG;
                    }
                }
                else
                    yield content.substring(Integer.parseInt(arguments));
            }
            case SW, EW: {
                if(hasMultipleArguments() && !method.equals(EW)){
                    String args[] = splitArguments();
                    try {
                        int index = Integer.parseInt(args[1]);
                        yield content.startsWith(args[0], index);
                    }
                    catch (Exception e){
                        yield ERROR_MSG;
                    }
                }
                else{
                    yield method.equals(SW) ? content.startsWith(arguments) : content.endsWith(arguments);
                }
            }
            case "repeat": yield content.repeat(Integer.parseInt(arguments));
            case "equals": yield content.equals(arguments);
            case "contains": yield content.contains(arguments);
            default : yield "Unknown";
        };

        /*
                methodString.getItems().add("length");
        methodString.getItems().add("contains");
        methodString.getItems().add("startsWith");
        methodString.getItems().add("substring");


        methodString.getItems().add("endsWith");
        methodString.getItems().add("repeat");
        methodString.getItems().add("equals");
        methodString.getItems().add("equalsIgnoreCase");

         */


        setResult(valueReturned.toString());


    }

}

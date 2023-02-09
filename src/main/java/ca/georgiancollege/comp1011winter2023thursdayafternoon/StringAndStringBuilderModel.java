package ca.georgiancollege.comp1011winter2023thursdayafternoon;

public class StringAndStringBuilderModel {

    private String content, method, arguments, result;

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

    public void request(String content, String method, String arguments){

        setArguments(arguments);
        setContent(content);
        setMethod(method);

        Object valueReturned = switch (method.toLowerCase()){
            case "length" : {yield content.length();}
            case "substring": yield content.substring(Integer.parseInt(arguments));
            default : yield "Unknown";
        };

        setResult(valueReturned.toString());


    }

}

package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Locale;

public class StringAndStringBuilderController {

    @FXML
    private TextField argumentString;

    @FXML
    private TextField resultString;

    @FXML
    private TextField contentString;

    @FXML
    private ComboBox<String> methodString;

    @FXML
    private TextField argumentSB;

    @FXML
    private TextField resultSB;

    @FXML
    private TextField contentSB;

    @FXML
    private ComboBox<String> methodSB;

    private StringAndStringBuilderModel model = new StringAndStringBuilderModel();

    @FXML
    void onSubmitSB(ActionEvent event) {

        String[] info = getFormData(contentSB, argumentSB, methodSB);
        model.requestSB(info[0], info[2], info[1]);

        resultSB.setText(model.getResult());
/*
        if(info[2].equals("append"))
            contentSB.setText(contentSB.getText() + model.getResult());

            ONLY CAN HAPPEN IF NOT FIRST TIME
*/


    }

    @FXML
    void pastOnSubmitString(ActionEvent event) {

        StringBuilder sb = new StringBuilder();
        //get the values for content, method, arguments
        sb.append(contentString.getText());
        sb.append("-");
        sb.append(argumentString.getText());
        sb.append("-");
        sb.append(methodString.getSelectionModel().getSelectedItem());

        // add all those values to the result textfield
        //resultString.setText(sb.toString());

        String[] info = sb.toString().split("-");
        String content = info[0];
        String args = info[1];
        String method = info[2];
        /*
            Enhanced Switch statement

           returned Object =  switch(expression)

         */
        Object result = switch (method.toLowerCase()){
            case "length" : {yield content.length();}
            case "substring": yield content.substring(Integer.parseInt(args));
            default : yield "Unknown";
        };

        resultString.setText(result.toString());

    }

    String[] getFormData(TextField content, TextField argument, ComboBox<String> method){
        String separator = "-";
        StringBuilder sb = new StringBuilder();
        //get the values for content, method, arguments
        sb.append(content.getText());
        sb.append(separator);
        sb.append(argument.getText());
        sb.append(separator);
        sb.append(method.getSelectionModel().getSelectedItem());


        return sb.toString().split(separator);

    }
    @FXML
    void onSubmitString(ActionEvent event) {

        String[] info = getFormData(contentString, argumentString, methodString);
        model.request(info[0], info[2], info[1]);

        resultString.setText(model.getResult());

    }

    @FXML
    void initialize(){
        //document on load method
        methodString.getItems().add("length");
        methodString.getItems().add("contains");
        methodString.getItems().add("startsWith");
        methodString.getItems().add("substring");


        methodString.getItems().add("endsWith");
        methodString.getItems().add("repeat");
        methodString.getItems().add("equals");

        methodString.getSelectionModel().selectFirst();

        methodSB.getItems().add("append");
        methodSB.getItems().add("insert");
        methodSB.getItems().add("capacity");
        methodSB.getItems().add("delete");
        methodSB.getItems().add("deleteCharAt");
        methodSB.getItems().add("length");
        methodSB.getItems().add("setLength");
        methodSB.getItems().add("replace");
        methodSB.getItems().add("*remove all contents*"); // sb.delete(0, sb.length())  setLength(0)
/*
                append
                insert
                capacity
                delete
                deleteCharAt
                length
                replace

 */


        /*
                ComboBox
                    Items
                        length
                        contains

            * Act of selecting is accomplished by Model
                SelectionModel
         */


    }


}

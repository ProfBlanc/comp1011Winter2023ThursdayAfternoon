module ca.georgiancollege.comp1011winter2023thursdayafternoon {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1011winter2023thursdayafternoon to javafx.fxml;
    exports ca.georgiancollege.comp1011winter2023thursdayafternoon;
}
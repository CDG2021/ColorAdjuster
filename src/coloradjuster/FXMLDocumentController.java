/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coloradjuster;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Carlos Garcia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView curImage;
    @FXML
    private Label fileName;
        
    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null)
        {
            try{
            String newPicture = selectedFile.getAbsolutePath();
            newPicture = ("file:" + newPicture);
            Image image = new Image(newPicture);
            curImage.setImage(image);
            
            String newFileName = selectedFile.getName();
            fileName.setText(newFileName);
            }
            catch(Exception e){
                //System.out.println("Not a valid file.");
            }
        }
    }
    
    public void displayImage(){
        Image image = new Image("coloradjuster/Koala.jpg");
        curImage.setImage(image);
    }
    
    @FXML
    private Slider hueSlider;
    
    @FXML
    private Slider satSlider;
    
    @FXML
    private Slider brightSlider;
    
    @FXML
    private Slider conSlider;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hueSlider.valueProperty().addListener(
                (observeable, oldvalue, newvalue) ->
        {
            double value = hueSlider.getValue();
            
            value = value/10;
            
            ColorAdjust colorAdjuster = new ColorAdjust();
            colorAdjuster.setHue(value);
            curImage.setEffect(colorAdjuster);
        });
        
        satSlider.valueProperty().addListener(
                (observeable, oldvalue, newvalue) ->
        {
            double value = satSlider.getValue();
            
            value = value/10;
            
            ColorAdjust colorAdjuster = new ColorAdjust();
            colorAdjuster.setSaturation(value);
            curImage.setEffect(colorAdjuster);
        });
        
        brightSlider.valueProperty().addListener(
                (observeable, oldvalue, newvalue) ->
        {
            double value = brightSlider.getValue();
            
            value = value/10;
            
            ColorAdjust colorAdjuster = new ColorAdjust();
            colorAdjuster.setBrightness(value);
            curImage.setEffect(colorAdjuster);
        });
        
        conSlider.valueProperty().addListener(
                (observeable, oldvalue, newvalue) ->
        {
            double value = conSlider.getValue();
            
            value = value/10;
            
            ColorAdjust colorAdjuster = new ColorAdjust();
            colorAdjuster.setContrast(value);
            curImage.setEffect(colorAdjuster);
        });
        displayImage();
    }
}

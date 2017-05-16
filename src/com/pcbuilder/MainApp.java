package com.pcbuilder;

import java.io.IOException;

import com.pcbuilder.controller.CPUCoolerOverviewController;
import com.pcbuilder.controller.MainViewController;
import com.pcbuilder.model.ModelCPU;
import com.pcbuilder.controller.CPUOverviewController;
import com.pcbuilder.controller.GPUOverviewController;
import com.pcbuilder.model.ModelGPU;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane mainView;

   // private ObservableList<ModelCPU> cpuData = FXCollections.observableArrayList();
  //  private ObservableList<ModelGPU> gpuData = FXCollections.observableArrayList();
    public MainApp(){
        // define cpu, gpu data
    }
    // public ObservableList<ModelCPU> getCpuData(){
    //    return cpuData;
    //}
    //public ObservableList<ModelGPU> setGpuData() {return gpuData; }

    public static String noZeros(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PC Builder");
        initMainView();
        //showCPUOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initMainView() {
        try {
            // Load main view from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
            mainView = (BorderPane) loader.load();

            // Show the scene containing the main view.
            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            MainViewController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the cpu overview inside the root layout.
     */
    public void showCPUOverview() {
        try {
            // Load cpu overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CPUView.fxml"));
            AnchorPane cpuOverview = (AnchorPane)loader.load();

            // Set cpu overview into the center of root layout.
            mainView.setCenter(cpuOverview);

            // Give the controller access to the main app.
            CPUOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCPUCoolerOverview() {
        try {
            // Load cpucooler overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CPUCoolerView.fxml"));
            AnchorPane cpuCoolerOverview = (AnchorPane)loader.load();

            // Set cpucooler overview into the center of root layout.
            mainView.setCenter(cpuCoolerOverview);

            // Give the controller access to the main app.
            CPUCoolerOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGPUOverview() {
        try {
            // Load gpu overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GPUView.fxml"));
            AnchorPane gpuOverview = (AnchorPane)loader.load();

            // Set gpu overview into the center of root layout.
            mainView.setCenter(gpuOverview);

            // Give the controller access to the main app.
            GPUOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
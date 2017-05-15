package com.pcbuilder.controller;
import javafx.fxml.FXML;

import com.pcbuilder.MainApp;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ace on 2017-05-14.
 */
public class MainViewController {

    // Reference to the main application
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
    }


    @FXML
    private void showCpu(){

        mainApp.showCPUOverview();
    }

    @FXML
    private void showGpu() {
        mainApp.showGPUOverview();
    }
}

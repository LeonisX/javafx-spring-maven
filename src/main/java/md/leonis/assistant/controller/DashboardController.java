package md.leonis.assistant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import md.leonis.assistant.config.ConfigHolder;
import md.leonis.assistant.service.TestService;
import md.leonis.assistant.view.FxmlView;
import md.leonis.assistant.view.StageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {

    @FXML
    public TextArea infoTextArea;

    private final StageManager stageManager;

    private final ConfigHolder configHolder;

    private final TestService testService;

    @Lazy
    public DashboardController(StageManager stageManager, ConfigHolder configHolder, TestService testService) {
        this.stageManager = stageManager;
        this.configHolder = configHolder;
        this.testService = testService;
    }

    @FXML
    private void initialize() {
        int count = testService.getDictionaries().size();
        infoTextArea.setText(String.format("Dictionaries in DB:\n%s\n\nWords to learn:\n%s", count, configHolder.getWordsToLearnCount()));
    }

    public void windowShow() {
        stageManager.showNewWindow(FxmlView.WINDOW);
    }

    public void showNotification() {
        stageManager.showInformationAlert("Title: selected all", "Header: selected all", "some content");
    }
}

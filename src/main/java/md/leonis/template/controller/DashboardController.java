package md.leonis.template.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import md.leonis.template.config.ConfigHolder;
import md.leonis.template.service.TestService;
import md.leonis.template.view.FxmlView;
import md.leonis.template.view.StageManager;
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

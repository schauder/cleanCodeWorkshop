package de.schauderhaft.cleanCode.exercise6;

import javax.swing.JLabel;

public class LabelGenerator {

    JLabel stageInfoLabel;

    TextStrategy textGenerator = new TextStrategy();
    VisabilityStrategy visabilityStrategy = new VisabilityStrategy();

    public JLabel getLblStageInfo() {
        if (stageInfoLabel == null) {
            stageInfoLabel = new JLabel();

            stageInfoLabel.setText(textGenerator.getText());
            stageInfoLabel.setVisible(visabilityStrategy.getVisibility());
        }

        return stageInfoLabel;
    }

}

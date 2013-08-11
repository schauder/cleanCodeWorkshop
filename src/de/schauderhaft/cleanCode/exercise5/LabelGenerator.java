package de.schauderhaft.cleanCode.exercise5;

import javax.swing.JLabel;

public class LabelGenerator {

    JLabel stageInfoLabel;

    TextStrategy textGenerator = new TextStrategy();
    VisabilityStrategy visabilityStrategy = new VisabilityStrategy();

    public JLabel getLblStageInfo() {
        if (stageInfoLabel == null) {
            stageInfoLabel = new JLabel();

            stageInfoLabel.setText(textGenerator.getText(this));
            stageInfoLabel.setVisible(visabilityStrategy.getVisibility(this));
        }

        return stageInfoLabel;
    }

}

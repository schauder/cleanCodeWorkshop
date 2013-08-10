package de.schauderhaft.cleanCode.exercise2;

import javax.swing.JLabel;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;
import de.schauderhaft.cleanCode.stubs.Translator;

public class LabelGenerator {

    JLabel stageInfoLabel;

    public JLabel getLblStageInfo() {
        if (stageInfoLabel == null) {
            stageInfoLabel = new JLabel();

            String text = getI18nText("lblStageInfoPrd");

            try {
                String importUrl = SrvParameterCache
                        .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
                if (!StringStatic.isEmptyOrNullValue(importUrl)) {
                    importUrl = importUrl.toLowerCase();

                    if (isTestInstance(importUrl)) {
                        text = getI18nText("lblStageInfoTest");
                    } else if (isQaInstance(importUrl)) {
                        text = getI18nText("lblStageInfoQs");
                    }
                    // PRD-Instanz (oder neue, bzw. noch nicht bekannte
                    // Instanz)
                    else {
                        stageInfoLabel.setVisible(false);
                    }
                }
            } catch (Exception e) {
                stageInfoLabel.setVisible(false);
                e.printStackTrace();
            }

            stageInfoLabel.setText(text);
        }

        return stageInfoLabel;
    }

    private boolean isQaInstance(String url) {
        return url.contains("grglmrpfqs") || url.contains("gru23c12")
                || url.contains("sysglmqs") || url.contains("sysgmrpf-qs");
    }

    private boolean isTestInstance(String url) {
        return url.contains("grglmrpft") || url.contains("sysmrpt")
                || url.contains("gru23b12") || url.contains("gru23b13");
    }

    private String getI18nText(String string) {

        return Translator.translate(string);
    }
}

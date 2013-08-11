package de.schauderhaft.cleanCode.exercise4;

import javax.swing.JLabel;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;
import de.schauderhaft.cleanCode.stubs.Translator;

public class LabelGenerator {

    JLabel stageInfoLabel;

    public JLabel getLblStageInfo() {
        if (stageInfoLabel == null) {
            stageInfoLabel = new JLabel();

            stageInfoLabel.setText(getLabelText());
            stageInfoLabel.setVisible(getVisibility());
        }

        return stageInfoLabel;
    }

    private String getLabelText() {

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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    private boolean getVisibility() {
        boolean visibility = true;
        try {
            String importUrl = SrvParameterCache
                    .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
            if (!StringStatic.isEmptyOrNullValue(importUrl)) {
                importUrl = importUrl.toLowerCase();
                if (isProductionInstance(importUrl)) {
                    visibility = false;
                }
            }
        } catch (Exception e) {
            visibility = false;
        }
        return visibility;
    }

    private boolean isProductionInstance(String url) {
        return !(isTestInstance(url) || isQaInstance(url));
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

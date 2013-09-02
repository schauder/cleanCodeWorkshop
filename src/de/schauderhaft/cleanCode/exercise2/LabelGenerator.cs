using System;
using System.Windows.Forms;
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise2
{
    public class LabelGenerator 
    {
        private Label stageInfoLabel;
        
        public Label GetLblStageInfo() 
        {
            if (stageInfoLabel == null)
            {
                stageInfoLabel = new Label();
                
                string text = GetI18nText("lblStageInfoPrd");
                try
                {
                    string importUrl = SrvParameterCache
                        .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
                    if (!StringStatic.IsEmptyOrNullValue(importUrl))
                    {
                        importUrl = importUrl.ToLower();
                        
                        if (IsTestInstance(importUrl)) 
                        {
                            text = GetI18nText("lblStageInfoTest");
                        }
                        else if (IsQaInstance(importUrl)) 
                        {
                            text = GetI18nText("lblStageInfoQs");
                        }
                        // PRD-Instanz (oder neue, bzw. noch nicht bekannte
                        // Instanz)
                        else 
                        {
                            stageInfoLabel.Visible = false;
                        }
                    }
                }
                catch (Exception e)
                {
                    stageInfoLabel.Visible = false;
                    Console.WriteLine(e.Message);
                    Console.WriteLine(e.StackTrace);
                }
                
                stageInfoLabel.Text = text;
            }
            return stageInfoLabel;
        }
        
        private bool IsQaInstance(string url)
        {
            return url.Contains("grglmrpft")
                    || url.Contains("sysmrpt")
                    || url.Contains("gru23b12")
                    || url.Contains("gru23b13");
        }
        
        private bool IsTestInstance(string url)
        {
            return url.Contains("grglmrpfqs")
                    || url.Contains("gru23c12")
                    || url.Contains("sysglmqs")
                    || url.Contains("sysgmrpf-qs");
        }
        
        private string GetI18nText(string message)
        {
            return Translator.Translate(message);
        }
    }
}
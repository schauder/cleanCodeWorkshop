using System;
using System.Windows.Forms;
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise3
{
    public class LabelGenerator 
    {
        private Label stageInfoLabel;
        
        public Label GetLblStageInfo() 
        {
            if (stageInfoLabel == null)
            {
                stageInfoLabel = new Label();
                
                SetLabelText();
                SetLabelVisiblity();
            }
            return stageInfoLabel;
        }
        
        private void SetLabelText()
        {
            stageInfoLabel.Text = GetLabelText();
        }
        
        private string GetLabelText()
        {
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
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.StackTrace);
            }
            return text;
        }
        
        private void SetLabelVisiblity()
        {
            stageInfoLabel.Visible = GetVisibility();
        }
        
        private bool GetVisibility()
        {
            bool visibility = true;
            try
            {
                string importUrl = SrvParameterCache
                        .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
                if (!StringStatic.IsEmptyOrNullValue(importUrl))
                {
                    importUrl = importUrl.ToLower();
                    if (IsProductionInstance(importUrl)) 
                    {
                        visibility = false;
                    }
                }
            }
            catch 
            {
                visibility = false;
            }
            return visibility;
        }
        
        private bool IsProductionInstance(string url)
        {
            return !(IsTestInstance(url) || IsQaInstance(url));
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
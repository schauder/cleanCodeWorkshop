using System.Windows.Forms;

namespace de.schauderhaft.cleanCode.exercise6
{
    public class LabelGenerator
    {
        private Label stageInfoLabel;
        private TextStrategy textGenerator = new TextStrategy();
        private VisibilityStrategy visibilityStrategy = new VisibilityStrategy();
        
        public Label GetLblStageInfo()
        {
            if (stageInfoLabel == null)
            {
                stageInfoLabel = new Label();
                
                stageInfoLabel.Text = textGenerator.GetText();
                stageInfoLabel.Visible = visibilityStrategy.GetVisibility();
            }
            
            return stageInfoLabel;
        }
    }
}
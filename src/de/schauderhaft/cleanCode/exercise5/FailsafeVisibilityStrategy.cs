namespace de.schauderhaft.cleanCode.exercise5
{
    public class FailsafeVisabilityStrategy
    {
        VisibilityStrategy strategy = new VisibilityStrategy();
        
        bool GetVisibility(LabelGenerator labelGenerator)
        {
            try
            {
                return strategy.GetVisibility();
            }
            catch
            {
                return false;
            }
        }
    }
}
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise6
{
    public class VisibilityStrategy
    {
        private InstanceClassifier classifier = new InstanceClassifier();
        
        public bool GetVisibility()
        {
            return !classifier.IsProductionInstance();
        }
    }
}
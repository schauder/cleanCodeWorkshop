using System;
using System.Linq;
using System.Collections.Generic;
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise6
{
    public class InstanceClassifier
    {
        private readonly IEnumerable<string> testInstances = new List<string> 
        {"grglmrpft", "sysmrpt", "gru23b12", "gru23b13"};
        
        private readonly IEnumerable<string> qaInstances = new List<string>
        { "grglmrpfqs", "gru23c12", "sysglmqs", "sysgmrpf-qs"};
        
        public bool IsTestInstance()
        {
            return testInstances.Contains(SanatizedServerUrl());
        }
        
        public bool IsQaInstance()
        {
            return qaInstances.Contains(SanatizedServerUrl());
        }
        
        public bool IsProductionInstance()
        {
            return !(IsTestInstance() || IsQaInstance());
        }
        
        private string SanatizedServerUrl() 
        {
            string url = SrvParameterCache
                .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
            if (url == null)
                url = string.Empty;

            return url.ToLower();
        }
    }
}
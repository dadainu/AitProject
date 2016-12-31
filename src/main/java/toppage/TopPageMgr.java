
package toppage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/** トップページマネージャークラス */
@Named
@RequestScoped
public class TopPageMgr {
    
    public String nextMain() {
        return "/TopPage.xhtml";
    }
    
}

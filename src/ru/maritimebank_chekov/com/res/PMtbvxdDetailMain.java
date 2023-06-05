package ru.maritimebank_chekov.com.res;

import java.util.Collections;
import java.util.Map;
import ru.inversion.fx.form.ViewContext;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.tc.TaskContext;
import ru.maritimebank_chekov.com.ViewMtbvxdDetailController;

/**
 *
 * @author  chekov
 * @since   Tue Nov 01 10:40:20 MSK 2022
 */
public class PMtbvxdDetailMain extends BaseApp 
{
    
    @Override
    protected void showMainWindow () 
    {
        showViewMtbvxdDetail (getPrimaryViewContext (), new TaskContext (), Collections.emptyMap ());
    }

    @Override
    public String getAppID () 
    {
        return "XXI.PMTBVXDDETAIL"; 
    }
    
    public static void main (String[] args) 
    {
        launch (args);
    }

    public static void showViewMtbvxdDetail (ViewContext vc, TaskContext tc, Map<String, Object> p) 
    {
        new FXFormLauncher<> (tc, vc, ViewMtbvxdDetailController.class)
            .initProperties (p)
            .show ();
    }
    
}


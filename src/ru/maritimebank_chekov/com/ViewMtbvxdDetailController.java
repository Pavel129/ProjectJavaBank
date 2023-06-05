package ru.maritimebank_chekov.com;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import ru.inversion.bicomp.pref.PreferencesWorker;
import ru.inversion.bicomp.stringconverter.DataSetStringConverter;
import ru.inversion.bicomp.stringconverter.ListStringConverter;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.dataset.DataSetException;
import ru.inversion.dataset.IDataSet;
import ru.inversion.dataset.SQLDataSet;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;

import ru.inversion.db.expr.SQLExpressionException;
import ru.inversion.fx.form.*;
import ru.inversion.fx.form.controls.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author  chekov
 * @since   Tue Nov 01 10:40:14 MSK 2022
 */
public class ViewMtbvxdDetailController extends JInvFXBrowserController
{

    @FXML private JInvTable<PMtbvxdDetail> MTBVXD_DETAIL;
    @FXML private JInvToolBar toolBar;
    @FXML private JInvComboBox<String, String> FILTER_TYPE;
    @FXML private JInvComboBox<String, String> FILTER_STATUS;

    private static final String DEFAULT_FILTER = "ALL";

    private final POptions pv = new POptions ();

    private final XXIDataSet<PMtbvxdDetail> dsMTBVXD_DETAIL = new XXIDataSet<> ();
    //
//
//
    private void initDataSet () throws Exception
    {
        dsMTBVXD_DETAIL.setTaskContext (getTaskContext ());
        dsMTBVXD_DETAIL.setRowClass (PMtbvxdDetail.class);
    }
    //
// Initializes the controller class.
//
    @Override
    protected void init() throws Exception
    {
        setTitle (getBundleString ("VIEW.TITLE"));

        PreferencesWorker.load (getTaskContext (), pv);
        if (!pv.isAction (POptions.Actions.VIEW_MTB.id())) throw new SecurityException (pv.getActionError (getTaskContext (), POptions.Actions.VIEW_MTB.id())); // Запрет на просмотр окна
        initDataSet ();
        DSFXAdapter<PMtbvxdDetail> dsfx = DSFXAdapter.bind (dsMTBVXD_DETAIL, MTBVXD_DETAIL, null, false);

        dsfx.setEnableFilter();
        dsfx.setEnableFilter (true);
        initToolBar ();

        MTBVXD_DETAIL.setToolBar (toolBar);
        MTBVXD_DETAIL.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh ());

        final SQLDataSet<PMFilterType> dsfxFilterType =  populateDataSet(PMFilterType.class, null, null, null, new ParamMap().add("CROOT", "CROOT"), 2);
        final DataSetStringConverter<PMFilterType,String> scFilterType = new DataSetStringConverter<>(dsfxFilterType,
                PMFilterType::getCROOT, PMFilterType::getCROOT);
        final Set<String> elementsType = scFilterType.keySet();
        FILTER_TYPE.setConverter(scFilterType);
        FILTER_TYPE.getItems().clear();
        FILTER_TYPE.getItems().addAll(elementsType);
        FILTER_TYPE.valueProperty().addListener(new FilterTypeListener());

        final SQLDataSet<PMFilterStatus> dsfxFilterStatus = populateDataSet(PMFilterStatus.class, null, null, null, new ParamMap().add("STATE", "STATE"), 2);
        final DataSetStringConverter<PMFilterStatus,String> scFilterStatus = new DataSetStringConverter<>(dsfxFilterStatus,
                PMFilterStatus::getSTATE, PMFilterStatus::getSTATE);
        final Set<String> elementsStatus = scFilterStatus.keySet();
        FILTER_STATUS.setConverter(scFilterStatus);
        FILTER_STATUS.getItems().clear();
        FILTER_STATUS.getItems().addAll(elementsStatus);
        FILTER_STATUS.valueProperty().addListener(new FilterStatusListener());

        doRefresh ();
    }

    class FilterTypeListener implements ChangeListener<String> {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            final String wherePredicat = FILTER_STATUS.getValue();
            System.out.println("Status: " + wherePredicat);
            if(wherePredicat != null && !wherePredicat.equalsIgnoreCase(DEFAULT_FILTER)){
                dsMTBVXD_DETAIL.setWherePredicat(newValue.equalsIgnoreCase(DEFAULT_FILTER) ?
                        String.format("CROOT=CROOT AND STATE='%s'", wherePredicat)
                        :
                        String.format("CROOT='%s' AND STATE='%s'", newValue,wherePredicat));
            }
            else {
                dsMTBVXD_DETAIL.setWherePredicat(newValue.equalsIgnoreCase(DEFAULT_FILTER) ?
                        "CROOT=CROOT"
                        :
                        String.format("CROOT='%s'", newValue));
            }
            MTBVXD_DETAIL.executeQuery();
            MTBVXD_DETAIL.requestFocus();
        }
    }

    class FilterStatusListener implements ChangeListener<String> {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            final String wherePredicat = FILTER_TYPE.getValue();
            System.out.println("Type: " + wherePredicat);
            if(wherePredicat != null && !wherePredicat.equalsIgnoreCase(DEFAULT_FILTER)){
                dsMTBVXD_DETAIL.setWherePredicat(newValue.equalsIgnoreCase(DEFAULT_FILTER) ?
                        String.format("STATE=STATE AND CROOT='%s'", wherePredicat)
                        :
                        String.format("STATE='%s' AND CROOT='%s'", newValue,wherePredicat));
            }
            else {
                dsMTBVXD_DETAIL.setWherePredicat(newValue.equalsIgnoreCase(DEFAULT_FILTER) ?
                        "STATE=STATE"
                        :
                        String.format("STATE='%s'", newValue));
            }
            MTBVXD_DETAIL.executeQuery();
            MTBVXD_DETAIL.requestFocus ();
        }
    }
    //
//
//
    private void doRefresh ()
    {
        MTBVXD_DETAIL.executeQuery ();
    }
    //
//
//
    private void initToolBar ()
    {
        toolBar.setStandartActions (ActionFactory.ActionTypeEnum.REFRESH);

//        toolBar.getItems ().add (ActionFactory.createButton(ActionFactory.ActionTypeEnum.SETTINGS, (a) -> JInvMainFrame.showSettingsPane ()));
    }


    @FXML
    public void reProcessing() {
        if (!pv.isAction (POptions.Actions.REPROCESSING.id())) {
            try {
                throw new SecurityException(pv.getActionError(getTaskContext(), POptions.Actions.VIEW_MTB.id()));
            }catch (SecurityException ex){
                handleException (ex);
            }
            return;
        }
        if(dsMTBVXD_DETAIL.getCurrentRow() == null){
            Alerts.error(this, "Вы не выбрали документ для повторной обработки");
            return;
        }
        try {
            ParamMap p = new ParamMap().add("pID", dsMTBVXD_DETAIL.getCurrentRow().getDOCUMENTID()).exec(this, "UpdateIfiqstatus");
            final long countUpdateRow = p.getLong("result");
            final String error = p.getString("err");
            if (countUpdateRow > 0L) {
                getTaskContext().commit(); //Зафиксировать изменения
                Alerts.info(this, String.format("Кол-во изменённых строк: %d", countUpdateRow));
            } else {
                //getTaskContext().rollback(); // Вернуть назад
                Alerts.error(this, String.format("Код ошибки: %d\n%s", countUpdateRow, error));
            }
        } catch (SQLExpressionException ex) {
            handleException (ex);
        }
    }

}


package projects.santiago.physicalstuff.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.santiago.physicalstuff.App;
import projects.santiago.physicalstuff.R;
import projects.santiago.physicalstuff.contract.IMainPresenter;
import projects.santiago.physicalstuff.contract.IMainView;
import projects.santiago.physicalstuff.di.module.MainModule;
import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Capacitancia;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;
import projects.santiago.physicalstuff.model.entity.unit.UArea;
import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;
import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

public class MainActivity extends AppCompatActivity implements IMainView {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.edt_area) AppCompatEditText edt_area;
    @BindView(R.id.edt_distancia) AppCompatEditText edt_distancia;
    @BindView(R.id.btn_unidad_area) AppCompatButton btn_unidad_area;
    @BindView(R.id.btn_unidad_distancia) AppCompatButton btn_unidad_distancia;
    @BindView(R.id.btn_dielectico) AppCompatButton btn_dielectico;
    @BindView(R.id.btn_unidad_capacitancia) AppCompatButton btn_unidad_capacitancia;
    @BindView(R.id.txt_resultado) AppCompatTextView txt_resultado;

    @Inject
    IMainPresenter presenter;

    private MaterialDialog dialogChooseAreaUnit;
    private MaterialDialog dialogChooseLengthUnit;
    private MaterialDialog dialogChooseDielectico;
    private MaterialDialog dialogChooseCapacitanciaUnit;

    public static void startActivityFrom(Context context, Bundle extras) {
        Intent intent = new Intent(context, MainActivity.class);
        if (extras != null) intent.putExtras(extras);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.get(this)
                .getComponent()
                .create(new MainModule(this))
                .inject(this);
        presenter.loadAllLengthUnitAsPretty();
        presenter.loadAllAreaUnitAsPretty();
        presenter.loadAllDielecticosAsPretty();
        presenter.loadAllCapacitaciaUnitAsPretty();
    }

    @OnClick(R.id.btn_unidad_area)
    void onClickUnidadArea() {
        if (dialogChooseAreaUnit != null) {
            dialogChooseAreaUnit.show();
        }
    }

    @OnClick(R.id.btn_unidad_distancia)
    void onClickUnidadDistancia() {
        if (dialogChooseLengthUnit != null) {
            dialogChooseLengthUnit.show();
        }
    }

    @OnClick(R.id.btn_dielectico)
    void onClickDielectico() {
        if (dialogChooseDielectico != null) {
            dialogChooseDielectico.show();
        }
    }

    @OnClick(R.id.btn_unidad_capacitancia)
    void onClickUnidadCapacitancia() {
        if (dialogChooseCapacitanciaUnit != null) {
            dialogChooseCapacitanciaUnit.show();
        }
    }

    @OnClick(R.id.btn_solucionar)
    void onClickSolucionar() {
        if (testFields()) {
            UArea uArea = ((UArea) btn_unidad_area.getTag());
            ULongitud uDistancia = ((ULongitud) btn_unidad_distancia.getTag());
            UCapacitancia uCapacitancia = ((UCapacitancia) btn_unidad_capacitancia.getTag());
            Dielectrico dielectrico = ((Dielectrico) btn_dielectico.getTag());

            Area area = new Area(Double.parseDouble(edt_area.getText().toString()), uArea);
            Longitud longitud = new Longitud(Double.parseDouble(edt_distancia.getText().toString()), uDistancia);

            presenter.calcularCapacitancia(area, longitud, dielectrico, uCapacitancia);
        }
    }

    @Override
    public void setAllAreaUnitAsPretty(final List<String> unitAsPretty) {
        dialogChooseAreaUnit = new MaterialDialog.Builder(this)
                .title(R.string.main_dialog_choose_area_unit_title)
                .items(unitAsPretty)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        int index = unitAsPretty.indexOf(text);
                        UArea unit = UArea.values()[index];
                        btn_unidad_area.setText(unit.getSimbolo());
                        btn_unidad_area.setTag(unit);
                        btn_unidad_area.setError(null);
                        resetResultado();
                    }
                })
                .build();
    }

    @Override
    public void setAllLengthUnitAsPretty(final List<String> unitAsPretty) {
        dialogChooseLengthUnit = new MaterialDialog.Builder(this)
                .title(R.string.main_dialog_choose_distancia_unit_title)
                .items(unitAsPretty)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        int index = unitAsPretty.indexOf(text);
                        ULongitud unit = ULongitud.values()[index];
                        btn_unidad_distancia.setText(unit.getSimbolo());
                        btn_unidad_distancia.setTag(unit);
                        btn_unidad_distancia.setError(null);
                        resetResultado();
                    }
                })
                .build();
    }

    @Override
    public void setAllDielecticosAsPretty(final List<String> dielecticosAsPretty) {
        dialogChooseDielectico = new MaterialDialog.Builder(this)
                .title(R.string.main_dialog_choose_dielectrico_title)
                .items(dielecticosAsPretty)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        int index = dielecticosAsPretty.indexOf(text);
                        Dielectrico dielectrico = Dielectrico.values()[index];
                        btn_dielectico.setText(text);
                        btn_dielectico.setTag(dielectrico);
                        btn_dielectico.setError(null);
                        resetResultado();
                    }
                })
                .build();
    }

    @Override
    public void setAllCapacitanciaUnitAsPretty(final List<String> unitAsPretty) {
        dialogChooseCapacitanciaUnit = new MaterialDialog.Builder(this)
                .title(R.string.main_dialog_choose_capacitancia_title)
                .items(unitAsPretty)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        int index = unitAsPretty.indexOf(text);
                        UCapacitancia unit = UCapacitancia.values()[index];
                        btn_unidad_capacitancia.setText(unit.getSimbolo());
                        btn_unidad_capacitancia.setTag(unit);
                        btn_unidad_capacitancia.setError(null);
                        resetResultado();
                    }
                })
                .build();
        // DEFAULT UNIT
        btn_unidad_capacitancia.setTag(UCapacitancia.FARADIO);
    }

    @Override
    public void setResultado(Capacitancia capacitancia) {
        StringBuilder builder = new StringBuilder();
        builder.append(capacitancia.getValor().toText()).append("\n");
        builder.append(capacitancia.getValor().getEstimatedValue());
        txt_resultado.setText(builder.toString());
    }

    @Override
    public void resetResultado() {
        txt_resultado.setText(R.string.main_resultado);
    }

    private boolean testFields() {
        if (edt_area.getText().toString().trim().isEmpty()) {
            edt_area.setError(getString(R.string.all_required_field));
            return false;
        }

        if (btn_unidad_area.getTag() == null) {
            btn_unidad_area.setError(getString(R.string.all_required_field));
            return false;
        }

        if (edt_distancia.getText().toString().trim().isEmpty()) {
            edt_distancia.setError(getString(R.string.all_required_field));
            return false;
        }

        if (btn_unidad_distancia.getTag() == null) {
            btn_unidad_distancia.setError(getString(R.string.all_required_field));
            return false;
        }

        if (btn_dielectico.getTag() == null) {
            btn_dielectico.setError(getString(R.string.all_required_field));
            return false;
        }
        return true;
    }

    @Override
    public void showMessage(@StringRes  int idMsg) {
        Toast.makeText(this, idMsg, Toast.LENGTH_SHORT).show();
    }
}

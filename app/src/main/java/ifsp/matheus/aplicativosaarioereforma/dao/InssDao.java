package ifsp.matheus.aplicativosaarioereforma.dao;

import java.util.Arrays;
import java.util.List;

import ifsp.matheus.aplicativosaarioereforma.model.Inss;

public class InssDao {


    public List<Inss> inssList() {

        //Sera utilizada pelo setor privado e publico
        return Arrays.asList(
                new Inss(0.1, 1751.81, 0.08),
                new Inss(1751.82, 2919.72, 0.09),
                new Inss(2919.73, 5839.45, 0.11),
                new Inss(5839.45, Double.MAX_VALUE, 0.11)
        );
    }

    public List<Inss> inssList2() {

        //Sera utilizada pelo setor privado e publico
        return Arrays.asList(
                new Inss(0.1, Double.MAX_VALUE, 0.11)
        );


    }
}




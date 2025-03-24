package utilidades;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDriven {

    public List<String> obtenerDatosPrueba(String tituloCP) throws IOException {
        ArrayList<String> datos = new ArrayList<String>();

        PropertiesDriven properties = new PropertiesDriven();

        FileInputStream file;


        //Crear un objeto de tipo file o archivo

        file = new FileInputStream(properties.obtenerUnaProperties("rutaExcel"));


        //crear un objeto de tipo excell

        XSSFWorkbook excel;
        excel = new XSSFWorkbook(file);

        int cantidadHojasExcel = excel.getNumberOfSheets();
        System.out.println("Cantidad de hojas " + cantidadHojasExcel);

        for (int i = 0; i < cantidadHojasExcel; i++) {
            if (excel.getSheetName(i).equalsIgnoreCase(properties.obtenerUnaProperties("nombreHojaExcel"))) {//"DatosCP" es el nombre de la hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);
                Iterator<Row> filas = hojaExcel.iterator();
                Row primeraFila = filas.next();

                Iterator<Cell> celda = primeraFila.cellIterator();

                int k = 0;
                int columna = 0;

                while (celda.hasNext()) {
                    Cell celdaSeleccionada = celda.next();

                    if (celdaSeleccionada.getStringCellValue().equalsIgnoreCase(properties.obtenerUnaProperties("tituloCPs"))) {//"CasosDePrueba" es el nobre de la columna
                        columna = k;
                    }
                    k++;

                }
                System.out.println("Columna " + columna);
                while (filas.hasNext()) {
                    Row r = filas.next();

                    if (r.getCell(columna).getStringCellValue().equalsIgnoreCase(tituloCP)) {
                        //encontrar el titulo del caso de prueba
                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                //System.out.println(c.getStringCellValue());
                                datos.add(c.getStringCellValue());
                            } else if (c.getCellType() == CellType.NUMERIC) {
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }

                        }
                    }
                }

            }
        }
        return datos;
    }
}

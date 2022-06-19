import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipWrapper {
    private static ClassLoader classLoader = FileParseTests.class.getClassLoader();


    public List<String[]> getListFromCSVinZIP() {
        List<String[]> linesFromCSV = null;


        try (InputStream is = classLoader.getResourceAsStream("Desktop.zip");
             ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis, StandardCharsets.UTF_8));

                    linesFromCSV = csvReader.readAll();
                }
            }
        } catch (IOException e) {
            System.out.println("Во время работы с архивом возникла ошибка");
            System.out.println(e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return linesFromCSV;
    }

    public PDF getPDFFromZip() {
        PDF pdfFile = null;

        try (InputStream is = classLoader.getResourceAsStream("Desktop.zip");
             ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    pdfFile = new PDF(zis);
                }
            }
        } catch (IOException e) {
            System.out.println("Во время работы с архивом возникла ошибка");
            System.out.println(e.getMessage());
        }

        return pdfFile;
    }

    public XLS getXLSXFromZip() {
        XLS xlsFile = null;

        try (InputStream is = classLoader.getResourceAsStream("Desktop.zip");
             ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".xlsx")) {
                    xlsFile = new XLS(zis);
                }
            }
        } catch (IOException e) {
            System.out.println("Во время работы с архивом возникла ошибка");
            System.out.println(e.getMessage());
        }

        return xlsFile;
    }
}

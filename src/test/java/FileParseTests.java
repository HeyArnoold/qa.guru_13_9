
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileParseTests {
    private ZipWrapper zipWrapper = new ZipWrapper();

    @Test
    void CSVTest() {
        List<String[]> listFromCSV = zipWrapper.getListFromCSVinZIP();

        Assertions.assertThat(listFromCSV).contains(new String[]{"1997", "Ford", "E350", "ac, abs, moon", "3000.00"});
    }

    @Test
    void PDFTest() {
        PDF pdf = zipWrapper.getPDFFromZip();

        Assertions.assertThat(pdf.text).contains("REMEMBER THESE SHORTCUTS");
    }

    @Test
    void XLSXTest() {
        XLS xls = zipWrapper.getXLSXFromZip();

        Assertions.assertThat(xls.excel
                .getSheetAt(0).getRow(3).getCell(1).getStringCellValue())
                .contains("Ошибка");
    }
}

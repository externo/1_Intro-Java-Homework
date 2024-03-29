import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class Test{
       
        public static String RESULT = "F:/Card.pdf";
       
        public static Font NORMAL = new Font(FontFamily.SYMBOL, 12);
       
        public static void main(String[] args) throws DocumentException, IOException {
            createPdf(RESULT);
        }
       
        public static void createPdf(String filename) throws DocumentException, IOException {
 
                String result = "";
                char color = ' ';
 
                char clubs = '\u2663';
                char diamonds = '\u2666';
                char hearts = '\u2665';
                char spades = '\u2660';
 
                String jack = "J";
                String queen = "Q";
                String knight = "K";
                String ace = "A";
       
                try{
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(filename));
                        document.open();
               
                        PdfPTable table = new PdfPTable(4);
                        table.setWidthPercentage(35);
                        table.getDefaultCell().setFixedHeight(45);
                       
                        BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, true);
                        Font black = new Font(baseFont, 20f, 0, BaseColor.BLACK);
                        Font red = new Font(baseFont, 20f, 0, BaseColor.RED);
           
                        for (int i = 2; i <= 14; i++){            
                                for (int j = 1; j <= 4; j++){
                                        switch (i){
                                                case 10: result = "10"; break;
                                                case 11: result = " " + jack; break;
                                                case 12: result = " " + queen; break;                          
                                                case 13: result = " " + knight; break;
                                                case 14: result = " " + ace; break;
                                                default: result = " " + i; break;
                                        }
                                        switch(j){
                                                case 1:{
                                                        color = clubs;
                                                        table.addCell(new Paragraph(result + color + " ", black));
                                                        break;
                                                }
                                                case 2:{
                                                        color = diamonds;
                                                        table.addCell(new Paragraph(result + color + " ", red));
                                                        break;
                                                }
                                                case 3:{
                                                        color = hearts;
                                                        table.addCell(new Paragraph(result + color + " ", red));
                                                        break;
                                                }
                                                case 4:{
                                                        color = spades;
                                                        table.addCell(new Paragraph(result + color + " ", black));
                                                        break;
                                                }
                                        }
                                }
                        }
                        document.add(table);
                        document.close();
                }
                catch (Exception e){
                        e.printStackTrace();
                }
        }
}
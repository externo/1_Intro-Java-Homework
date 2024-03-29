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
 
public class _09_GeneratePDFbyExternalLibrary{       
        public static String RESULT = "F:/Cards.pdf";       
        public static Font NORMAL = new Font(FontFamily.SYMBOL, 12);       
        public static void main(String[] args) throws DocumentException, IOException {
            createPdf(RESULT);
        }       
        public static void createPdf(String filename) throws DocumentException, IOException {       
                try{
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(filename));
                        document.open();                                                             
                        BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, true);
                        Font black = new Font(baseFont, 20f, 0, BaseColor.BLACK);
                        Font red = new Font(baseFont, 20f, 0, BaseColor.RED);
                        Paragraph p = new Paragraph(" ");           
                        String[] suits = {"\u2663", "\u2666", "\u2665", "\u2660"};
                        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "D", "K", "A"};
                        for (int i = 0; i<52; i++){
                    		Font color;
                        	int suit = i/13;
                        	int rank = i%13;
                        	if (suit==0 || suit ==3)  {color = black;}
                        	else  {color = red;}
                            PdfPTable table = new PdfPTable(1);
                            table.setWidthPercentage(10);
                            table.getDefaultCell().setFixedHeight(70);
                            table.addCell(new Paragraph(suits[suit] +" "+ ranks[rank] + " ", color));
                            document.add(table);
                            document.add(p);                            
                        }                        
                        document.close();
                }
                catch (Exception e){
                        e.printStackTrace();
                }
        }
}
package MOYU;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTextExtractor {
     public static void main(String[] args) {
        String inputFilePath = "D:\\software\\itheima\\MOYU\\TestFile\\FiveOne.pdf";
        String outputFilePath = "D:\\software\\itheima\\MOYU\\TestFile\\FiveOne.txt";

        try {
            // 加载 PDF 文档
             File inputFile = new File(inputFilePath);
            PDDocument document = PDDocument.load(inputFile);

            // 创建 PDFTextStripper 对象
            PDFTextStripper stripper = new PDFTextStripper();

            // 提取文本内容
            String text = stripper.getText(document);

            // 创建 Reader 对象，并使用指定的字符编码
            Reader reader = new StringReader(text);
            char[] buffer = new char[4096];
            StringBuilder stringBuilder = new StringBuilder();
            int numCharsRead;
            while ((numCharsRead = reader.read(buffer, 0, buffer.length)) != -1) {
                stringBuilder.append(buffer, 0, numCharsRead);
            }
            String decodedText = new String(stringBuilder.toString().getBytes(), StandardCharsets.UTF_8);
            
            // 将解码后的文本内容写入到输出文件
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(decodedText);
            writer.close();
            // 将文本内容写入到输出文件
            // FileWriter writer = new FileWriter(outputFilePath);
            // writer.write(text);
            // writer.close();

            // 关闭 PDF 文档
            document.close();

            System.out.println("内容已提取到文件: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

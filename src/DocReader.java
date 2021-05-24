import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Допустим есть файл с номерами документов.
 *
 * Номером документа является строка, состоящая из букв и цифр(без служебных символов).
 *
 * Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
 *
 * Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum(далее любая последовательность букв/цифр) или kontract(далее любая последовательность букв/цифр).
 *
 * Написать программу для чтения информации из входного файла - путь к входному файлу должне задаваться через консоль.
 *
 * Программа должна проверять номера документов на валидность.
 *
 * Валидные номера документов следует записать в один файл-отчет.
 *
 * Невалидные номера документов следует записать в другой файл-отчет, но после номеров документов следует добавить ифнформацию о том, почему этот документ невалиден.
 *
 * Результат:
 Укажите путь к файлу:
 E:\Git\HomeWork_11_TMS\files\docNumbers.txt
 Номер договора - docnum123456789
 docnum98321 - Некорректный номер договора
 */
public class DocReader {

    static Scanner input;
    static String p = "docnum";

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Укажите путь к файлу:");
        String fileWay = input.nextLine();
        Pattern pattern = Pattern.compile(p);

        try (
                BufferedReader in = new BufferedReader(new FileReader(fileWay));
                BufferedWriter outValid = new BufferedWriter(new FileWriter("E:\\Git\\HomeWork_11_TMS\\files\\docValid.txt"));
        BufferedWriter outNotValid = new BufferedWriter(new FileWriter("E:\\Git\\HomeWork_11_TMS\\files\\docNotValid.txt"))) {


            String docNum;
            while ((docNum = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(docNum);
                    if (docNum.length() == 15 && matcher.find()) {
                        outValid.write("Номер договора - " + docNum);
                        System.out.println("Номер договора - " + docNum);
                        outValid.write("\n");
                    } else{
                        outNotValid.write(docNum + " - Некорректный номер договора");
                        System.out.println(docNum +  " - Некорректный номер договора");
                        outNotValid.write("\n");
                    }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
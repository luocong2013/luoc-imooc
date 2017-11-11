package com.imooc.io.ch04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch04
 * @description: TODO
 * @date 2017/11/11 15:52
 */
public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        /**************①**************/
        FileReader fr = new FileReader("G:/demo/aaa.txt");
        FileWriter fw = new FileWriter("G:/demo/bbb.txt");
        char[] buf = new char[4 * 1024];
        int c;
        while ((c = fr.read(buf, 0, buf.length)) != -1) {
            fw.write(buf, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();

        /**************②**************/
//		FileInputStream in = new FileInputStream("G:/demo/aaa.txt");
//		FileOutputStream out = new FileOutputStream("G:/demo/bbb.txt");
//		InputStreamReader isr = new InputStreamReader(in, "GBK");
//		OutputStreamWriter osw = new OutputStreamWriter(out, "GBK");
//		char[] buf = new char[8*1024];
//		int a;
//		while ((a = isr.read(buf, 0, buf.length)) != -1) {
//			osw.write(buf, 0, a);
//			osw.flush();
//		}
//		isr.close();
//		osw.close();

        /**************③**************/
        /*BufferedReader br = new BufferedReader(new FileReader("G:/demo/aaa.txt"));
//		BufferedWriter bw = new BufferedWriter(new FileWriter("G:/demo/bbb.txt"));
		PrintWriter pw = new PrintWriter("G:/demo/bbb.txt");
		String line;
		while ((line = br.readLine()) != null) {
//			bw.write(line);
//			//单独写出换行操作
//			bw.newLine();//换行操作
//			bw.flush();

			pw.println(line);
			pw.flush();
		}
		br.close();
//		bw.close();
		pw.close();*/
    }
}


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
/**
 * Created by cch on 2017/5/22.
 */
public class pdf {
    public static Properties properties= ReadProper.readproper("/properties.properties");
    static void baseStringToPDF(String base64sString,String path){
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            //将base64编码的字符串解码成字节数�?
            // byte[] bytes = decoder.decodeBuffer(base64sString);
            //apache公司的API
            byte[] bytes = Base64.decodeBase64(base64sString);
            //创建�?个将bytes作为其缓冲区的ByteArrayInputStream对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //创建从底层输入流中读取数据的缓冲输入流对�?
            bin = new BufferedInputStream(bais);
            //指定输出的文�?
            File file = new File(path);
            //创建到指定文件的输出�?
            fout  = new FileOutputStream(file);
            //为文件输出流对接缓冲输出流对�?
            bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while(len != -1){
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bin.close();
                fout.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       
    }
    public static void main(String args[]) throws IOException {
        String ss=properties.getProperty("ss");
        baseStringToPDF(ss,"D:\\101202.pdf");
    }
}
package servlet;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.io.textio;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/entityServlet")
public class entityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String uploadPath =  textio.getPath()+"\\images"; // 上传文件的目录
    File tempPathFile;

    // 重写doPost方法，处理事件识别请求
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
        factory.setRepository(tempPathFile);// 设置缓冲区目录

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
        List<FileItem> items = null;
        Iterator<FileItem> i = null;
        try {
            items = upload.parseRequest(request);// 得到所有的文件
            i = items.iterator();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        while(i.hasNext()) {
            FileItem fi = i.next();
            String fileName=fi.getName();
            if (fileName != null) {
                File fullFile = new File(new String(fileName.getBytes(), "utf-8")); // 解决文件名乱码问题
                File savedFile = new File(uploadPath, fullFile.getName());
                try {
                    fi.write(savedFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

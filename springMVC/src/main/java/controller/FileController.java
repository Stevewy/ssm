package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/27
 * @function 文件上传
 */
@Controller
@RequestMapping("/file")
public class FileController {

    //以前方法  (我学过吗???)
    //先拿路径(没有就创建),在得到DiskFileItemFactory对象,传给ServletFileUpload,再解析request
    @RequestMapping("/upLoad")
    public String fileUpLoad(HttpServletRequest request) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item : items){
            if(item.isFormField()){
                //是表单,不管
            } else {
                String name = item.getName();
                item.write(new File(path, name));
                item.delete();
            }
        }
        return "Hello";
    }

    @RequestMapping("upload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        String name = upload.getOriginalFilename();
        upload.transferTo(new File(path, name));
        return "Hello";
    }

    //跨服务器上传
    @RequestMapping("upload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        String path = "";//写你要上传服务器的地址,http开头
        String name = upload.getOriginalFilename();

        //创建客户机,去连接服务器,再上传
        Client client = Client.create();
        WebResource resource = client.resource(path + "/" + name);
        resource.put(upload.getBytes());

        return "Hello";
    }
}

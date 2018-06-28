package org.mushare.rate.controller.common;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.mushare.common.util.FileTool;
import org.mushare.rate.bean.UserBean;
import org.mushare.rate.component.ConfigComponent;
import org.mushare.rate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ControllerTemplate {

    // Limitation of uploaded file.
    private static final int FileMaxSize = 512 * 1024 * 1024;

    @Autowired
    protected ConfigComponent configComponent;

    @Autowired
    protected CurrencyManager currencyManager;

    @Autowired
    protected RateManager rateManager;

    @Autowired
    protected NewsManager newsManager;

    @Autowired
    protected UserManager userManager;

    @Autowired
    protected DeviceManager deviceManager;

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }

    public void setCurrencyManager(CurrencyManager currencyManager) {
        this.currencyManager = currencyManager;
    }

    public NewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(NewsManager newsManager) {
        this.newsManager = newsManager;
    }


    public ResponseEntity generateOK(Map<String, Object> result) {
        return generateResponseEntity(result, HttpStatus.OK, null, null);
    }

    public ResponseEntity generateBadRequest(int errorCode, String errorMessage) {
        return generateResponseEntity(null, HttpStatus.BAD_REQUEST, errorCode, errorMessage);
    }

    public ResponseEntity generateBadRequest(ErrorCode errorCode) {
        return generateBadRequest(errorCode.code, errorCode.message);
    }

    public ResponseEntity generateResponseEntity(Map<String, Object> result, HttpStatus status, Integer errCode, String errMsg) {
        Map<String, Object> data = new HashMap<String, Object>();
        if (result != null) {
            data.put("result", result);
        }
        data.put("status", status.value());
        if (errCode != null) {
            data.put("errorCode", errCode);
        }
        if (errMsg != null) {
            data.put("errorMessage", errMsg);
        }
        return new ResponseEntity(data, status);
    }

    /**
     * User auth by token in request header.
     *
     * @param request
     * @return
     */
    protected UserBean auth(HttpServletRequest request) {
        String token = request.getHeader("token");
        UserBean user = userManager.authByToken(token);
        return user;
    }

    /**
     * Create upload directory if it is not existed.
     *
     * @param directory
     * @return
     */
    public String createUploadDirectory(String directory) {
        String filepath = configComponent.rootPath + directory;
        // If directory is not existed, create the directory at first.
        FileTool.createDirectoryIfNotExsit(filepath);
        return filepath;
    }

    /**
     * Upload file to a file path.
     *
     * @param request
     * @param filepath
     * @return
     */
    protected String upload(HttpServletRequest request, String filepath) {
        String fileName = null;
        // Create factory object.
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Set cache size to 4KB.
        factory.setSizeThreshold(1024 * 4);
        // Set upload file path.
        factory.setRepository(new File(filepath));
        // Create servlet file upload object.
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Set limitation of uploaded file.
        upload.setSizeMax(FileMaxSize);
        try {
            // Get all uploading files information.
            List<FileItem> list = upload.parseRequest(request);
            Iterator<FileItem> it = list.iterator();
            while (it.hasNext()) {
                FileItem item = it.next();
                if (item.isFormField() == false) {
                    fileName = item.getName();
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
                    if (!fileName.equals("") && !(fileName == null)) {
                        // If file name is null, that means there is no uploading file.
                        File uploadedFile = new File(filepath, fileName);
                        try {
                            item.write(uploadedFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * Get device remote IP by HttpServletRequest.
     *
     * @param request
     * @return
     */
    protected static String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}

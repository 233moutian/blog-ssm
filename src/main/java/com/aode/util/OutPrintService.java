package com.aode.util;


import com.tools.utils.Result;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class OutPrintService {
    private static Logger logger = LogManager.getLogger(com.tools.utils.OutPrintService.class);

    public OutPrintService() {
    }

    public static void outPrintJSON(HttpServletRequest request, HttpServletResponse response, Result result) {
        PrintWriter out = null;

        try {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String ex = null;
            String callback = request.getParameter("callback");
            if(StringUtils.isBlank(callback)) {
                ex = JSONObject.fromObject(result).toString();
                out.print(ex);
            } else {
                out.print(callback + "(");
                out.print(JSONObject.fromObject(result));
                out.print(");");
            }
        } catch (IOException var9) {
            logger.error("=======json格式化类====" + var9.getMessage(), var9);
        } finally {
            if(out != null) {
                out.close();
            }

        }

    }

    public static void outPrintJSON(HttpServletRequest request, HttpServletResponse response, String resopseStr) {
        PrintWriter out = null;

        try {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.print(resopseStr);
        } catch (IOException var8) {
            logger.error("系统异常：" + var8.getMessage(), var8);
        } finally {
            if(out != null) {
                out.close();
            }

        }

    }
}
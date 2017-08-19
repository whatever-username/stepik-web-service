package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.xml.transform.Templates;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created by Innokentiy on 15.07.2017.
 */
public class PageGenerator {
    private static String HTML_DIR = "templates";
    private static PageGenerator pageGenerator;
    private static Configuration cfg;
    private PageGenerator(){
        cfg = new Configuration();
    }
    public static PageGenerator getPageGenerator(){
        if (pageGenerator == null){
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }
    public String getPage(String filename, Map<String,Object> data){
        Writer stream = new StringWriter();
        try{
            Template tmp = cfg.getTemplate(HTML_DIR+ File.separator+filename);
            tmp.process(data,stream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

}

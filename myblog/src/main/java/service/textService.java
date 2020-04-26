package service;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dao.io.textio;
import dao.readTextDao;
import domain.text;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * @Author: 杨斌
 * @Date: 2020/3/22 0022 0:53
 */
public class textService {
    readTextDao dao = new readTextDao();

    public List<text> readTitle() {
        List<text> list = dao.findNewFour();
        for (text text : list) {
            String address = text.getTextAddress();
            String s = textio.readText(address);
            s = s.replaceAll("<(/)?(\\w)+>","");
            if(s.length() >100){
                s = s.substring(0, 100);
            }

            text.setTextAddress(s);
        }
        return list;
    }



    public List<text> findTopThree() {
        List<text> list = dao.findTopThree();
        for (text text : list) {
            String address = text.getTextAddress();
            String s = textio.readText(address);
            s = s.replaceAll("<(/)?(\\w)+>","");
            if(s.length() > 50 ){
                s = s.substring(0, 50);
            }
            text.setTextAddress(s);
        }
        return list;
    }

    public List<String> findLabel() {
        List<String> list = dao.findLabel();
        if (list.size() > 10) {
            for (int i = 10; i < list.size(); i++) {
                list.remove(i);
            }
        }
        return list;
    }

    public text findOne(int id) {
        text one = dao.findOneByid(id);
        String s = textio.readText(one.getTextAddress());
        one.setTextAddress(s);
        return one;
    }

    public void save(text t,String title,String main){
        dao.insertText(t);
        textio.writeText(title, main);
    }

}

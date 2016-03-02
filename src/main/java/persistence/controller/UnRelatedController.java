package persistence.controller;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import persistence.daos.UnRelatedDao;
import persistence.entities.Gender;
import persistence.entities.UnRelatedEntity;

@Controller
public class UnRelatedController {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        unRelatedDao.save(new UnRelatedEntity("Sandra", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        unRelatedDao.save(new UnRelatedEntity("Africa", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        unRelatedDao.save(new UnRelatedEntity("Iñigo", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        unRelatedDao.save(new UnRelatedEntity("Antonio", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findOne(entity.getId()));
        System.out.println(entity.toString());
        
        System.out.println("---------------------------");
        System.out.println(unRelatedDao.findByNickIgnoreCase("Mi nick").toString());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println(unRelatedDao.findByNickIgnoreCase("Hola").toString());
        
        System.out.println("---------///////----------");
        System.out.println(unRelatedDao.findById(1).toString());
        System.out.println("---------///---//----------");

        System.out.println(unRelatedDao.count());
        System.out.println(unRelatedDao.findByIdGreaterThan(0, new PageRequest(0,5)).toString());
        //JPQL
        System.out.println("---------JPQL----------");
        System.out.println(unRelatedDao.findAll());
      //SQL
        System.out.println("---------SQL----------");
        System.out.println(unRelatedDao.findAllSQL());
    }
}

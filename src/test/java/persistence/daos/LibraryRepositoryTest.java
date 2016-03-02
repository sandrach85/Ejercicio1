package persistence.daos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import persistence.daos.library.AuthorDao;
import persistence.daos.library.BookDao;
import persistence.daos.library.LibraryRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testPopulate() {
        libraryRepository.populate();
        assertTrue(3 == bookDao.count());
    }

    @After
    public void deleteAll() {
        libraryRepository.deleteAll();
    }
    
    @Test
    public void testAuthor()
    {
    	libraryRepository.populate();
    	assertEquals(authorDao.findNameByAnyBook().toString(),"[Jesús, Cris, Ana]");
    	
    }
}

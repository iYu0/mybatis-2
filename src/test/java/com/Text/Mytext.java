package com.Text;

import com.pj.mapper.Usermapper;
import com.pj.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Mytext {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
    Usermapper usermapper;
    SqlSession sqlSession;

    @Before
    public void opensqlswssion() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Sqlmapconfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        usermapper = sqlSession.getMapper(Usermapper.class);
    }

    @After
    public void close(){
        sqlSession.close();
    }

    @Test
    public void getall(){
        List<Users> list = usermapper.getall();
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void update() throws ParseException {
        Users u = new Users(1,"heheh",sf.parse("2002-9-14"),"2","湖北省");
        int num = usermapper.update(u);
        sqlSession.commit();
    }

    @Test
    public void findbyid(){
        Users u = usermapper.findbyid(1);
        System.out.println(u);
    }

    @Test
    public void getbynamegood(){
       List<Users> list = usermapper.getbynamegood("address","市");
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void insert() throws ParseException {
        Users u = new Users("wuwuwu",sf.parse("2003-2-4"),"2","湖南省");
        int num = usermapper.insert(u);
        sqlSession.commit();
    }

    @Test
    public void delete(){
        int u = usermapper.delete(8);
        System.out.println(u);
    }

}

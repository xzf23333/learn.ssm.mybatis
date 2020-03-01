package my.learn.ssm.mapper;

import my.learn.ssm.pojo.News;

import java.util.List;

public interface NewsMapper {


      public void insert();
      public void delete();
      public void update();
      public List<News> listNews();
      public News selectNewsByKey();


}
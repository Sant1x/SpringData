package com.example.demo.service;

import com.example.demo.dao.PostRepository;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Post;
import com.example.demo.model.SportUser;
import com.example.demo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveSportUser(SportUser sportUser){
        em.persist(sportUser);
    }

    @Transactional
    public void savePost(Post post){
       em.persist(post);
    }

    public List<SportUser> sportUsersList(){
        TypedQuery<SportUser> sportUserTypedQuery = em.createNamedQuery("sportuser.findAllWithHobby",SportUser.class);
        List<SportUser> list = sportUserTypedQuery.getResultList();
        return list;
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findUserBySipmleId(Long id){ return userDao.findUserBySipmleId(id);}
}

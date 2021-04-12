package com.company;

import com.company.dao.AuthorDao;
import com.company.dao.PostDao;
import com.company.dao.RoleDao;
import com.company.model.Author;
import com.company.model.Post;
import com.company.model.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        disableLogging();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwe uzytkownika");
        String username = scan.nextLine();
        Author author = new Author();
        author.setUsername(username);

        System.out.println("Wybierz role: 1 - Admin, 2 - User, 3 - Guest");
        String roleSelected = scan.nextLine();
        Roles roles = null;
        RoleDao roleDao = new RoleDao();
        switch (roleSelected) {
            case "1":
                roles = roleDao.getById(1);
                break;
            case "2":
                roles = roleDao.getById(2);
                break;
            case "3":
                roles = roleDao.getById(3);
                break;
            default:
                roles = roleDao.getById(4);
                break;
        }

        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(roles);
        author.setRoles(rolesList);

        System.out.println("Wpisz swoj post");
        String content = scan.nextLine();
        Post post = new Post();
        post.setContent(content);
        List<Post> postList = new ArrayList<>();
        postList.add(post);
        post.setAuthor(author);
        author.setPosts(postList);

        AuthorDao authorDao = new AuthorDao();
        authorDao.save(author);

        PostDao postDao = new PostDao();
        final List<Post> all = postDao.getAll();
        System.out.println("Wszystkie posty:");
        all.forEach(System.out::println);
    }
    private static void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
    }

}

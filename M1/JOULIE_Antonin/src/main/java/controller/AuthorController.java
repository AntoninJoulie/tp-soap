package main.java.controller;

import main.java.dao.AuthorDAO;
import main.java.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;
    @RequestMapping(value="/author")
    public ModelAndView listAuthor(ModelAndView model) throws IOException {
        List<Author> listAuthor = authorDAO.list();
        model.addObject("listAuthor", listAuthor);
        model.setViewName("author");

        return model;
    }

    @RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
    public ModelAndView newAuthor(ModelAndView model) {
        Author newAuthor = new Author();
        model.addObject("author", newAuthor);
        model.setViewName("AuthorForm");
        return model;
    }

    @RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
    public ModelAndView saveAuthor(@ModelAttribute Author author) {
        authorDAO.saveOrUpdate(author);
        return new ModelAndView("redirect:/author");
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        authorDAO.delete(id);
        return new ModelAndView("redirect:/author");
    }

    @RequestMapping(value = "/editAuthor", method = RequestMethod.GET)
    public ModelAndView editAuthor(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Author author = authorDAO.get(id);
        ModelAndView model = new ModelAndView("AuthorForm");
        model.addObject("author", author);

        return model;
    }

}

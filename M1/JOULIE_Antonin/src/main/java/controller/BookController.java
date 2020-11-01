package main.java.controller;

import main.java.dao.BookDAO;
import main.java.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BookController {


    @Autowired
    private BookDAO bookDAO;
    @RequestMapping(value="/book")
    public ModelAndView listBook(ModelAndView model) throws IOException {
        List<Book> listBook = bookDAO.list();
        model.addObject("listBook", listBook);
        model.setViewName("book");

        return model;
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        Book newBook = new Book();
        model.addObject("book", newBook);
        model.setViewName("BookForm");
        return model;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        bookDAO.saveOrUpdate(book);
        return new ModelAndView("redirect:/book");
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.delete(id);
        return new ModelAndView("redirect:/book");
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public ModelAndView editBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.get(id);
        ModelAndView model = new ModelAndView("BookForm");
        model.addObject("book", book);

        return model;
    }
}

package br.ufc.web._final.controller;

import br.ufc.web._final.model.Produto;
import br.ufc.web._final.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("carrinho")
public class CarrinhoController {

    @Autowired
    PratoService pratoService;

    @RequestMapping(value = "/selecionados")
    public ModelAndView selecionado() {
        ModelAndView mv = new ModelAndView("carrinho/selecionados");
        return mv;
    }

    @RequestMapping(value = "/adicionar/{id}")
    public ModelAndView adicionar(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("carrinho") == null) {
            List<Produto> cart = new ArrayList<>();
            cart.add(new Produto(pratoService.serchById(id), 1L));
            session.setAttribute("carrinho", cart);
        } else {
            List<Produto> cart = (List<Produto>) session.getAttribute("carrinho");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Produto(pratoService.serchById(id), 1L));
            } else {
                Long quantity = cart.get(index).getQuantidade() + 1;
                cart.get(index).setQuantidade(quantity);
            }
            session.setAttribute("carrinho", cart);
        }
        ModelAndView mv = new ModelAndView("redirect:/carrinho/selecionados");
        return mv;
    }

    @RequestMapping(value = "/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id, HttpSession session) {
        List<Produto> cart = (List<Produto>) session.getAttribute("carrinho");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("carrinho", cart);
        ModelAndView mv = new ModelAndView("redirect:/carrinho/selecionados");
        return mv;
    }

    private int exists(Long id, List<Produto> cart) {
        return cart.lastIndexOf(pratoService.serchById(id));
    }

}

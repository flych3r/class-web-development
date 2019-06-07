package br.ufc.web._final.controller;

import br.ufc.web._final.model.Item;
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
@RequestMapping("pedido")
public class CarrinhoController {

    @Autowired
    PratoService pratoService;

    @RequestMapping(value = "/selecionados")
    public ModelAndView selecionado() {
        ModelAndView mv = new ModelAndView("pedido/selecionados");
        return mv;
    }

    @RequestMapping(value = "/adicionar/{id}")
    public ModelAndView adicionar(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("carrinho") == null) {
            List<Item> cart = new ArrayList<>();
            Item item = new Item();
            item.setPrato(pratoService.serchById(id));
            item.setQuantidade(1L);
            item.setPreco(pratoService.serchById(id).getPreco());
            cart.add(item);
            session.setAttribute("carrinho", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("carrinho");
            int index = this.exists(id, cart);
            if (index == -1) {
                Item item = new Item();
                item.setPrato(pratoService.serchById(id));
                item.setQuantidade(1L);
                item.setPreco(pratoService.serchById(id).getPreco());
                cart.add(item);
            } else {
                Long quantidade = cart.get(index).getQuantidade() + 1;
                cart.get(index).setQuantidade(quantidade);
                cart.get(index).setPreco(cart.get(index).getPrato().getPreco() * quantidade);
            }
            session.setAttribute("carrinho", cart);
        }
        ModelAndView mv = new ModelAndView("redirect:/pedido/selecionados");
        return mv;
    }

    @RequestMapping(value = "/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("carrinho");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("carrinho", cart);
        ModelAndView mv = new ModelAndView("redirect:/pedido/selecionados");
        return mv;
    }

    private int exists(Long id, List<Item> cart) {

        for(int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getPrato().getIdPrato() == id)
                return i;
        }

        return -1;
    }

}

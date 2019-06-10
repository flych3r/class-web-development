package br.ufc.web._final.controller;

import br.ufc.web._final.model.Cliente;
import br.ufc.web._final.model.Item;
import br.ufc.web._final.model.Pedido;
import br.ufc.web._final.service.ClienteService;
import br.ufc.web._final.service.ItemService;
import br.ufc.web._final.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/salvar")
    public ModelAndView salvar(HttpSession session) {

        Pedido pedido = new Pedido();
        pedido.setCliente(clienteService.serchById(1L));
        pedido.setTotal(0.0);
        pedidoService.save(pedido);

        Iterable<Item> cart = (Iterable<Item>) session.getAttribute("carrinho");

        Double total = 0.0;
        for (Item item: cart) {

            item.setPedido(pedido);
            total += item.getPreco() * item.getQuantidade();
        }

        itemService.saveAll(cart);

        pedido.setTotal(total);
        pedido.setPendente(1);
        pedidoService.save(pedido);

        session.invalidate();

        ModelAndView mv = new ModelAndView("redirect:/pedido/listar/1");
        return mv;
    }

    @RequestMapping("/listar/{id}")
    public ModelAndView listar(@PathVariable Long id) {

        Cliente cliente = clienteService.serchById(1L);

        List<Pedido> listaPedidos = pedidoService.findCliente(cliente);

        ModelAndView mv = new ModelAndView("pedido/listar_pedidos");
        mv.addObject("listaPedidos", listaPedidos);
        return mv;
    }

    @RequestMapping("/listar_pendente")
    public ModelAndView listarPendente() {

        List<Pedido> listaPedidos = pedidoService.findAll();

        ModelAndView mv = new ModelAndView("pedido/listar_pendente");
        mv.addObject("listaPedidos", listaPedidos);
        return mv;
    }

    @RequestMapping("/enviar/{id}")
    public ModelAndView enviar(@PathVariable Long id) {

        Pedido pedido = pedidoService.serchById(id);

        pedido.setPendente(0);
        pedidoService.save(pedido);

//        ModelAndView mv = new ModelAndView("redirect:pedido/listar_pendente");
        return listarPendente();
    }

}

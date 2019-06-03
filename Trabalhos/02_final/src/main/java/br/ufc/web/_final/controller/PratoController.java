package br.ufc.web._final.controller;

import br.ufc.web._final.model.Prato;
import br.ufc.web._final.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("manager/cadastro_prato");
        mv.addObject("prato", new Prato());
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(Prato prato, @RequestParam(value = "imagem") MultipartFile imagem) {
        pratoService.save(prato, imagem);
        ModelAndView mv = new ModelAndView("redirect:/prato/listar");
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Prato> listaPratos = pratoService.listPratos();
        ModelAndView mv = new ModelAndView("manager/listar_pratos");
        mv.addObject("listaPratos", listaPratos);

        return mv;
    }

    @RequestMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        pratoService.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/prato/listar");
        return mv;
    }

    @RequestMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable Long id) {
        Prato prato = pratoService.serchById(id);
        ModelAndView mv = new ModelAndView("manager/cadastro_prato");
        mv.addObject("prato", prato);
        return mv;
    }

}